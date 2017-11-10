package classes.data.service;

import classes.data.dto.FacultyDto;
import classes.data.dto.UniversityDto;
import classes.data.dto.UserDto;
import classes.data.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    User getByName(String name);
    User getByUserName(String userName);
    User registerNewUserAccount(UserDto accountDto);
}
