package gr.dit.hua.entities;
// Generated Dec 29, 2018 12:45:02 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "User", catalog = "books_management")
public class User implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private String role;
	private Integer courses;

	public User() {
	}

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User(String username, String password, String role, Integer courses) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.courses = courses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "role", nullable = false, length = 10)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "courses")
	public Integer getCourses() {
		return this.courses;
	}

	public void setCourses(Integer courses) {
		this.courses = courses;
	}

	public void addUser(User user) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(user);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}
	
	
	public int addUser() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
			User user=this;
			int success=1;
		try {
			
			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(user);

			// commit transaction
			session.getTransaction().commit();
			success=0;

		} finally {
			factory.close();
			
		}
		return success;

	}
	
	public List nameSearch(String name) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		List list;      
		        try {			
					// start a transaction
					session.beginTransaction();
					// save the student object
			        Query query = session.createQuery("select id, username, role from User where username like '%"+name+"%' ");		
			        list = query.list();
				} finally {
					factory.close();
				
				}
				return list;
			}
		 
		
	public List roleSearch(String role) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		List list;      
		        try {			
					// start a transaction
					session.beginTransaction();
					// save the student object
			        Query query = session.createQuery("select id, username, role from User where role='"+role+"' ");		
			        list = query.list();
				} finally {
					factory.close();
				
				}
				return list;
			}    

		
	}
	
	
	
	
	
