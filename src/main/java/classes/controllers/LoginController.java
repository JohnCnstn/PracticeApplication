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
    CompanyService companyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(Model model){
        Student student = new Student();
        student.setFirstName("Pasha");
        String name = student.getFirstName();

        Company company = new Company();
        company.setName("NetCracker");

        companyService.addCompany(company);

        model.addAttribute("studentName", name);

        return new ModelAndView("home","student", new Student());
    }
}
