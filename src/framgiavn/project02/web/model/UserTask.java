/**
 * Jul 7, 2016, UserTask.java, vuvandat
 */
package framgiavn.project02.web.model;

import java.io.Serializable;

/**
 * @author vuvandat
 *
 */
public class UserTask implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int userId;
	private int taskId;
	private int userSubjectId;
	private UserSubject userSubject;
	private Task task;
	private User user;

	public UserTask() {
		super();
	}

	public UserTask(int userId, int taskId, int userSubjectId) {
		super();
		this.userId = userId;
		this.taskId = taskId;
		this.userSubjectId = userSubjectId;
	}

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

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserSubjectId() {
		return userSubjectId;
	}

	public void setUserSubjectId(int userSubjectId) {
		this.userSubjectId = userSubjectId;
	}

	public UserSubject getUserSubject() {
		return userSubject;
	}

	public void setUserSubject(UserSubject userSubject) {
		this.userSubject = userSubject;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
