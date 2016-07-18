package framgiavn.project02.web.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.sun.mail.util.QEncoderStream;
import framgiavn.project02.web.constant.TmsContant;
import framgiavn.project02.web.dao.UserDAO;
import framgiavn.project02.web.model.User;
import framgiavn.project02.web.ulti.Logit2;
import framgiavn.project02.web.ulti.AvatarUtils;
import framgiavn.project02.web.ulti.UserRole;

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
			log.error("findByUserId:get failed:", re);
			throw re;
		}
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.FindUserByEmail");
			query.setParameter("email", email);
			return (User) query.uniqueResult();
		} catch (RuntimeException e) {
			log.error("findUserByEmail:get failed:", e);
			throw e;
		}
	}

	@Override
	public void addNormalUser(User user) throws Exception {
		try {
			user.setAvatar(AvatarUtils.getAvatarURL(user.getEmail()));
			user.setRole(UserRole.USER.getRole());
			getSession().save(user);
		} catch (RuntimeException re) {
			log.error("addNewUser:get failed", re);
			throw re;
		}
	}

	@Override
	public User findByUserSocialId(String socialId) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectUserByUserSocialId");
			query.setParameter("socialId", socialId);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("findByUserId:get failed:", re);
			throw re;
		}
	}

	@Override
	public void addSocialUser(com.restfb.types.User me, User user) throws Exception {
		User tmpUser = this.findByUserSocialId("fb" + me.getId());
		if (tmpUser != null) {
			tmpUser.setEmail(me.getEmail());
			tmpUser.setUsername(me.getName());
			getSession().update(tmpUser);
		} else {
			try {
				user = new User();
				user.setEmail(me.getEmail());
				user.setUsername(me.getName());
				user.setAvatar(AvatarUtils.getAvatarURL(me.getEmail()));
				user.setSocialId("fb" + me.getId());
				user.setRole(UserRole.USER.getRole());
				getSession().save(user);
			} catch (RuntimeException re) {
				log.error("addNewUser:get failed", re);
				throw re;
			}
		}
	}

}