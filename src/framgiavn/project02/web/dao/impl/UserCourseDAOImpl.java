/**
 * Jul 18, 2016, UserCourseDAOImpl.java, datvv
 */
package framgiavn.project02.web.dao.impl;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.UserCourseDAO;
import framgiavn.project02.web.model.UserCourse;

/**
 * @author datvv
 *
 */
public class UserCourseDAOImpl extends HibernateDaoSupport implements UserCourseDAO {

	@Override
	public void saveUserCourse(UserCourse userCourse) throws Exception {
		Session session = getSession();
		session.saveOrUpdate(userCourse);
		session.flush();
	}

}
