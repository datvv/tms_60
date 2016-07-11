/**
 * Jul 8, 2016, UserTaskBusiness.java, datvv
 */
package framgiavn.project02.web.business.impl;

import java.util.List;

import framgiavn.project02.web.business.UserTaskBusiness;
import framgiavn.project02.web.dao.UserTaskDAO;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.model.UserTask;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class UserTaskBusinessImpl implements UserTaskBusiness {

	private UserTaskDAO userTaskDAO;
	private static final Logit2 log = Logit2.getInstance(UserTaskBusinessImpl.class);

	@Override
	public boolean checkExistUserTaskByUserIdAndTaskId(int userId, int taskId) {
		try {
			UserTask userTask = userTaskDAO.getUserTaskByUserIdAndTaskId(userId, taskId);
			if(userTask != null ){
				return true;
			}
		} catch (Exception e) {
			log.error("get failed ",e);
		}
		return false;
	}

	public UserTaskDAO getUserTaskDAO() {
		return userTaskDAO;
	}

	public void setUserTaskDAO(UserTaskDAO userTaskDAO) {
		this.userTaskDAO = userTaskDAO;
	}

	@Override
	public void editTaskStatus(int userId, List<Task> taskList, int userSubjectId) {
		try {
			for (Task task : taskList) {
				UserTask userTask = userTaskDAO.getUserTaskByUserIdAndTaskId(userId, task.getId());
				if(!task.getStatus() && userTask != null ){
					getUserTaskDAO().deleteUserTaskByUserTask(userTask);
				}
				if(task.getStatus() && userTask == null ){
					userTask = new UserTask(userId,task.getId(),userSubjectId);
					getUserTaskDAO().addUserTask(userTask);
				}
			}
		} catch (Exception e) {
		}
	}

}
