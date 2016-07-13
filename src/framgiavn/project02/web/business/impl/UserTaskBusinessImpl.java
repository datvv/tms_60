/**
 * Jul 8, 2016, UserTaskBusiness.java, datvv
 */
package framgiavn.project02.web.business.impl;

import java.util.List;

import framgiavn.project02.web.business.UserTaskBusiness;
import framgiavn.project02.web.constant.ActivityEnum;
import framgiavn.project02.web.dao.AcitivityDAO;
import framgiavn.project02.web.dao.UserTaskDAO;
import framgiavn.project02.web.model.Activity;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.model.UserTask;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class UserTaskBusinessImpl implements UserTaskBusiness {

	private UserTaskDAO userTaskDAO;
	private AcitivityDAO activityDAO;
	private static final Logit2 log = Logit2.getInstance(UserTaskBusinessImpl.class);

	@Override
	public boolean checkExistUserTaskByUserIdAndTaskId(int userId, int taskId) {
		try {
			UserTask userTask = userTaskDAO.getUserTaskByUserIdAndTaskId(userId, taskId);
			if (userTask != null) {
				return true;
			}
		} catch (Exception e) {
			log.error("get failed ", e);
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
				if (!task.getStatus() && userTask != null) {
					Activity activity = activityDAO.findActivity(userId, userTask.getId(),
							String.valueOf(ActivityEnum.TASK.number));
					if (activity != null) {
						activityDAO.deleteActivity(activity);
					}
					getUserTaskDAO().deleteUserTaskByUserTask(userTask);
				} else if (task.getStatus() && userTask == null) {
					userTask = new UserTask(userId, task.getId(), userSubjectId);
					getUserTaskDAO().addUserTask(userTask);
					userTask = getUserTaskDAO().getUserTaskByUserIdAndTaskId(userId, task.getId());
					if (userTask != null) {
						Activity activity = new Activity(userId, userTask.getId(),
								String.valueOf(ActivityEnum.TASK.number));
						activityDAO.addActivity(activity);
					}
				}
			}
		} catch (Exception e) {
			log.error("edit task status failed ", e);
		}
	}

	public AcitivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(AcitivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

}
