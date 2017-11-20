package classes.data.service.impl;

import classes.data.dto.PracticeDto;
import classes.data.entity.Practice;
import classes.data.repository.PracticeRepository;
import classes.data.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeServiceImpl implements PracticeService {

    @Autowired
    private PracticeRepository practiceRepository;

    @Override
    public List<Practice> getAll() {
        return practiceRepository.findAll();
    }

    @Override
    public Practice registerNewPractice(PracticeDto practiceDto) {
        Practice practice = new Practice();
        practice.setStartDate(practiceDto.getStartDate());
        practice.setEndDate(practiceDto.getEndDate());
        return practiceRepository.save(practice);
    }
}
