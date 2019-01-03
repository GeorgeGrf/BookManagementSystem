package gr.dit.hua.bms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String adminPage( ) {
		return "admin";
	}
	
	@RequestMapping("/pickSubject")
	public String pickSubject(HttpServletRequest request, Model model) {
		String subject = request.getParameter("subject");
		//speak with db to get the books for this subject
		return "bookOptions";
	}
	
	@RequestMapping("/pickBooks")
	public String pickBooks(HttpServletRequest request, Model model) {
		String book1 = request.getParameter("choice1");
		String book2 = request.getParameter("choice2");
		//update db with those ^

		return "lecturer";
	}
	
	@RequestMapping("/")
	public String loginPage( ) {
		return "loginPage";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		//speak with the db
		//return the role of the user back to insert below to the return "...";
		
		return " ";
	}
	
	@RequestMapping("/")
	public String publisherPage( ) {
		return "publisher";
	}
	
	
	
	
	
	
	
	
}
