package framgiavn.project02.web.business.impl;

import java.util.List;

import framgiavn.project02.web.business.CourseBusiness;
import framgiavn.project02.web.dao.CourseDAO;
import framgiavn.project02.web.model.Course;
import framgiavn.project02.web.model.Subject;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author nguyenanhvan
 *
 */
public class CourseBusinessImpl implements CourseBusiness {

	private CourseDAO courseDAO;
	private static final Logit2 log = Logit2.getInstance(UserBusinessImpl.class);

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List<Subject> getSubjectList(Integer courseId) throws Exception {
		try {
			return this.getCourseDAO().getSubjectList(courseId);
		} catch (Exception e) {
			log.error("getSubjectList:get failed:" + e.toString());
		}
		return null;
	}

	@Override
	public Course findCourseById(Integer courseId) throws Exception {
		try {
			return this.getCourseDAO().findCourseById(courseId);
		} catch (Exception e) {
			log.error("findCourseById:get failed:" + e.toString());
		}
		return null;
	}

	@Override
	public void retrieveCourseDetail(Integer courseId) throws Exception {
		this.findCourseById(courseId).setSubjectList(this.getSubjectList(courseId));
	}

}
