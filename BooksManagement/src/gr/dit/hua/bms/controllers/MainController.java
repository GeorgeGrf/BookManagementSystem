package gr.dit.hua.bms.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import gr.dit.hua.entities.Course;
import gr.dit.hua.entities.User;

@Controller
public class MainController {
	
	
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
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();

			// get the student object with the username that the user gave
			List results = session
		            .createQuery("select us from User us where us.username = :username")
		            .setParameter("username", name)
		            .list();
			User dbuser = (User) results.get(0);
			
			if (dbuser.getPassword().equals(pwd) && dbuser != null)  {
				String role = dbuser.getRole();
				String username = dbuser.getUsername();
				model.addAttribute("name", username);
				
				List<String> courses = new ArrayList<>();
				String str = dbuser.getCourses();
				StringTokenizer tokenizer = new StringTokenizer(str, " ");
				while (tokenizer.hasMoreElements()) {
			        String course = session.get(Course.class, new Integer(tokenizer.nextToken()) ).getTitle();
			        courses.add(course);
			    }
				model.addAttribute("courses", courses);
				
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
