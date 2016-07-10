/**
 * Jul 9, 2016, UserSubjectBusinessImpl.java, datvv
 */
package framgiavn.project02.web.business.impl;

import framgiavn.project02.web.business.UserSubjectBusiness;
import framgiavn.project02.web.dao.UserSubjectDAO;
import framgiavn.project02.web.model.UserSubject;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class UserSubjectBusinessImpl implements UserSubjectBusiness {

	private UserSubjectDAO userSubjectDAO;
	private static final Logit2 log = Logit2.getInstance(UserSubjectBusinessImpl.class);

	@Override
	public UserSubject getUserSubjectByUserSubjectId(int userSubjectId) {
		try {
			return getUserSubjectDAO().getUserSubjectByUserSubjectId(userSubjectId);
		} catch (Exception e) {
			log.error("get userSubject failed ", e);
		}
		return null;
	}

	public UserSubjectDAO getUserSubjectDAO() {
		return userSubjectDAO;
	}

	public void setUserSubjectDAO(UserSubjectDAO userSubjectDAO) {
		this.userSubjectDAO = userSubjectDAO;
	}

}
