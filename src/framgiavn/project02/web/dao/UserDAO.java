package framgiavn.project02.web.dao;

import framgiavn.project02.web.model.User;

public interface UserDAO {
	public User findByUserId(Integer user_id) throws Exception;
	
	public User findUserByEmail(String email) throws Exception;

}