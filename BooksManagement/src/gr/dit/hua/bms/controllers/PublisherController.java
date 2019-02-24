package gr.dit.hua.bms.controllers;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entities.Book;



@Controller
public class PublisherController {
	
	@RequestMapping("/addNewBooks")
	public String pickSubject(HttpServletRequest request) {
		return("addNewBooks");
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
		
		


