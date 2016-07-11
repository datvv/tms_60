/**
 * Jul 7, 2016, CourseSubject.java, vuvandat
 */
package framgiavn.project02.web.model;

import java.io.Serializable;

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

}
