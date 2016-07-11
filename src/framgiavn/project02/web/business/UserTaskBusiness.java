/**
 * Jul 8, 2016, UserTaskBusiness.java, datvv
 */
package framgiavn.project02.web.business;

import java.util.List;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.model.UserTask;

/**
 * @author datvv
 *
 */
public interface UserTaskBusiness {

	public boolean checkExistUserTaskByUserIdAndTaskId(int userId, int taskId);
	
	public void editTaskStatus(int userId, List<Task> taskList, int userSubjectId);
}
