package framgiavn.project02.web.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.CourseDAO;
import framgiavn.project02.web.model.Course;
import framgiavn.project02.web.model.Subject;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author nguyenanhvan
 *
 */
public class CourseDAOImpl extends HibernateDaoSupport implements CourseDAO {

	private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);

	@Override
	public List<Subject> getSubjectList(Integer courseId) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Course.SelectSubjectList");
			query.setParameter("courseId", courseId);
			return query.list();
		} catch (RuntimeException re) {
			log.error("getSubjectList:get failed:", re);
			throw re;
		}
	}

	@Override
	public Course findCourseById(Integer courseId) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Course.SelectCourseByCourseId");
			query.setParameter("courseId", courseId);
			return (Course) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("findCourseById:get failed:", re);
			throw re;
		}
	}

	@Override
	public void addAndSaveCourse(Course course) throws Exception {
		Session session = getSession();
		session.saveOrUpdate(course);
		session.flush();
	}

	@Override
	public void deleteCourse(Course course) throws Exception {
		Session session = getSession();
		Course course1 = (Course) session.load(Course.class, course.getId());
		session.delete(course1);
		session.flush();
	}

}
