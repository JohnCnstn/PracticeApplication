package classes.controller;

import classes.data.dto.UserDto;
import classes.data.entity.User;
import classes.data.service.UserService;
import classes.data.service.impl.FacultyServiceImpl;
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
    UserService service;

    @Autowired
    FacultyServiceImpl facultyService;

    @RequestMapping(value = { "/sign-up" }, method = RequestMethod.GET)
    public String showSignUpForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        model.addAttribute("list", facultyService.getAll());
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto accountDto,BindingResult result) {

        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("sign-up", "user", accountDto);
        }
        else {
            return new ModelAndView("user", "user", accountDto);
        }
    }

    private User createUserAccount(UserDto accountDto) {

        User registered;

        registered = service.registerNewUserAccount(accountDto);

        return registered;
    }
}
