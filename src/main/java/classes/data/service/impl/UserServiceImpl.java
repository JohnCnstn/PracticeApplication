package classes.data.service.impl;

import classes.data.detail.CustomUserDetail;
import classes.data.dto.CompanyDto;
import classes.data.dto.FacultyDto;
import classes.data.dto.PracticeDto;
import classes.data.dto.UserDto;
import classes.data.entity.*;
import classes.data.repository.StudentRepository;
import classes.data.service.UserService;
import classes.data.validation.exception.EmailExistsException;
import classes.data.validation.exception.UserNameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyServiceImpl facultyService;

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private UserProfileServiceImpl userProfileService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional(readOnly = true)
    public CustomUserDetail loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = getByUserName(userName);
        System.out.println("User : " + user);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }

        CustomUserDetail customUserDetail=new CustomUserDetail();
        customUserDetail.setUser(user);
        customUserDetail.setAuthorities(getGrantedAuthorities(user));

        return customUserDetail;
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        UserProfile userProfile = user.getUserProfile();
        System.out.println("UserProfile : " + userProfile);
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        System.out.print("authorities :" + authorities);
        return authorities;
    }

    @Override
    public User findOne(long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public User getByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public User getByUserName(String userName) {
        return studentRepository.findByUserName(userName);
    }

    @Override
    public void setStudentOnPractice(User user, PracticeDto practiceDto) {

        Practice practice = new Practice();
        practice.setStartDate(practiceDto.getStartDate());

        user.setPractice(practice);

        studentRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return studentRepository.findAll();
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto, FacultyDto facultyDto) throws UserNameExistsException, EmailExistsException {

        if (userNameExists(accountDto.getUserName())) {
            throw new UserNameExistsException("There is an account with that Username: "  + accountDto.getUserName());
        }

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: "  + accountDto.getEmail());
        }

        User user = new User();

        Faculty faculty = facultyService.findOne(facultyDto.getId());

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setEmail(accountDto.getEmail());
        user.setUserName(accountDto.getUserName());

        user.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));

        user.setFaculty(faculty);

        user.setUserProfile(userProfileService.getByType("USER"));

        return studentRepository.save(user);
    }

    @Transactional
    @Override
    public User registerNewHeadMasterAccount(UserDto accountDto, CompanyDto companyDto) throws UserNameExistsException, EmailExistsException {

        if (userNameExists(accountDto.getUserName())) {
            throw new UserNameExistsException("There is an account with that Username: "  + accountDto.getUserName());
        }

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: "  + accountDto.getEmail());
        }

        User user = new User();

        Company company = companyService.findOne(companyDto.getId());

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setEmail(accountDto.getEmail());
        user.setUserName(accountDto.getUserName());

        user.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));

        user.setCompany(company);

        user.setUserProfile(userProfileService.getByType("HEAD_MASTER"));

        return studentRepository.save(user);
    }

    @Override
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
