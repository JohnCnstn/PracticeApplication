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
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private UserService service;

    @Autowired
    private FacultyServiceImpl facultyService;

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String showSignUpForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        model.addAttribute("list", facultyService.getAll());
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") UserDto accountDto,
            BindingResult result) {

        ModelAndView model = new ModelAndView();

        User registered = new User();

        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto);
        }
        if (registered == null) {
            model.addObject("error", "Email already exists!");
        }
        if (result.hasErrors()) {
            model.addObject("error", "Your email is incorrect!");
            model.setViewName("sign-up");
            model.addObject("list", facultyService.getAll());
            model.addObject("user", accountDto);
            return model;
        } else {
            return new ModelAndView("user", "user", accountDto);
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
