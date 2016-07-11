/**
 * Jul 15, 2016, SubjectScreenLogic.java, datvv
 */
package framgiavn.project02.web.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import framgiavn.project02.web.constant.ActivityEnum;
import framgiavn.project02.web.constant.TmsContant;
import framgiavn.project02.web.model.Activity;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.model.User;
import framgiavn.project02.web.model.UserSubject;
import framgiavn.project02.web.model.UserTask;

/**
 * @author datvv
 *
 */
public class SubjectScreenLogic {

	public List<Activity> processActivities(Set<Activity> activitySets, List<Task> taskList) {

		List<Activity> activities = new ArrayList<Activity>(activitySets);
		List<Activity> activityListResult = new ArrayList<Activity>();
		for (Activity activity : activities) {
			if (ActivityEnum.TASK.equals(ActivityEnum.findByKey(Integer.parseInt(activity.getActionType())))) {
				for (Task task : taskList) {
					if (task.getId() == activity.getTargetId()) {
						activity.setContent(TmsContant.TASK_ACTIVITY + task.getName());
					}
				}
			}
			activityListResult.add(activity);
		}
		return activityListResult;
	}

	public List<Activity> processActivities(List<Activity> activities, List<Task> taskList) {

		List<Activity> activityListResult = new ArrayList<Activity>();
		for (Activity activity : activities) {
			if (ActivityEnum.TASK.equals(ActivityEnum.findByKey(Integer.parseInt(activity.getActionType())))) {
				for (Task task : taskList) {
					if (task.getId() == activity.getTargetId()) {
						activity.setContent(TmsContant.TASK_ACTIVITY + task.getName());
					}
				}
			}
			activityListResult.add(activity);
		}
		return activityListResult;
	}

	public List<Task> processTaskStatus(User user, UserSubject userSubject, Set<Task> taskSets) {

		List<Task> tasks = new ArrayList<Task>(taskSets);
		List<Task> taskList = new ArrayList<Task>();
		for (Task task : tasks) {
			Set<UserTask> userTaskSet = task.getUserTasks();
			if (userTaskSet == null) {
				task.setStatus(false);
			} else {
				for (Iterator iter = userTaskSet.iterator(); iter.hasNext();) {
					UserTask userTask = (UserTask) iter.next();
					if (userTask.getUserId() == user.getId() && userTask.getUserSubjectId() == userSubject.getId()) {
						task.setStatus(true);
					} else {
						task.setStatus(false);
					}
				}
			}
			taskList.add(task);
		}
		return taskList;
	}

	public List<User> getListUsersByRoleInClass(Set<UserSubject> userSubjectSet, String role) {

		List<UserSubject> userSubjectList = new ArrayList<UserSubject>(userSubjectSet);
		HashSet<User> userSet = new HashSet<User>(0);
		for (UserSubject userSubject : userSubjectList) {
			User user = userSubject.getUser();
			if (user.getRole().equals(role)) {
				userSet.add(user);
			}
		}
		List<User> userList = new ArrayList<User>(userSet);
		return userList;
	}
}
