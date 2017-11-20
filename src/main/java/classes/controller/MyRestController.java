package classes.controller;

import classes.data.dto.PracticeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/head-master")
public class MyRestController {

    @RequestMapping(value = "/postPractice", method = RequestMethod.POST)
    public ResponseEntity<PracticeDto> postPractice(@RequestBody PracticeDto practiceDto) {
//        practiceService.registerNewPractice(practiceDto);
//        return new Response("Done", practiceDto);
        return new ResponseEntity<>(practiceDto, HttpStatus.OK);
    }
}
