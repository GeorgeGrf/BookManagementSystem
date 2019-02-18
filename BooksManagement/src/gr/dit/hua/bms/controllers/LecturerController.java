package gr.dit.hua.bms.controllers;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entities.Book;
import gr.dit.hua.entities.BookId;
import gr.dit.hua.entities.Course;
import gr.dit.hua.entities.User;

public class LecturerController {

	String subject;
	
	
	@RequestMapping("/pickSubject")
	public String pickSubject(HttpServletRequest request, Model model) {
		subject = request.getParameter("subject");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();

			// get the student object
			Course dbcourse = session.get(Course.class, subject);
			if (dbcourse != null) {
				session.getTransaction().commit();
				return "bookOptions";
			} else {
				System.out.println("Course is empty");
				return "lecturer";
			}

			
		} finally {
			factory.close();
		}
		
	}
	
	
	@RequestMapping("/pickBooks")
	public String pickBooks(HttpServletRequest request, Model model) {
		String book1 = request.getParameter("choice1");
		String book2 = request.getParameter("choice2");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();

			// get the student object
			int title1 = session.get(Book.class, book1).getId().getBookId();
			int title2 = session.get(Book.class, book2).getId().getBookId();
			if (title1 != 0 && title1 != 0) {
				Course dbcourse = session.get(Course.class, subject);
				dbcourse.setBook1(title1);
				dbcourse.setBook2(title1);
				session.update(dbcourse);
				
				// commit transaction
				session.getTransaction().commit();
				return "lecturer";
			} else {
				System.out.println("Titles 1 or 2 are 0");
			}

		} finally {
			factory.close();
			return " ";
		}
		
	}
	
	
	
}
