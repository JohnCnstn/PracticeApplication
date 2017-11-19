package classes.controller;

import classes.data.detail.CustomUserDetail;
import classes.data.dto.CompanyDto;
import classes.data.dto.FacultyDto;
import classes.data.dto.PracticeDto;
import classes.data.dto.UserDto;
import classes.data.entity.User;
import classes.data.service.CompanyService;
import classes.data.service.UserService;
import classes.data.validation.exception.EmailExistsException;
import classes.data.validation.exception.UserNameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showUserPage(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("listOfStudents", userService.getAll());
        return "admin";
    }

    @RequestMapping(value = "/admin/userInfo/{id}", method = RequestMethod.GET)
    public ModelAndView showStudentInfo(@PathVariable("id") int id) {

        User student = userService.findOne(id);

        Date date = new Date();

        PracticeDto practiceDto = new PracticeDto();
        practiceDto.setStart_date(date);

//        setStudentOnPractice(student, practiceDto);

        ModelAndView model = new ModelAndView("student-info");
        model.addObject("student", student);

        return model;
    }

    @RequestMapping(value = "/admin/registration", method = RequestMethod.GET)
    public ModelAndView registerHeadMaster() {

        ModelAndView model = new ModelAndView();

        model.setViewName("registration");
        model.addObject("user", new UserDto());
        model.addObject("company", new CompanyDto());
        model.addObject("list", companyService.getAll());

        return model;

    }

    private User getPrincipal(){
        CustomUserDetail customUserDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customUserDetail.getUser();
    }

    private void createHeadMasterAccount(UserDto accountDto, FacultyDto facultyDto, BindingResult result) {
        try {
            userService.registerNewUserAccount(accountDto, facultyDto);
        } catch (UserNameExistsException e) {
            result.rejectValue("userName", "message", "Username already exists");
        } catch (EmailExistsException e) {
            result.rejectValue("email", "message", "Email already exists");
        }
    }
}
