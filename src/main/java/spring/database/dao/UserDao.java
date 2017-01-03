package spring.database.dao;


import spring.database.model.User;

public interface UserDao {

	User findByUserName(String username);

	User findByUserEmail(String email);

	User save(User user);

}