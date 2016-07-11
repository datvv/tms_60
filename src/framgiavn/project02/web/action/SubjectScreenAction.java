/**
 * Jul 7, 2016, SubjectScreenAction.java, vuvandat
 */
package framgiavn.project02.web.action;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project02.web.business.SubjectScreenBusiness;
import framgiavn.project02.web.business.UserBusiness;
import framgiavn.project02.web.constant.TmsContant;
import framgiavn.project02.web.logic.SubjectScreenLogic;
import framgiavn.project02.web.model.*;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author vuvandat
 *
 */
public class SubjectScreenAction extends ActionSupport {

	private UserBusiness userBusiness;
	private List<Task> taskList;
	private int subjectId = 3;
	private Subject subject;
	private UserSubject userSubject;
	private List<Activity> activityList;
	private List<User> traineesList;
	private List<User> supervisorsList;
	private int courseId = 1;
	private SubjectScreenBusiness subjectScreenBusiness;
	private SubjectScreenLogic subjectScreenLogic = new SubjectScreenLogic();
	private Logit2 log = Logit2.getInstance(SubjectScreenAction.class);

	public String showSubjecDetail() {
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			User user = userBusiness.findUserByEmail(userDetails.getUsername());
			userSubject = subjectScreenBusiness.getUserSubjectByUserSubjectCourse(user.getId(), subjectId, courseId);
			subject = userSubject.getCourseSubject().getSubject();
			taskList = subjectScreenLogic.processTaskStatus(user, userSubject, subject.getTasks());
			activityList = subjectScreenLogic.processActivities(user.getActivities(), taskList);
			traineesList = subjectScreenLogic
					.getListUsersByRoleInClass(userSubject.getCourseSubject().getUserSubjects(), TmsContant.ROLE_USER);
			supervisorsList = subjectScreenLogic.getListUsersByRoleInClass(
					userSubject.getCourseSubject().getUserSubjects(), TmsContant.ROLE_SUPERVISOR);
			return SUCCESS;
		} catch (Exception e) {
			log.error("show subject detail failed ", e);
		}
		return null;
	}

	public String editTaskStatus() {
		try {
			SubjectScreenLogic subjectScreenLogic = new SubjectScreenLogic();
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			User user = userBusiness.findUserByEmail(userDetails.getUsername());
			List<Activity> activities = subjectScreenBusiness.editTaskStatus(user.getId(), taskList, userSubject);
			activityList = subjectScreenLogic.processActivities(activities, taskList);
			return SUCCESS;
		} catch (Exception e) {
			log.error("edit task failed ", e);
		}
		return null;
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

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	public List<User> getTraineesList() {
		return traineesList;
	}

	public void setTraineesList(List<User> traineesList) {
		this.traineesList = traineesList;
	}

	public List<User> getSupervisorsList() {
		return supervisorsList;
	}

	public void setSupervisorsList(List<User> supervisorsList) {
		this.supervisorsList = supervisorsList;
	}

	public SubjectScreenBusiness getSubjectScreenBusiness() {
		return subjectScreenBusiness;
	}

	public void setSubjectScreenBusiness(SubjectScreenBusiness subjectScreenBusiness) {
		this.subjectScreenBusiness = subjectScreenBusiness;
	}

}
