package classes.data.service;

import classes.data.dto.PracticeDto;
import classes.data.entity.Practice;

import java.util.List;

public interface PracticeService {
    List<Practice> getAll();
    Practice registerNewPractice(PracticeDto practiceDto);
}
