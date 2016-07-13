/**
 * Jul 11, 2016, ActivityDAOImpl.java, datvv
 */
package framgiavn.project02.web.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.AcitivityDAO;
import framgiavn.project02.web.model.Activity;

/**
 * @author datvv
 *
 */
public class ActivityDAOImpl extends HibernateDaoSupport implements AcitivityDAO {

	@Override
	public List<Activity> getAllActivities(int userId) throws Exception {
		Query query = getSession().getNamedQuery("Activity.selectAllActivites");
		query.setParameter("userId", userId);
		return query.list();
	}

	@Override
	public void addActivity(Activity activity) throws Exception {
		Session sesion = getSession();
		sesion.saveOrUpdate(activity);
	}

	@Override
	public Activity findActivity(int userId, int targetId, String actionTypeId) {
		Query query = getSession().getNamedQuery("Activity.findActivity");
		query.setParameter("userId", userId).setParameter("targetId", targetId).setParameter("actionTypeId", actionTypeId);
		return (Activity) query.uniqueResult();
	}

	@Override
	public void deleteActivity(Activity activity) {
		Session session = getSession();
		session.delete(activity);
		session.flush();
	}

}
