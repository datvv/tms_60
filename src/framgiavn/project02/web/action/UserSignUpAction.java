package framgiavn.project02.web.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;

import framgiavn.project02.web.business.UserBusiness;
import framgiavn.project02.web.model.User;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author nguyenanhvan
 *
 */
public class UserSignUpAction extends ActionSupport {

	private Logit2 log = Logit2.getInstance(UserAction.class);

	private UserBusiness userBusiness = null;
	private User user = null;
	private String passwordConfirm;
	private String accessToken = null;

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@SkipValidation
	public String homePage() {
		return SUCCESS;
	}

	public String signUp() {
		if (accessToken != null) {
			FacebookClient facebookClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_5);
			com.restfb.types.User me = facebookClient.fetchObject("me", com.restfb.types.User.class,
					Parameter.with("fields", "email,name,id"));
			try {
				userBusiness.addSocialUser(me, user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		} else {
			try {
				userBusiness.addNormalUser(user);
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ERROR;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void validate() {
		if (user != null) {
			if (user.getEmail() == null || user.getEmail().trim().equals("")) {
				addFieldError("user.email", "Email is required");
			} else {
				User oldUser = null;
				try {
					oldUser = userBusiness.findUserByEmail(user.getEmail());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (oldUser != null) {
					addFieldError("user.email", "This email was used, try another one.");
				}
			}
			if (user.getUsername() == null || user.getUsername().trim().equals("")) {
				addFieldError("user.username", "Username is required");
			} else if (user.getUsername().length() > 45 || user.getUsername().length() < 5) {
				addFieldError("user.username", "Length of Username is from 5 to 45");
			}
			if (user.getPassword() == null || user.getPassword().trim().equals("")) {
				addFieldError("user.password", "Password can not be empty");
			} else if (user.getPassword().length() > 45 || user.getPassword().length() < 5) {
				addFieldError("user.password", "Length of Password is from 5 to 45");
			} else if (!user.getPassword().equals(this.passwordConfirm)) {
				addFieldError("passwordConfirm", "Password is not matched");
			}
		}
	}

}