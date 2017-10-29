package classes.data.service.impl;

import classes.data.entity.User;
import classes.data.repository.StudentRepository;
import classes.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("studentServiceImpl")
@Transactional
public class StudentServiceImpl implements UserService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public User getByName(String name) {
        return null;
    }

    @Override
    public User getByUserName(String userName) {
        return studentRepository.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (UserDetails) studentRepository.findByUserName(s);
    }
}
