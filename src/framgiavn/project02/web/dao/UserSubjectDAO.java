/**
 * Jul 9, 2016, UserSubjectDAO.java, datvv
 */
package framgiavn.project02.web.dao;

import framgiavn.project02.web.model.UserSubject;

/**
 * @author datvv
 *
 */
public interface UserSubjectDAO {
	
	public UserSubject getUserSubjectByUserSubjectId(int userSubjectId) throws Exception;
}
