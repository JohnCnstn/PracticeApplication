package classes.controllers;

import classes.data.entity.Company;
import classes.data.entity.Student;
import classes.data.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(){

        Company company = new Company();
        company.setName("Nope");

        companyService.addCompany(company);

        return new ModelAndView("home");
    }
}
