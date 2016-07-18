/**
 * Jul 7, 2016, Subject.java, vuvandat
 */
package framgiavn.project02.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vuvandat
 *
 */
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Date startDate;
	private Date endDate;
	private String instruction;
	private Set<CourseSubject> courseSubjects = new HashSet<CourseSubject>(0);
	private Set<Task> tasks = new HashSet<Task>(0);

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

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Set<CourseSubject> getCourseSubjects() {
		return courseSubjects;
	}

	public void setCourseSubjects(Set<CourseSubject> courseSubjects) {
		this.courseSubjects = courseSubjects;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
