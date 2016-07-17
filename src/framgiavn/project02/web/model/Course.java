package framgiavn.project02.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author nguyenanhvan
 *
 */
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String instruction;
	private String status;
	private Date startDate;
	private Date endDate;
	private List<Subject> subjectList;
	private Set<CourseSubject> courseSubjects = new HashSet<CourseSubject>(0);
	private Set<UserCourse> userCourses = new HashSet<UserCourse>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public Set<CourseSubject> getCourseSubjects() {
		return courseSubjects;
	}

	public void setCourseSubjects(Set<CourseSubject> courseSubjects) {
		this.courseSubjects = courseSubjects;
	}

	public Set<UserCourse> getUserCourses() {
		return userCourses;
	}

	public void setUserCourses(Set<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
