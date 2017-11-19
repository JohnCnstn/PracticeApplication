package classes.data.service;

import classes.data.dto.CompanyDto;
import classes.data.dto.FacultyDto;
import classes.data.dto.PracticeDto;
import classes.data.dto.UserDto;
import classes.data.entity.User;
import classes.data.validation.exception.EmailExistsException;
import classes.data.validation.exception.UserNameExistsException;

import java.util.List;

public interface UserService {
    User findOne(long id);
    User getByName(String name);
    User getByUserName(String userName);
    User setStudentOnPractice(User user, PracticeDto practiceDto);
    User registerNewUserAccount(UserDto accountDto, FacultyDto facultyDto) throws UserNameExistsException, EmailExistsException;
    User registerNewHeadMasterAccount(UserDto accountDto, CompanyDto companyDto) throws UserNameExistsException, EmailExistsException;
    List<User> getAll();
}
