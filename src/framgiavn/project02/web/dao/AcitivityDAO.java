/**
 * Jul 11, 2016, AcitivityDAO.java, datvv
 */
package framgiavn.project02.web.dao;

import java.util.List;
import framgiavn.project02.web.model.Activity;

/**
 * @author datvv
 *
 */
public interface AcitivityDAO {
	
	public List<Activity> getAllActivities(int userId) throws Exception;
	
	public void addActivity(Activity activity) throws Exception;
	
	public Activity findActivity(int userId, int targetId, String actionTypeId);
	
	public void deleteActivity(Activity activity);
}
