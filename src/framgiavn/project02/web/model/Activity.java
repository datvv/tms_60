/**
 * Jul 7, 2016, Activities.java, vuvandat
 */
package framgiavn.project02.web.model;

import java.io.Serializable;

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

}
