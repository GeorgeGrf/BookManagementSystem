package gr.dit.hua.entities;
// Generated Dec 29, 2018 12:45:02 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StateId generated by hbm2java
 */
@Embeddable
public class StateId implements java.io.Serializable {

	private int studentId;
	private int courseId;

	public StateId() {
	}

	public StateId(int studentId, int courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	@Column(name = "studentId", nullable = false)
	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column(name = "courseId", nullable = false)
	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StateId))
			return false;
		StateId castOther = (StateId) other;

		return (this.getStudentId() == castOther.getStudentId()) && (this.getCourseId() == castOther.getCourseId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getStudentId();
		result = 37 * result + this.getCourseId();
		return result;
	}

}