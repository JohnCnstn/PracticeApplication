package classes.controller;

import classes.data.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {

    @RequestMapping(value = { "/sign-up" }, method = RequestMethod.GET)
    public String showSignUpForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "sign-up";
    }

}
