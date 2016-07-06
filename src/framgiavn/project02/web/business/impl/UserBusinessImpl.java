package framgiavn.project02.web.business.impl;

import framgiavn.project02.web.business.UserBusiness;
import framgiavn.project02.web.dao.UserDAO;
import framgiavn.project02.web.model.User;
import framgiavn.project02.web.ulti.Logit2;

public class UserBusinessImpl implements UserBusiness {

	private UserDAO userDAO;
	private static final Logit2 log = Logit2.getInstance(UserBusinessImpl.class);

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findByUserId(Integer user_id) throws Exception {
		try {
			return getUserDAO().findByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("findByUserId:get failed:" + e.toString());
		}
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		try {
			return getUserDAO().findUserByEmail(email);
		} catch (Exception e) {
			log.error("findByEmail:get failed:" + e.toString());
		}
		return null;
	}

	@Override
	public void addNormalUser(User user) throws Exception {
		try {
			getUserDAO().addNormalUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("addNewUser:get failed" + e.toString());
		}
	}

	@Override
	public User findByUserSocialId(String socialId) throws Exception {
		try {
			return getUserDAO().findByUserSocialId(socialId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("addNewUser:get failed" + e.toString());
		}
		return null;
	}

	@Override
	public void addSocialUser(com.restfb.types.User me, User user) throws Exception {
		try {
			getUserDAO().addSocialUser(me, user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("addSocialUser:get failed" + e.toString());
		}
	}

}