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
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findOne(long id) {
        return facultyRepository.findOne(id);
    }
}
