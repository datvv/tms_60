/**
 * Jul 7, 2016, TaskDAOImpl.java, vuvandat
 */
package framgiavn.project02.web.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.TaskDAO;
import framgiavn.project02.web.model.Task;

/**
 * @author vuvandat
 *
 */
public class TaskDAOImpl extends HibernateDaoSupport implements TaskDAO {

	@Override
	public List<Task> getTasksBySubjectId(int subjectId) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Task.SelectTaskSubjectId");
			query.setParameter("subjectId", subjectId);
			return query.list();
		} catch (RuntimeException e) {
			throw e;
		}

	}

}
