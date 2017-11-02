package classes.data.service;

import classes.data.entity.University;

import java.util.List;

public interface UniversityService {
    University getById(long id);
    University getByName(String name);
    List<University> getAll();
}
