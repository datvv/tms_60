/**
 * Jul 7, 2016, SubjectScreenAction.java, vuvandat
 */
package framgiavn.project02.web.action;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project02.web.business.TaskBusiness;
import framgiavn.project02.web.business.UserBusiness;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.model.User;

/**
 * @author vuvandat
 *
 */
public class SubjectScreenAction extends ActionSupport {

	private TaskBusiness taskBusiness;
	private UserBusiness userBusiness;
	private List<Task> taskList;
	private int subjectId = 3;

	public String showSubjecDetail() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userBusiness.findUserByEmail(userDetails.getUsername());
		taskList = taskBusiness.getTasksByUserIdAndSubjectId(user.getId(), subjectId);
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

}
