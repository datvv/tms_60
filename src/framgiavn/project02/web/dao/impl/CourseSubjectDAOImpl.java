/**
 * Jul 20, 2016, CourseSubjectDAOImpl.java, datvv
 */
package framgiavn.project02.web.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.CourseSubjectDAO;
import framgiavn.project02.web.model.CourseSubject;

/**
 * @author datvv
 *
 */
public class CourseSubjectDAOImpl extends HibernateDaoSupport implements CourseSubjectDAO {

	@Override
	public CourseSubject getCourseSubjectByCourseIdAndSubjectId(int courseId, int subjectId) throws Exception {
		Query query = getSession().getNamedQuery("CourseSubject.getCourseSubjectByCourseIdAndSubjectId");
		query.setParameter("courseId", courseId).setParameter("subjectId", subjectId);
		return (CourseSubject) query.uniqueResult();
	}

}
