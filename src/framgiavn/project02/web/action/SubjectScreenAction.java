/**
 * Jul 7, 2016, SubjectScreenAction.java, vuvandat
 */
package framgiavn.project02.web.action;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project02.web.business.ActivityBusiness;
import framgiavn.project02.web.business.SubjectBusiness;
import framgiavn.project02.web.business.TaskBusiness;
import framgiavn.project02.web.business.UserBusiness;
import framgiavn.project02.web.business.UserSubjectBusiness;
import framgiavn.project02.web.business.UserTaskBusiness;
import framgiavn.project02.web.model.*;

/**
 * @author vuvandat
 *
 */
public class SubjectScreenAction extends ActionSupport {

	private TaskBusiness taskBusiness;
	private UserBusiness userBusiness;
	private UserSubjectBusiness userSubjectBusiness;
	private SubjectBusiness subjectBusiness;
	private List<Task> taskList;
	private int subjectId = 3;
	private Subject subject;
	private UserSubject userSubject;
	private UserTaskBusiness userTaskBusiness;
	private ActivityBusiness activityBusiness;
	private List<Activity> activityList;

	public String showSubjecDetail() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userBusiness.findUserByEmail(userDetails.getUsername());
		taskList = taskBusiness.getTasksByUserIdAndSubjectId(user.getId(), subjectId);
		subject = subjectBusiness.getSubjectByUserSubjectId(subjectId);
		userSubject = userSubjectBusiness.getUserSubjectByUserSubjectId(subjectId);
		activityList = activityBusiness.getAllActivities(user.getId());
		return SUCCESS;
	}

	public String editTaskStatus() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userBusiness.findUserByEmail(userDetails.getUsername());
		userTaskBusiness.editTaskStatus(user.getId(), taskList, subjectId);
		activityList = activityBusiness.getAllActivities(user.getId());
		return SUCCESS;
	}

	public TaskBusiness getTaskBusiness() {
		return taskBusiness;
	}

	public void setTaskBusiness(TaskBusiness taskBusiness) {
		this.taskBusiness = taskBusiness;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public UserSubjectBusiness getUserSubjectBusiness() {
		return userSubjectBusiness;
	}

	public void setUserSubjectBusiness(UserSubjectBusiness userSubjectBusiness) {
		this.userSubjectBusiness = userSubjectBusiness;
	}

	public SubjectBusiness getSubjectBusiness() {
		return subjectBusiness;
	}

	public void setSubjectBusiness(SubjectBusiness subjectBusiness) {
		this.subjectBusiness = subjectBusiness;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public UserSubject getUserSubject() {
		return userSubject;
	}

	public void setUserSubject(UserSubject userSubject) {
		this.userSubject = userSubject;
	}

	public UserTaskBusiness getUserTaskBusiness() {
		return userTaskBusiness;
	}

	public void setUserTaskBusiness(UserTaskBusiness userTaskBusiness) {
		this.userTaskBusiness = userTaskBusiness;
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	public ActivityBusiness getActivityBusiness() {
		return activityBusiness;
	}

	public void setActivityBusiness(ActivityBusiness activityBusiness) {
		this.activityBusiness = activityBusiness;
	}

}
