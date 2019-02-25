package gr.dit.hua.bms.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entities.Book;
import gr.dit.hua.entities.Course;
import gr.dit.hua.entities.State;
import gr.dit.hua.entities.User;

@Controller
public class LecturerController {

	String subject;

	
		
		
		
	@RequestMapping("/pickSubject")
	public String pickSubject(HttpServletRequest request, Model model) {
		subject = request.getParameter("subject");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class).addAnnotatedClass(Book.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the course object
			List results = session
		            .createQuery("select c from Course c where c.title = :title")
		            .setParameter("title", subject)
		            .list();

			Course dbcourse = (Course) results.get(0);
			if (subject != null) {
				@SuppressWarnings("unchecked")
				List<Book> books=session
			            .createQuery("select b from Book b")
			            .list();
				List<String> coursebooks = new ArrayList<>();
				int id1 = dbcourse.getBook1();
				int id2 = dbcourse.getBook2();
				Book book1=new Book();
				Book book2=new Book();
				for (int i=0;(i<books.size());i++) {
					Book testbook=books.get(i);
					if (testbook.getId()==id1) {
						book1=testbook;
					} else if (testbook.getId()==id2){
						book2=testbook;

					}
					
					if(testbook.getCourseId() == dbcourse.getCourseId()) {
						coursebooks.add(testbook.getTitle());
					}
					
				}
				if ((book1.getId()==5)||(book2.getId()==5)){
					model.addAttribute("listbooks", books);
					session.getTransaction().commit();
					return "bookOptions";
					
				}else {

				
				model.addAttribute("book1", book1.getTitle());
				model.addAttribute("book2", book2.getTitle());
				session.getTransaction().commit();
				return "booksAssigned";}
			} else {
				System.out.println("Course is empty");
				return "lecturer";
			}

		} finally {
			factory.close();
			session.close();
		}
		
	}
	
	
	@RequestMapping("/pickBooks")
	public String pickBooks(HttpServletRequest request, Model model) {
		String book1 = request.getParameter("choice1");
		String book2 = request.getParameter("choice2");
		if (book1.compareTo(book2)==0) {
			return "lecturerError";
		} else if (book1.compareTo("Not Selected")==0) {
			return "lecturerError";
		} else if (book2.compareTo("Not Selected")==0){
			return "lecturerError";
		}
		int id1 = 5,id2=5;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(State.class).addAnnotatedClass(Course.class).addAnnotatedClass(Book.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();

			// get the student object
			List courses = session
		            .createQuery("select c from Course c where c.title = :title")
		            .setParameter("title", subject)
		            .list();

			Course dbcourse = (Course) courses.get(0);
			@SuppressWarnings("unchecked")
			List<Book> books=session
			           .createQuery("select b from Book b")
			           .list();
			for (int i=0;(i<books.size());i++) {
				Book testbook=books.get(i);
				if (testbook.getTitle().toString().compareTo(book1)==0) {
					id1=testbook.getId();
				} else if (testbook.getTitle().toString().compareTo(book2)==0){
					id2=testbook.getId();
				}
			}
				
			
				
				dbcourse.setBook1(id1);
				dbcourse.setBook2(id2);
				session.saveOrUpdate(dbcourse);
				Query query=session.createQuery("UPDATE State SET status='Books are available'  WHERE courseId =:courseId").setParameter("courseId",dbcourse.getCourseId() );
			    query.executeUpdate();
				
				
				// commit transaction
				session.getTransaction().commit();
				return "lecturerSuccess";
			
			
		} finally {
			factory.close();
		}
		
	}
	
	
}
