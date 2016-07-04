package framgiavn.project02.web.business;

import framgiavn.project02.web.model.User;

public interface UserBusiness {
	public User findByUserId(Integer user_id) throws Exception;

}