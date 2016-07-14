package framgiavn.project02.web.business;

import framgiavn.project02.web.model.User;

public interface UserBusiness {

	public User findByUserId(Integer user_id) throws Exception;
	
	public User findUserByEmail(String email) throws Exception;

	public void addNormalUser(User user) throws Exception;

	public User findByUserSocialId(String socialId) throws Exception;

	public void addSocialUser(com.restfb.types.User me, User user) throws Exception;

}