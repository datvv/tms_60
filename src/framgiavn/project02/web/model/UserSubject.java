/**
 * Jul 9, 2016, UserSubject.java, datvv
 */
package framgiavn.project02.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author datvv
 *
 */
public class UserSubject implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int userId;
	private int courseSubjectId;
	private String status;
	private Set<UserTask> userTasks = new HashSet<UserTask>(0);
	private CourseSubject courseSubject;
	private User user;

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

	public int getCourseSubjectId() {
		return courseSubjectId;
	}

	public void setCourseSubjectId(int courseSubjectId) {
		this.courseSubjectId = courseSubjectId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CourseSubject getCourseSubject() {
		return courseSubject;
	}

	public void setCourseSubject(CourseSubject courseSubject) {
		this.courseSubject = courseSubject;
	}

	public Set<UserTask> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(Set<UserTask> userTasks) {
		this.userTasks = userTasks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
