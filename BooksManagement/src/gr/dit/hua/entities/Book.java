package gr.dit.hua.entities;
// Generated Dec 29, 2018 12:45:02 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name = "Book", catalog = "books_management")
public class Book implements java.io.Serializable {

	private int publisherId;
	private int bookId;
	private int quantity;
	private int courseId;
	private Boolean isAvailable;
	private String city;
	private String street;
	private int no;
	private String title;
	
	public Book() {
	}

	public Book(int publisherId, int bookId,String title, int quantity , String city, String street, int no) {
		this.publisherId=publisherId;
		this.bookId=bookId;
		this.quantity=quantity;
		this.city=city;
		this.street=street;
		this.no=no;
		this.title=title;
		if (quantity>0) {
			this.isAvailable=true;
		} else {this.isAvailable=false;}
	}
	
	public Book(int bookId) {
		this.bookId = bookId;
	}

	public Book(int publisherId, int bookId, int quantity, int courseId, Boolean isAvailable, String city, String street, int no, String title) {
		this.publisherId = publisherId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.title = title;
		this.courseId = courseId;
		this.isAvailable = isAvailable;
		this.city = city;
		this.street = street;
		this.no = no;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "bookId")
	public int getId() {
		return this.bookId;
	}

	public void setId(int bookId) {
		this.bookId = bookId;
	}
	
	@Column(name = "publisherId", nullable = false)
	public int getpublisherId() {
		return this.publisherId;
	}

	public void setpublisherId(int pID) {
		this.publisherId = pID;
	}
	
	
	@Column(name = "quantity")
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title= title;
	}
	
	@Column(name = "courseId")
	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Column(name = "isAvailable")
	public Boolean getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Column(name = "city", length = 10)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "street", length = 10)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "no")
	public int getNo() {
		return this.no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
