package gr.dit.hua.bms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.dit.hua.entities.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
@RequestMapping("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @RequestMapping(params="nameSearch",  method = RequestMethod.GET)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String srcName=request.getParameter("srcName");
		List list=(new User()).nameSearch(srcName);
		System.out.println();

	}
    
    
    @RequestMapping(params="roleSearch",  method = RequestMethod.GET)
   	protected void roleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	String srcRole=request.getParameter("srcRole");
   		List list=(new User()).roleSearch(srcRole);
   		System.out.println();

   	}
    
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@RequestMapping(params="addUser",  method = RequestMethod.POST)
	protected void addPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username=request.getParameter("newUsr");
		String Password=request.getParameter("newPwd");
		String Role=request.getParameter("role");
		User user=new User(Username,Password,Role);
		PrintWriter out = response.getWriter();
		if(user.addUser()==0) {
			out.println("User added to database.");
		} else {
			out.println("Error,user not added to database.");
		}
		
		
	}

}
