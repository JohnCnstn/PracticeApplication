package classes.data.service;

import classes.data.entity.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty getById(long id);
    Faculty getByName(String name);
    List<Faculty> getAll();
}
