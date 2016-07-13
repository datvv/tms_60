/**
 * Jul 11, 2016, ActivityBusinessImpl.java, datvv
 */
package framgiavn.project02.web.business.impl;

import java.util.ArrayList;
import java.util.List;
import framgiavn.project02.web.business.ActivityBusiness;
import framgiavn.project02.web.constant.ActivityEnum;
import framgiavn.project02.web.constant.TmsContant;
import framgiavn.project02.web.dao.AcitivityDAO;
import framgiavn.project02.web.dao.TaskDAO;
import framgiavn.project02.web.model.Activity;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class ActivityBusinessImpl implements ActivityBusiness {

	private AcitivityDAO activityDAO;
	private TaskDAO taskDAO;
	private static final Logit2 log = Logit2.getInstance(ActivityBusinessImpl.class);

	@Override
	public List<Activity> getAllActivities(int userId) {
		try {
			List<Activity> activityListResult = new ArrayList<Activity>();
			List<Activity> activityList = getActivityDAO().getAllActivities(userId);
			for (Activity activity : activityList) {
				if (ActivityEnum.TASK.equals(ActivityEnum.findByKey(Integer.parseInt(activity.getActionType())))) {
					Task task = taskDAO.getTasByUserTaskId(activity.getTargetId());
					if (task != null) {
						activity.setContent(TmsContant.TASK_ACTIVITY + task.getName());
					}
				}
				activityListResult.add(activity);
			}
			return activityListResult;
		} catch (Exception e) {
			log.error("get all activities failed ", e);
		}
		return null;
	}

	@Override
	public void addActivity(Activity activity) {
		try {
			getActivityDAO().addActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AcitivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(AcitivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

}
