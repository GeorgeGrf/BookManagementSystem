package gr.dit.hua.bms.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entities.Course;
import gr.dit.hua.entities.State;
import gr.dit.hua.entities.User;

@Controller
public class SecretaryController {
	String subject;
	
	@RequestMapping("/sBack")
	public String sBack(HttpServletRequest request) {
		return "secretary";
	}
	
	@RequestMapping("/searchState")
	public String searchState(HttpServletRequest request, Model model) {
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		int courseId=Integer.parseInt(request.getParameter("courseId"));
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(State.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(User.class)

				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the course object
			@SuppressWarnings("unchecked")
			List<State> Stateresults = session
		            .createQuery("select c from State c where studentId = :studentId AND courseId=:courseId")
		            .setParameter("studentId", studentId).setParameter("courseId", courseId)
		            .list();
			@SuppressWarnings("unchecked")
			List<User> Studentresults= session
		            .createQuery("select c from User c where id = :studentId")
		            .setParameter("studentId", studentId)
		            .list();
			@SuppressWarnings("unchecked")
			List<Course> Courseresults= session.createQuery("select c from Course c where courseId = :courseId")
		            .setParameter("courseId", courseId)
		            .list();
			String studentName=Studentresults.get(0).getUsername();
			String courseName=Courseresults.get(0).getTitle();
			String state=Stateresults.get(0).getStatus();
			
			
			
			model.addAttribute("studentName", studentName);
			model.addAttribute("courseName", courseName);
			model.addAttribute("state", state);
			return "secretaryResults";
	} finally {
		factory.close();
		session.close();
	}
	
	
	
}}
