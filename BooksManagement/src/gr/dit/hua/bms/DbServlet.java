package gr.dit.hua.bms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
        
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(" Unable to load driver. ");
        }
        String url = "jdbc:mysql://www.db4free.net:3306/books_management";
        String username = "iaksroot";
        String password = "iakspwd1";
        try {
           	conn = DriverManager.getConnection(url, username, password);
            System.out.println(" Connection Established. ");
        } catch (SQLException e) {
            System.out.println(" Error connecting to database:  "
                    + e);
        }
        
        
        
        
        // get connection to db
      /* try {
                PrintWriter out = response.getWriter();
                out.println("Connecting to db: " + jdbcUrl);
                Class.forName(driver);
                Connection con = DriverManager.getConnection(jdbcUrl,user,pass);
                out.println("success");
                con.close();
        }
        catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
       } */
	}
}

