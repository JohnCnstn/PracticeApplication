package classes.data.service;

import classes.data.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User getByName(String name);
    User getByUserName(String userName);
}
