package classes.data.service.impl;

import classes.data.dto.UserDto;
import classes.data.entity.*;
import classes.data.repository.StudentRepository;
import classes.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("studentServiceImpl")
@Transactional
public class StudentServiceImpl implements UserService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public User getByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public User getByUserName(String userName) {
        return studentRepository.findByUserName(userName);
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) {

        if (emailExist(accountDto.getEmail())) {
            System.out.println("There is an account with that email address: "  + accountDto.getEmail());
        }

//        University university = new University();
//        university.setName("BSUiR");
//
//        Faculty faculty = new Faculty();
//        faculty.setName("KSiS");
//
//        faculty.setUniversity(university);
//
//        UserProfile userProfile = new UserProfile();
//        userProfile.setType("ADMIN");

//        accountDto.setFaculty(faculty);
//        accountDto.setUserProfile(userProfile);

        User user = new User();

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setEmail(accountDto.getEmail());
        user.setUserName(accountDto.getUserName());
        user.setPassword(accountDto.getPassword());

        user.setFaculty();

//        user.setFaculty(accountDto.getFaculty());
//        user.setUserProfile(accountDto.getUserProfile());

        return studentRepository.save(user);
    }

    private boolean emailExist(String email) {
        User user = studentRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
