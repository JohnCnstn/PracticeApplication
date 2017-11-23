package classes.data.service;

import classes.data.dto.FacultyDto;
import classes.data.dto.PracticeDto;
import classes.data.dto.UserDto;
import classes.data.entity.Student;
import classes.data.entity.User;
import classes.data.validation.exception.EmailExistsException;
import classes.data.validation.exception.UserNameExistsException;

import java.util.List;

public interface StudentService {
    User findOne(long id);
    User getByName(String name);
    User getByUserName(String userName);
    void setStudentOnPractice(Student student, PracticeDto practiceDto);
    User registerNewUserAccount(UserDto accountDto, FacultyDto facultyDto) throws UserNameExistsException, EmailExistsException;
    void delete(long id);
    List<Student> getAll();
}
