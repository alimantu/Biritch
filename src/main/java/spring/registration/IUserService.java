package spring.registration;

import spring.database.model.User;

public interface IUserService {

    User registerNewUserAccount(UserDto accountDto)
            throws UserExistsException;
}
