/**
 * Jul 7, 2016, TaskBusinessImpl.java, datvv
 */
package framgiavn.project02.web.business.impl;

import java.util.ArrayList;
import java.util.List;
import framgiavn.project02.web.business.TaskBusiness;
import framgiavn.project02.web.dao.TaskDAO;
import framgiavn.project02.web.dao.UserTaskDAO;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class TaskBusinessImpl implements TaskBusiness {

	private TaskDAO taskDAO;
	private UserTaskDAO userTaskDAO;
	private static final Logit2 log = Logit2.getInstance(TaskBusinessImpl.class);

	@Override
	public List<Task> getTasksBySubjectId(int subjectId) {
		try {
			return getTaskDAO().getTasksBySubjectId(subjectId);
		} catch (Exception e) {
			log.error("get task failed ",e);
		}
		return null;
	}

	@Override
	public List<Task> getTasksByUserIdAndSubjectId(int userId, int subjectId) {
		try {
			List<Task> taskList = getTaskDAO().getTasksBySubjectId(subjectId);
			List<Task> taskListResult = new ArrayList<Task>();
			for (Task task : taskList) {
				if (getUserTaskDAO().getUserTaskByUserIdAndTaskId(userId, task.getId()) != null) {
					task.setStatus(true);
				} else {
					task.setStatus(false);
				}
				taskListResult.add(task);
			}
			return taskListResult;
		} catch (Exception e) {
			log.error("get task failed ",e);
		}
		return null;
	}

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	public UserTaskDAO getUserTaskDAO() {
		return userTaskDAO;
	}

	public void setUserTaskDAO(UserTaskDAO userTaskDAO) {
		this.userTaskDAO = userTaskDAO;
	}

}
