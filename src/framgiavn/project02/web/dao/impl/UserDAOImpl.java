package framgiavn.project02.web.dao.impl;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project02.web.dao.UserDAO;
import framgiavn.project02.web.model.User;
import framgiavn.project02.web.ulti.Logit2;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);

	protected void initDAO() {
	}

	@Override
	public User findByUserId(Integer user_id) throws Exception {
		return findByUserId(user_id, false);
	}

	public User findByUserId(Integer user_id, boolean lock) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectUserByUserId");
			if (lock)
				query.setLockMode("User", LockMode.UPGRADE);
			query.setParameter("user_id", user_id);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}