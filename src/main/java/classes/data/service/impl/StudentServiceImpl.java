package classes.data.service.impl;

import classes.data.dto.FacultyDto;
import classes.data.dto.PracticeDto;
import classes.data.dto.UserDto;
import classes.data.entity.*;
import classes.data.repository.StudentRepository;
import classes.data.service.StudentService;
import classes.data.validation.exception.EmailExistsException;
import classes.data.validation.exception.UserNameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyServiceImpl facultyService;

    @Autowired
    private UserProfileServiceImpl userProfileService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findOne(long id) {
        return studentRepository.findOne(id);
    }

    public User getByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public User getByUserName(String userName) {
        return studentRepository.findByUserName(userName);
    }

    public void setStudentOnPractice(Student student, PracticeDto practiceDto) {

        Practice practice = new Practice();
        practice.setStartDate(practiceDto.getStartDate());

        student.setPractice(practice);

        studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Transactional
    public User registerNewUserAccount(UserDto accountDto, FacultyDto facultyDto) throws UserNameExistsException, EmailExistsException {

        if (userNameExists(accountDto.getUserName())) {
            throw new UserNameExistsException("There is an account with that Username: "  + accountDto.getUserName());
        }

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: "  + accountDto.getEmail());
        }

        Student student = new Student();

        Faculty faculty = facultyService.findOne(facultyDto.getId());

        student.setFirstName(accountDto.getFirstName());
        student.setLastName(accountDto.getLastName());
        student.setEmail(accountDto.getEmail());
        student.setUserName(accountDto.getUserName());

        student.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));

        student.setFaculty(faculty);

        student.setUserProfile(userProfileService.getByType("USER"));

        return studentRepository.save(student);
    }

//    @Transactional
//    @Override
//    public User registerNewHeadMasterAccount(UserDto accountDto, CompanyDto companyDto) throws UserNameExistsException, EmailExistsException {
//
//        if (userNameExists(accountDto.getUserName())) {
//            throw new UserNameExistsException("There is an account with that Username: "  + accountDto.getUserName());
//        }
//
//        if (emailExist(accountDto.getEmail())) {
//            throw new EmailExistsException("There is an account with that email address: "  + accountDto.getEmail());
//        }
//
//        HeadMaster headMaster = new HeadMaster();
//
//        Company company = companyService.findOne(companyDto.getId());
//
//        headMaster.setFirstName(accountDto.getFirstName());
//        headMaster.setLastName(accountDto.getLastName());
//        headMaster.setEmail(accountDto.getEmail());
//        headMaster.setUserName(accountDto.getUserName());
//
//        headMaster.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));
//
//        headMaster.setCompany(company);
//
//        headMaster.setUserProfile(userProfileService.getByType("HEAD_MASTER"));
//
//        return studentRepository.save(user);
//    }

    public void delete(long id) {
        studentRepository.delete(id);
    }

    private boolean userNameExists(String userName) {
        User user = studentRepository.findByUserName(userName);
        return user != null;
    }

    private boolean emailExist(String email) {
        User user = studentRepository.findByEmail(email);
        return user != null;
    }
}
