package classes.controller;

import classes.data.detail.CustomUserDetail;
import classes.data.dto.*;
import classes.data.entity.User;
import classes.data.service.CompanyService;
import classes.data.service.HeadMasterService;
import classes.data.service.StudentService;
import classes.data.validation.exception.EmailExistsException;
import classes.data.validation.exception.UserNameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

@Controller
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private HeadMasterService headMasterService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showUserPage(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("listOfStudents", studentService.getAll());
        model.addAttribute("universityDto", new UniversityDto());
        model.addAttribute("facultyDto", new FacultyDto());
        return "students";
    }

    @RequestMapping(value = "/admin/userInfo/{id}", method = RequestMethod.GET)
    public ModelAndView showStudentInfo(@PathVariable("id") int id) {

        User student = studentService.findOne(id);

        ModelAndView model = new ModelAndView("student-info");
        model.addObject("student", student);

        return model;
    }

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {

        studentService.delete(id);

        return new ModelAndView("redirect:/admin");

    }

    @RequestMapping(value = "/admin/sign-up", method = RequestMethod.GET)
    public ModelAndView showRegisterHeadMaster() {

        ModelAndView model = new ModelAndView();

        model.setViewName("sign-up");
        model.addObject("user", new UserDto());
        model.addObject("company", new CompanyDto());
        model.addObject("list", companyService.getAll());

        return model;

    }

    @RequestMapping(value = "/admin/sign-up", method = RequestMethod.POST)
    public ModelAndView registerHeadMaster(@ModelAttribute("company") CompanyDto companyDto,
                                            @Valid @ModelAttribute("user") UserDto accountDto,
                                            BindingResult result) {

        ModelAndView model = new ModelAndView();

        if (!result.hasErrors()) {
            createHeadMasterAccount(accountDto, companyDto, result);
        }

        if (result.hasErrors()) {
            model.addObject("list", companyService.getAll());
            model.setViewName("sign-up");
        } else {
            model.setViewName("redirect:/admin");
        }
        model.addObject("user", accountDto);
        return model;
    }

    private User getPrincipal(){
        CustomUserDetail customUserDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customUserDetail.getUser();
    }

    private void createHeadMasterAccount(UserDto accountDto, CompanyDto companyDto, BindingResult result) {
        try {
            headMasterService.registerNewHeadMasterAccount(accountDto, companyDto);
        } catch (UserNameExistsException e) {
            result.rejectValue("userName", "message", "Username already exists");
        } catch (EmailExistsException e) {
            result.rejectValue("email", "message", "Email already exists");
        }
    }
}
