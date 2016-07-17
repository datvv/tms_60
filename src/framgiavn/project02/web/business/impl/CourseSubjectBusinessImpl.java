/**
 * Jul 21, 2016, CourseSubjectBusinessImpl.java, datvv
 */
package framgiavn.project02.web.business.impl;

import framgiavn.project02.web.business.CourseSubjectBusiness;
import framgiavn.project02.web.dao.CourseSubjectDAO;
import framgiavn.project02.web.model.CourseSubject;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class CourseSubjectBusinessImpl implements CourseSubjectBusiness {

	private CourseSubjectDAO courseSubjectDAO;
	private static final Logit2 log = Logit2.getInstance(CourseSubjectBusinessImpl.class);

	@Override
	public CourseSubject getCourseSubjectByCourseIdAndSubjectId(int courseId, int subjectId) throws Exception {
		try {
			return this.getCourseSubjectDAO().getCourseSubjectByCourseIdAndSubjectId(courseId, subjectId);
		} catch (Exception e) {
			log.error("get failed ", e);
		}
		return null;
	}

	public CourseSubjectDAO getCourseSubjectDAO() {
		return courseSubjectDAO;
	}

	public void setCourseSubjectDAO(CourseSubjectDAO courseSubjectDAO) {
		this.courseSubjectDAO = courseSubjectDAO;
	}

}
