package classes.data.service.impl;

import classes.data.dto.PracticeDto;
import classes.data.entity.Practice;
import classes.data.repository.PracticeRepository;
import classes.data.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;

public class PracticeServiceImpl implements PracticeService {

    @Autowired
    private PracticeRepository practiceRepository;

//
//    @Override
//    public Practice registerNewPractice(PracticeDto practiceDto) {
//        Practice practice = new Practice();
//        practice.setStart_date(practiceDto.getStart_date());
//        practice.setUser();
//        return practiceRepository.save(practice);
//    }
}
