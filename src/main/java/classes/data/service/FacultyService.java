package classes.data.service;

import classes.data.entity.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAll();
    Faculty findOne(long id);
}
