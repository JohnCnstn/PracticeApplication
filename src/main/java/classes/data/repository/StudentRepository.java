package classes.data.repository;

import classes.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
