/**
 * Jul 20, 2016, ManageSubjectAction.java, datvv
 */
package framgiavn.project02.web.action;

import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project02.web.business.CourseSubjectBusiness;
import framgiavn.project02.web.constant.TmsContant;
import framgiavn.project02.web.model.CourseSubject;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class ManageSubjectAction extends ActionSupport {

	private CourseSubjectBusiness courseSubjectBusiness;
	private CourseSubject courseSubject;
	private int courseId = 1;
	private int subjectId = 3;
	private String role_user = TmsContant.ROLE_USER;
	private String role_supervisor = TmsContant.ROLE_SUPERVISOR;
	private Logit2 log = Logit2.getInstance(ManageSubjectAction.class);

	public String showSubjectDetail() {
		try {
			courseSubject = courseSubjectBusiness.getCourseSubjectByCourseIdAndSubjectId(courseId, subjectId);
		} catch (Exception e) {
			log.error("show subject detail failed ", e);
		}
		return SUCCESS;
	}

	public CourseSubjectBusiness getCourseSubjectBusiness() {
		return courseSubjectBusiness;
	}

	public void setCourseSubjectBusiness(CourseSubjectBusiness courseSubjectBusiness) {
		this.courseSubjectBusiness = courseSubjectBusiness;
	}

	public CourseSubject getCourseSubject() {
		return courseSubject;
	}

	public void setCourseSubject(CourseSubject courseSubject) {
		this.courseSubject = courseSubject;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getRole_user() {
		return role_user;
	}

	public void setRole_user(String role_user) {
		this.role_user = role_user;
	}

	public String getRole_supervisor() {
		return role_supervisor;
	}

	public void setRole_supervisor(String role_supervisor) {
		this.role_supervisor = role_supervisor;
	}

}
