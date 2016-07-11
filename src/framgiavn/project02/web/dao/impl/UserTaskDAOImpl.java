/**
 * Jul 7, 2016, UserTaskDAOImpl.java, vuvandat
 */
package framgiavn.project02.web.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
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

	@Override
	public void deleteUserTaskByUserTask(UserTask userTask) throws Exception {
		try {
			Session session = getSession();
			session.delete(userTask);
			session.flush();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void addUserTask(UserTask userTask) throws Exception {
		try {
			Session session = getSession();
			session.saveOrUpdate(userTask);
		} catch (Exception e) {
			throw e;
		}
	}

}
