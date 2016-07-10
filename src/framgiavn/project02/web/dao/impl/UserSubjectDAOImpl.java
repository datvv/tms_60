/**
 * Jul 9, 2016, UserSubjectDAOImpl.java, datvv
 */
package framgiavn.project02.web.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.UserSubjectDAO;
import framgiavn.project02.web.model.UserSubject;

/**
 * @author datvv
 *
 */
public class UserSubjectDAOImpl extends HibernateDaoSupport implements UserSubjectDAO {

	@Override
	public UserSubject getUserSubjectByUserSubjectId(int userSubjectId) throws Exception {
		try {
			Query query = getSession().getNamedQuery("UserSubject.SelectUserSubjectByUserSubjectId");
			query.setParameter("userSubjectId", userSubjectId);
			return (UserSubject) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}

	}

}
