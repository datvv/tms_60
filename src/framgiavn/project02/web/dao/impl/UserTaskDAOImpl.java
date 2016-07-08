/**
 * Jul 7, 2016, UserTaskDAOImpl.java, vuvandat
 */
package framgiavn.project02.web.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.UserTaskDAO;
import framgiavn.project02.web.model.UserTask;

/**
 * @author vuvandat
 *
 */
public class UserTaskDAOImpl extends HibernateDaoSupport implements UserTaskDAO {

	@Override
	public UserTask getUserTaskByUserIdAndTaskId(int userId, int taskId) throws Exception {
		try {
			Query query = getSession().getNamedQuery("UserTask.SelectUserTaskByUserIdAndTaskId");
			query.setParameter("userId", userId).setParameter("taskId", taskId);
			UserTask userTask = (UserTask) query.uniqueResult();
			return userTask;
		} catch (RuntimeException e) {
			throw e;
		}

	}

}
