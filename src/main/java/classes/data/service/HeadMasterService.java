package classes.data.service;

import classes.data.dto.CompanyDto;
import classes.data.dto.PracticeDto;
import classes.data.dto.UserDto;
import classes.data.entity.HeadMaster;
import classes.data.entity.Student;
import classes.data.validation.exception.EmailExistsException;
import classes.data.validation.exception.UserNameExistsException;

import java.util.List;

public interface HeadMasterService {
    HeadMaster findOne(long id);
    HeadMaster getByUserName(String userName);
    void setStudentOnPractice(Student student, PracticeDto practiceDto);
    HeadMaster registerNewHeadMasterAccount(UserDto accountDto, CompanyDto companyDto) throws UserNameExistsException, EmailExistsException;
    void delete(long id);
    List<HeadMaster> getAll();
}
