/**
 * Jul 7, 2016, CourseSubject.java, vuvandat
 */
package framgiavn.project02.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vuvandat
 *
 */
public class CourseSubject implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int courseId;
	private int subjectId;
	private String status;
	private Set<UserSubject> userSubjects = new HashSet<UserSubject>(0);
	private Subject subject;
	private Course course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<UserSubject> getUserSubjects() {
		return userSubjects;
	}

	public void setUserSubjects(Set<UserSubject> userSubjects) {
		this.userSubjects = userSubjects;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
