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

}
