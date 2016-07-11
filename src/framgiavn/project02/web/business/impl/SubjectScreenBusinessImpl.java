/**
 * Jul 15, 2016, SubjectScreenBusinessImpl.java, datvv
 */
package framgiavn.project02.web.business.impl;

import java.util.List;
import framgiavn.project02.web.business.SubjectScreenBusiness;
import framgiavn.project02.web.constant.ActivityEnum;
import framgiavn.project02.web.dao.AcitivityDAO;
import framgiavn.project02.web.dao.UserSubjectDAO;
import framgiavn.project02.web.dao.UserTaskDAO;
import framgiavn.project02.web.model.Activity;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.model.UserSubject;
import framgiavn.project02.web.model.UserTask;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class SubjectScreenBusinessImpl implements SubjectScreenBusiness {

	private UserSubjectDAO userSubjectDAO;
	private UserTaskDAO userTaskDAO;
	private AcitivityDAO activityDAO;
	private static final Logit2 log = Logit2.getInstance(SubjectScreenBusinessImpl.class);

	@Override
	public UserSubject getUserSubjectByUserSubjectId(int userSubjectId) {
		try {
			return getUserSubjectDAO().getUserSubjectByUserSubjectId(userSubjectId);
		} catch (Exception e) {
			log.error("get userSubject failed ", e);
		}
		return null;
	}

	@Override
	public UserSubject getUserSubjectByUserSubjectCourse(int userId, int subjectId, int courseId) {
		try {
			return getUserSubjectDAO().getUserSubjectByUserSubjectCourse(userId, subjectId, courseId);
		} catch (Exception e) {
			log.error("get userSubject failed ", e);
		}
		return null;
	}

	@Override
	public List<Activity> editTaskStatus(int userId, List<Task> taskList, UserSubject userSubject) {
		try {
			List<Activity> activityList;
			for (Task task : taskList) {
				UserTask userTask = userTaskDAO.getUserTaskByUserIdAndTaskId(userId, task.getId());
				if (!task.getStatus() && userTask != null) {
					Activity activity = activityDAO.findActivity(userId, userTask.getTaskId(),
							String.valueOf(ActivityEnum.TASK.number));
					if (activity != null) {
						activityDAO.deleteActivity(activity);
					}
					getUserTaskDAO().deleteUserTaskByUserTask(userTask);
				} else if (task.getStatus() && userTask == null) {
					userTask = new UserTask(userId, task.getId(), userSubject.getId());
					getUserTaskDAO().addUserTask(userTask);
					userTask = getUserTaskDAO().getUserTaskByUserIdAndTaskId(userId, task.getId());
					if (userTask != null) {
						Activity activity = new Activity(userId, userTask.getTaskId(),
								String.valueOf(ActivityEnum.TASK.number));
						activityDAO.addActivity(activity);
					}
				}
			}
			activityList = activityDAO.getAllActivities(userId);
			return activityList;
		} catch (Exception e) {
			log.error("edit task status failed ", e);
		}
		return null;
	}

	public UserTaskDAO getUserTaskDAO() {
		return userTaskDAO;
	}

	public void setUserTaskDAO(UserTaskDAO userTaskDAO) {
		this.userTaskDAO = userTaskDAO;
	}

	public AcitivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(AcitivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	public UserSubjectDAO getUserSubjectDAO() {
		return userSubjectDAO;
	}

	public void setUserSubjectDAO(UserSubjectDAO userSubjectDAO) {
		this.userSubjectDAO = userSubjectDAO;
	}

}
