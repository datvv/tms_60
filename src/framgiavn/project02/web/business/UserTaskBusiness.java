/**
 * Jul 8, 2016, UserTaskBusiness.java, datvv
 */
package framgiavn.project02.web.business;

import framgiavn.project02.web.model.UserTask;

/**
 * @author datvv
 *
 */
public interface UserTaskBusiness {

	public boolean checkExistUserTaskByUserIdAndTaskId(int userId, int taskId);
}
