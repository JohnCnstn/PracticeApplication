package classes.data.service.impl;

import classes.data.dto.PracticeDto;
import classes.data.entity.Practice;
import classes.data.entity.User;
import classes.data.repository.PracticeRepository;
import classes.data.repository.StudentRepository;
import classes.data.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeServiceImpl implements PracticeService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PracticeRepository practiceRepository;

    @Override
    public List<Practice> getAll() {
        return practiceRepository.findAll();
    }

    @Override
    public Practice registerNewPractice(PracticeDto practiceDto, User user) {
        Practice practice = new Practice();
        practice.setStartDate(practiceDto.getStartDate());
        practice.setEndDate(practiceDto.getEndDate());
//        practice.setHeadMaster(user);
        return practiceRepository.save(practice);
    }
}
