/**
 * Jul 7, 2016, UserTaskDAOImpl.java, vuvandat
 */
package framgiavn.project02.web.dao.impl;

import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.UserTaskDAO;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.model.User;
import framgiavn.project02.web.model.UserSubject;
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
			UserSubject userSubject = userTask.getUserSubject();
			User user = userTask.getUser();
			user.getUserTasks().remove(userTask);
			userSubject.getUserTasks().remove(userTask);
			Task task = userTask.getTask();
			task.getUserTasks().remove(userTask);
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
			session.flush();
		} catch (Exception e) {
			throw e;
		}
	}

}
