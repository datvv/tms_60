/**
 * Jul 7, 2016, UserTaskDAO.java, vuvandat
 */
package framgiavn.project02.web.dao;

import framgiavn.project02.web.model.UserTask;

/**
 * @author vuvandat
 *
 */
public interface UserTaskDAO {

	public UserTask getUserTaskByUserIdAndTaskId(int userId, int taskId) throws Exception;
}
