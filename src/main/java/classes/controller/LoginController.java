package classes.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@SessionAttributes("user")
public class LoginController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {

        ModelAndView model = new ModelAndView();
        model.addObject("user", getPrincipal());

        if (getPrincipalRole().equals("ROLE_ADMIN")) {
            model.setViewName("redirect: admin");
        } else if (getPrincipalRole().equals("ROLE_USER")) {
            model.setViewName("redirect: user");
        } else {
            model.setViewName("redirect: accessDenied");
        }
        return model;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(){

        ModelAndView model = new ModelAndView();

        model.addObject("user", getPrincipal());

        model.setViewName("accessDenied");

        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userPage() {
        ModelAndView model = new ModelAndView("user");
        model.addObject("user", getPrincipal());
        return model;
    }

    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();

        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }

        if (logout != null) {
            model.addObject("logout", "Logged out successfully.");
        }

        model.setViewName("login");
        return model;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage () {
        return "redirect:login?logout=true";
    }

    private String getPrincipal(){

        String userName;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    private String getPrincipalRole(){

        Collection<? extends GrantedAuthority> role;

        String authority = null;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        role = ((UserDetails)principal).getAuthorities();

        for (GrantedAuthority grantedAuthority : role)
        {
            authority = grantedAuthority.getAuthority();
        }

        return authority;
    }

}
