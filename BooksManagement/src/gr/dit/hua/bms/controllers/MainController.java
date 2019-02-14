package gr.dit.hua.bms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entities.BookId;
import gr.dit.hua.entities.Course;
import gr.dit.hua.entities.User;

@Controller
public class MainController {

	// these mappings are gonna be removed when admin and publisher are utilized, loginPage stays
	@RequestMapping("/")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/")
	public String publisherPage() {
		return "publisher";
	}

	// ^ removed soon
	
	@RequestMapping("/")
	public String loginPage() {
		return "loginPage";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		// speak with the db
		// return the role of the user back to insert below to the return "...";
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();

			// get the student object
			User dbuser = session.get(User.class, name);
			if (dbuser.getPassword() == pwd && dbuser != null) {
				String role = dbuser.getRole();
				return role;
			} else if (dbuser == null) {
				System.out.println("User was not found in the database");
			} else {
				System.out.println("Password is wrong");
			}

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
		return " ";
	}

}
