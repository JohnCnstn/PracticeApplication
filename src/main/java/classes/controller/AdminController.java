package classes.controller;

import classes.data.detail.CustomUserDetail;
import classes.data.entity.User;
import classes.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private UserService studentService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showUserPage(Model model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("listOfStudents", studentService.getAll());
        return "admin";
    }

    @RequestMapping(value = "/admin/userInfo/{id}", method = RequestMethod.GET)
    public ModelAndView showStudentInfo(@PathVariable("id") int id) {
        User student = studentService.findOne(id);
        ModelAndView model = new ModelAndView("student-info");
        model.addObject("student", student);
        return model;
    }

    @RequestMapping(value = "/admin/{id}/delete", method = RequestMethod.GET)
    public String deleteRegistration(@PathVariable("id") int id) {
//        User user = studentService.findOne(id);
        return "student-info";
    }

    private User getPrincipal(){
        CustomUserDetail customUserDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customUserDetail.getUser();
    }
}
