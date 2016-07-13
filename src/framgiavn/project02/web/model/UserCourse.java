package framgiavn.project02.web.model;

import java.io.Serializable;

/**
 * @author nguyenanhvan
 *
 */
public class UserCourse implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int userId;
	private int courseId;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
