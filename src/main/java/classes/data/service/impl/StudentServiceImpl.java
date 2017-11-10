package classes.data.service.impl;

import classes.data.dto.UserDto;
import classes.data.entity.*;
import classes.data.repository.StudentRepository;
import classes.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentServiceImpl")
@Transactional
public class StudentServiceImpl implements UserService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyServiceImpl facultyService;

    @Autowired
    private UserProfileServiceImpl userProfileService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public User getByUserName(String userName) {
        return studentRepository.findByUserName(userName);
    }

    @Override
    public List<User> getAll() {
        return studentRepository.findAll();
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) {

        if (emailExist(accountDto.getEmail())) {
            System.out.println("There is an account with that email address: "  + accountDto.getEmail());
        }

        User user = new User();

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setEmail(accountDto.getEmail());
        user.setUserName(accountDto.getUserName());

        user.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));

        user.setFaculty(facultyService.getByName(accountDto.getFaculty()));

        user.setUserProfile(userProfileService.getByType("USER"));

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
