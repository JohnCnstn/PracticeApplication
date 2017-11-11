package classes.data.service;

import classes.data.dto.UserDto;
import classes.data.entity.User;
import classes.data.validation.exception.EmailExistsException;

import java.util.List;

public interface UserService {
    User getByName(String name);
    User getByUserName(String userName);
    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
    List<User> getAll();
}
