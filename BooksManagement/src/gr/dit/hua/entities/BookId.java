package gr.dit.hua.entities;
// Generated Dec 29, 2018 12:45:02 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BookId generated by hbm2java
 */
@Embeddable
public class BookId implements java.io.Serializable {

	private int bookId;
	private int publisherId;

	public BookId() {
	}

	public BookId(int bookId, int publisherId) {
		this.bookId = bookId;
		this.publisherId = publisherId;
	}

	@Column(name = "bookId", nullable = false)
	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Column(name = "publisherId", nullable = false)
	public int getPublisherId() {
		return this.publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BookId))
			return false;
		BookId castOther = (BookId) other;

		return (this.getBookId() == castOther.getBookId()) && (this.getPublisherId() == castOther.getPublisherId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getBookId();
		result = 37 * result + this.getPublisherId();
		return result;
	}

}
