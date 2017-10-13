package classes.data.service.impl;

import classes.data.entity.Company;
import classes.data.repository.CompanyRepository;
import classes.data.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company) {
        Company savedCompany = companyRepository.saveAndFlush(company);
        return savedCompany;
    }

    public void delete(long id) {
        companyRepository.delete(id);
    }

    public Company getByName(String name) {
        return companyRepository.findByName(name);
    }

    public Company editCompany(Company company) {
        return companyRepository.saveAndFlush(company);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
