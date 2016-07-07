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
			log.error("findByUserId, exception:" + e);
		}
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		try {
			return getUserDAO().findUserByEmail(email);
		} catch (Exception e) {
			 log.error("findByEmail, exception:" + e);
		}
		return null;
	}

}