package classes.controller;

import classes.data.dto.UserDto;
import classes.data.entity.User;
import classes.data.service.UserService;
import classes.data.service.impl.FacultyServiceImpl;
import classes.data.validation.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@SessionAttributes({"user", "list"})
public class SignUpController {

    @Autowired
    private UserService service;

    @Autowired
    private FacultyServiceImpl facultyService;

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public ModelAndView showSignUpForm() {

        ModelAndView model = new ModelAndView();

        model.setViewName("sign-up");
        model.addObject("user", new UserDto());
        model.addObject("list", facultyService.getAll());

        return model;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String registerUserAccount(
            @Valid @ModelAttribute("user") UserDto accountDto,
            BindingResult result, Model model) {

        User registered = new User();

        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto);
        }
        if (registered == null) {
            model.addAttribute("error", "Email already exists!");
        }
        if (result.hasErrors()) {
            model.addAttribute("list", facultyService.getAll());
            return "sign-up";
        } else {
            return "user";
        }
    }

    private User createUserAccount(UserDto accountDto) {

        User registered;

        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }

        return registered;
    }
}
