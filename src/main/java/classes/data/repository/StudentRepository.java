package classes.data.repository;

import classes.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);
}
