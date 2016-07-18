/**
 * Jul 7, 2016, Activities.java, vuvandat
 */
package framgiavn.project02.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author vuvandat
 *
 */
public class Activity implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int userId;
	private int targetId;
	private String actionType;
	private String content;
	private Date createAt;
	private Date updateAt;
	private User user;

	public Activity() {
		super();
	}

	public Activity(int userId, int targetId, String actionType) {
		super();
		this.userId = userId;
		this.targetId = targetId;
		this.actionType = actionType;
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

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
