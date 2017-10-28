package classes.data.service;

import classes.data.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface StudentService extends UserDetailsService {
    User getByName(String name);
}
