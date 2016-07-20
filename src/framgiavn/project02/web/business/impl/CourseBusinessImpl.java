package framgiavn.project02.web.business.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import framgiavn.project02.web.business.CourseBusiness;
import framgiavn.project02.web.constant.TmsContant;
import framgiavn.project02.web.dao.CourseDAO;
import framgiavn.project02.web.model.Course;
import framgiavn.project02.web.model.CourseSubject;
import framgiavn.project02.web.model.Subject;
import framgiavn.project02.web.model.User;
import framgiavn.project02.web.model.UserCourse;
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

	@Override
	public void addAndSave(Course course) throws Exception {
		try {
			this.getCourseDAO().addAndSaveCourse(course);
		} catch (Exception e) {
			log.error("save failed ", e);
		}
	}

	@Override
	public void deleteCourse(int courseId) throws Exception {
		try {
			Course course = getCourseDAO().findCourseById(courseId);
			if (course != null) {
				getCourseDAO().deleteCourse(course);
			}
		} catch (Exception e) {
			log.error("delete failed ", e);
		}
	}

	@Override
	public Map<String, Map<Course, Set<? extends Object>>> showCourseDetail(int courseId) throws Exception {

		Set<Subject> subjects = new HashSet<Subject>();
		Set<User> users = new HashSet<User>(0);
		Set<User> supervisors = new HashSet<User>(0);
		Map<Course, Set<? extends Object>> mapCourse_Subjects = new HashMap();
		Map<Course, Set<? extends Object>> mapCourse_Users = new HashMap();
		Map<Course, Set<? extends Object>> mapCourse_Supervisors = new HashMap();
		Map<String, Map<Course, Set<? extends Object>>> maps = new HashMap<String, Map<Course, Set<? extends Object>>>();

		Course course = this.getCourseDAO().findCourseById(courseId);
		Set<CourseSubject> courseSubjects = course.getCourseSubjects();
		for (CourseSubject courseSubject : courseSubjects) {
			subjects.add(courseSubject.getSubject());
		}
		Set<UserCourse> userCourses = course.getUserCourses();
		for (UserCourse userCourse : userCourses) {
			if (TmsContant.ROLE_USER.equals(userCourse.getUser().getRole())) {
				users.add(userCourse.getUser());
			} else if (TmsContant.ROLE_SUPERVISOR.equals(userCourse.getUser().getRole())) {
				supervisors.add(userCourse.getUser());
			}
		}
		mapCourse_Subjects.put(course, subjects);
		mapCourse_Users.put(course, users);
		mapCourse_Supervisors.put(course, supervisors);
		maps.put("mapCourse_Subjects", mapCourse_Subjects);
		maps.put("mapCourse_Users", mapCourse_Users);
		maps.put("mapCourse_Supervisors", mapCourse_Supervisors);
		return maps;
	}

}
