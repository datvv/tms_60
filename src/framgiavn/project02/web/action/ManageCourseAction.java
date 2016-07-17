/**
 * Jul 17, 2016, SupervisorCourseDetailAction.java, datvv
 */
package framgiavn.project02.web.action;

import java.util.Map;
import java.util.Set;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project02.web.business.CourseBusiness;
import framgiavn.project02.web.model.Course;
import framgiavn.project02.web.model.Subject;
import framgiavn.project02.web.model.User;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class ManageCourseAction extends ActionSupport {

	private CourseBusiness courseBusiness;
	private Course course;
	private int courseId;
	private Set<Subject> subjects;
	private Set<User> userList;
	private Set<User> supervisorList;
	private Logit2 log = Logit2.getInstance(ManageCourseAction.class);

	public String showCourseDetail() {
		try {
			Map<String, Map<Course, Set<? extends Object>>> maps = courseBusiness.showCourseDetail(courseId);
			Set courseSet = maps.get("mapCourse_Subjects").keySet();
			for (Object object : courseSet) {
				course = (Course) object;
			}
			subjects = (Set<Subject>) maps.get("mapCourse_Subjects").get(course);
			userList = (Set<User>) maps.get("mapCourse_Users").get(course);
			supervisorList = (Set<User>) maps.get("mapCourse_Supervisors").get(course);
		} catch (Exception e) {
			log.error("show course detail failed ", e);
		}
		return SUCCESS;
	}

	public String addCourse() {
		course = new Course();
		return SUCCESS;
	}

	public String addAndSaveCourse() {
		try {
			courseBusiness.addAndSave(course);
		} catch (Exception e) {
			log.error("save course failed ", e);
		}
		return SUCCESS;
	}

	public String deleteCourse() {
		try {
			courseBusiness.deleteCourse(courseId);
		} catch (Exception e) {
			log.error("delete failed ", e);
		}
		return SUCCESS;
	}

	public CourseBusiness getCourseBusiness() {
		return courseBusiness;
	}

	public void setCourseBusiness(CourseBusiness courseBusiness) {
		this.courseBusiness = courseBusiness;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

	public Set<User> getSupervisorList() {
		return supervisorList;
	}

	public void setSupervisorList(Set<User> supervisorList) {
		this.supervisorList = supervisorList;
	}
}
