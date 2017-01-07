package spring.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.database.dao.UserDao;
import spring.database.model.User;

import java.util.Date;

@Service("userRegistrationService")
public class UserRegistrationService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User registerNewUserAccount(UserDto accountDto)
            throws UserExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new UserExistsException("email");
        }
        if (usernameExist(accountDto.getUsername())) {
            throw new UserExistsException("username");
        }
        User user = new User();
        user.setUsername(accountDto.getUsername());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        Date date = new Date(System.currentTimeMillis());
        user.setRegistrationDate(date);
        user.setEnabled(true);
        user.setRole("ROLE_USER");
        return userDao.save(user);
    }

    private boolean usernameExist(String username) {
        User user = userDao.findByUserName(username);
        return user != null;
    }

    private boolean emailExist(String email) {
        User user = userDao.findByUserEmail(email);
        return user != null;
    }
}
