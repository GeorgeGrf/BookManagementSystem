package gr.dit.hua.bms.controllers;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entities.Book;
import gr.dit.hua.entities.State;
import gr.dit.hua.entities.User;



@Controller
public class PublisherController {
	
	@RequestMapping("/addNewBooks")
	public String pickSubject(HttpServletRequest request) {
		return("addNewBooks");
	}
	
	
	@RequestMapping("/pBack")
	public String pBack(HttpServletRequest request) {
		return("publisher");
	}
	
	
	@RequestMapping("/editBooks")
	public String addQuantity(HttpServletRequest request) {
		return("stock");
	}
	
	
	@RequestMapping("/delivery")
	public String conDelivery(HttpServletRequest request) {
		return("delivery");
	}
	
	
	@RequestMapping("/modQuantity")
	public String modQuantity(HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();

			// get the student object
			
			
			Query query=session.createQuery("UPDATE Book SET quantity=:quantity  WHERE bookId =:bookid").setParameter("quantity", quantity).setParameter("bookid", id);
			query.executeUpdate();
				
				// commit transaction
				session.getTransaction().commit();
				return "publisher";
			
			
		} finally {
			session.close();
			factory.close();
		}
	}
	
	
	
	
	
	@RequestMapping("/modDelivery")
	public String delivery(HttpServletRequest request) {
		
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class).addAnnotatedClass(State.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();

			// get the student object
			
			
			Query query1=session.createQuery("UPDATE Book SET quantity=quantity-1  WHERE bookId =:bookid").setParameter("bookid", bookId);
			Query query2=session.createQuery("UPDATE State SET status='Book Delivered'  WHERE studentId =:studentId").setParameter("studentId", studentId);
			
			query1.executeUpdate();
			query2.executeUpdate();
				// commit transaction
				session.getTransaction().commit();
				return "publisher";
			
			
		} finally {
			session.close();
			factory.close();
		}
	}
	
	
		
	
	
	
	
	
	
	
	@RequestMapping("/enterBook")
	public String enterBooks(HttpServletRequest request) {
		
		 int bookId=Integer.parseInt(request.getParameter("BookId"));
		 String bookTitle=request.getParameter("BookTitle");
		int bookQuantity=Integer.parseInt(request.getParameter("BookQuantity"));
		 String bookCity=request.getParameter("BookCity");
		 String bookStreet=request.getParameter("BookStreet");
		 int bookNo=Integer.parseInt(request.getParameter("BookNumber"));
		 Book newBook=new Book(3,bookId,bookTitle,bookQuantity,bookCity,bookStreet,bookNo);
		
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
			Session session = factory.getCurrentSession();
			try {
				// start a transaction
				session.beginTransaction();

				// get the student object
				
				
				session.save(newBook);
				
					
					// commit transaction
					session.getTransaction().commit();
					return "publisher";
				
				
			} finally {
				session.close();
				factory.close();
			}
			
		}
	
	
	
}
		
		


