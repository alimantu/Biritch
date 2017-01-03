package spring.database.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.database.model.User;

import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = sessionFactory.getCurrentSession()
				.createQuery("from User where username=?").setParameter(0, username)
				.list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public User findByUserEmail(String email) {

		List<User> users = sessionFactory.getCurrentSession()
				.createQuery("from User where email=?").setParameter(0, email)
				.list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public User save(User user) {

		sessionFactory.getCurrentSession().save(user);
		return user;
	}

}