package gr.dit.hua.bms.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entities.Book;
import gr.dit.hua.entities.Course;
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
				boolean foundBook1=false;
				boolean foundBook2=false;
				for (int i=0;(i<books.size());i++) {
					Book testbook=books.get(i);
					if (testbook.getId()==id1) {
						book1=testbook;
						foundBook1 =true;
					} else if (testbook.getId()==id2){
						book2=testbook;
						foundBook2 =true;
					}
					
					if(testbook.getCourseId() == dbcourse.getCourseId()) {
						coursebooks.add(testbook.getTitle());
					}
					
				}
				
				/*List<Book> book1 =session
			            .createQuery("select b from Book b")
			            .list();
				Book dbbook1 = (Book) book1.get(0);
				
				List<Book> book2 = session
			            .createQuery("select b from Book b where bookId = :b2")
			            .setParameter("b2", id2)
			            .list();
				Book dbbook2 = (Book) book2.get(0);
*/
				
				model.addAttribute("book1", book1.getTitle());
				model.addAttribute("book2", book2.getTitle());
				model.addAttribute("listbooks", coursebooks);
				session.getTransaction().commit();
				return "bookOptions";
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
		int id1 = 0, id2 = 0;
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class).addAnnotatedClass(Book.class)
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
				if (testbook.getTitle().toString()==book1) {
					id1=testbook.getId();
				} else if (testbook.getTitle().toString()==book2){
					id2=testbook.getId();
				}
			}
				
			if (id1 != 0 && id2 != 0) {
				
				dbcourse.setBook1(id1);
				dbcourse.setBook2(id2);
				session.update(dbcourse);
				
				// commit transaction
				session.getTransaction().commit();
				return "lecturer";
			} else {
				System.out.println("Titles 1 or 2 are 0");
			}
			
		} finally {
			factory.close();
		}
		return " ";
		
	}
	
	
}
