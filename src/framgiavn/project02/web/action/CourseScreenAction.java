package framgiavn.project02.web.action;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project02.web.business.CourseBusiness;
import framgiavn.project02.web.business.UserBusiness;
import framgiavn.project02.web.model.Course;
import framgiavn.project02.web.model.User;

/**
 * @author nguyenanhvan
 *
 */
public class CourseScreenAction extends ActionSupport {

	private Course course = null;
	private CourseBusiness courseBusiness = null;

	public String showCourse() {
		try {
			courseBusiness.retrieveCourseDetail(course.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String gotoSubject() {
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseBusiness getCourseBusiness() {
		return courseBusiness;
	}

	public void setCourseBusiness(CourseBusiness courseBusiness) {
		this.courseBusiness = courseBusiness;
	}

}
