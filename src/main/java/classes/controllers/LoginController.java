package classes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String mainPage(){
        return "user";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(){
        return "admin";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error){
        ModelAndView model = new ModelAndView();
        if(error != null){
            model.addObject("error", "Invalid username or password!");
        }
        model.setViewName("login");
        return model;
    }
}
