package classes.controller;

import classes.data.detail.CustomUserDetail;
import classes.data.dto.UniversityDto;
import classes.data.entity.User;
import classes.data.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private UniversityService universityService;

    @RequestMapping(value = "/createUniversity", method = RequestMethod.POST)
    public ResponseEntity<UniversityDto> createUniversity(@RequestBody UniversityDto universityDto) {
        createNewUniversity(universityDto);
        return new ResponseEntity<>(universityDto, HttpStatus.OK);
    }

    private void createNewUniversity(UniversityDto universityDto) {
        universityService.registerNewUniversity(universityDto);
    }

    private User getPrincipal(){
        CustomUserDetail customUserDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customUserDetail.getUser();
    }
}
