package classes.data.repository;

import classes.data.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    @Query("select f from Faculty f where f.name = :name")
    Faculty findByName(@Param("name") String name);

    @Query("select f from Faculty f where f.id = :id")
    Faculty findById(long id);
}
