/**
 * Jul 9, 2016, SubjectDAOImpl.java, datvv
 */
package framgiavn.project02.web.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.SubjectDAO;
import framgiavn.project02.web.model.Subject;

/**
 * @author datvv
 *
 */
public class SubjectDAOImpl extends HibernateDaoSupport implements SubjectDAO {

	@Override
	public Subject getSubjectByUserSubjectId(int subjectId) throws Exception {
		try {
			String hql = "Select subject From Subject subject, CourseSubject courseSubject Where subject.id in "
					+ "(Select courseSubject.subjectId From CourseSubject Where courseSubject.id = :subjectId)";
			Query query = getSession().createQuery(hql).setParameter("subjectId", subjectId);
			return (Subject) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}

	}

}
