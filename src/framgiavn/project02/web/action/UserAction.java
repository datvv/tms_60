package framgiavn.project02.web.action;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project02.web.business.UserBusiness;
import framgiavn.project02.web.model.User;
import framgiavn.project02.web.ulti.Logit2;

public class UserAction extends ActionSupport {

//	private Logit2 log = Logit2.getInstance(UserAction.class);

	private UserBusiness userBusiness = null;
	private User user = null;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String findByUserId() {
		try {
			user = userBusiness.findByUserId(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String homePage() {
		return SUCCESS;
	}
	
	public String supervisorPage() {
		return SUCCESS;
	}

	public void validate() {
	}
}