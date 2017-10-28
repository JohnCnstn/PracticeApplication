package classes.data.service.impl;

import classes.data.entity.User;
import classes.data.entity.UserProfile;
import classes.data.repository.StudentRepository;
import classes.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public User getByName(String name) {
        return studentRepository.findByUserName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = studentRepository.findByUserName(s);
        System.out.println("User : " + user);
        if(user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        UserProfile userProfile = user.getUserProfile();
        System.out.println("UserProfile : " + userProfile);
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));

        System.out.print("authorities :" + authorities);
        return authorities;
    }

//    private GrantedAuthority getGrantedAuthorities(User user){
//        GrantedAuthority authorities;
//
//        UserProfile userProfile = user.getUserProfile();
//        System.out.println("UserProfile : " + userProfile);
//        authorities = new SimpleGrantedAuthority("ROLE_" + userProfile.getType());
//
//        System.out.print("authorities :" + authorities);
//        return authorities;
//    }

}
