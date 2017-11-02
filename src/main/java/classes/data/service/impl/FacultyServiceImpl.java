package classes.data.service.impl;

import classes.data.entity.Faculty;
import classes.data.repository.FacultyRepository;
import classes.data.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public Faculty getById(long id) {
        return facultyRepository.findById(id);
    }

    @Override
    public Faculty getByName(String name) {
        return facultyRepository.findByName(name);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }
}
