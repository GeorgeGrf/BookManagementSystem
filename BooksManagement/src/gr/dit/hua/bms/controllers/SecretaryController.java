package gr.dit.hua.bms.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import gr.dit.hua.entities.State;

@Controller
public class SecretaryController {

	@RequestMapping("/searchState")
	public String pickSubject(HttpServletRequest request) {
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		int courseId=Integer.parseInt(request.getParameter("courseId"));
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(State.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the course object
			List results = session
		            .createQuery("select c from State c where studentId = :studentId AND courseId=:courseId")
		            .setParameter("studentId", studentId).setParameter("courseId", courseId)
		            .list();
		
	} finally {
		factory.close();
		session.close();
	}
	
	return "";
	
}}
