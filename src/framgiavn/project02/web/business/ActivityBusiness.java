/**
 * Jul 11, 2016, ActivityBusiness.java, datvv
 */
package framgiavn.project02.web.business;

import java.util.List;
import framgiavn.project02.web.model.Activity;

/**
 * @author datvv
 *
 */
public interface ActivityBusiness {

	public List<Activity> getAllActivities(int userId);

	public void addActivity(Activity activity);
}
