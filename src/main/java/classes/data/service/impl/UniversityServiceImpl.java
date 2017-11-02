package classes.data.service.impl;

import classes.data.entity.University;
import classes.data.repository.UniversityRepository;
import classes.data.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    @Override
    public University getById(long id) {
        return universityRepository.findById(id);
    }

    @Override
    public University getByName(String name) {
        return universityRepository.findByName(name);
    }

    @Override
    public List<University> getAll() {
        return universityRepository.findAll();
    }
}
