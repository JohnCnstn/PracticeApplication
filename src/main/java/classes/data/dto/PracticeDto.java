package classes.data.dto;

import classes.data.entity.HeadMaster;
import classes.data.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class PracticeDto {

    @Getter
    @Setter
    private String startDate;

    @Getter
    @Setter
    private String endDate;

//    @Getter
//    @Setter
//    private User user;
//
//    @Getter
//    @Setter
//    private HeadMaster headMaster;
}
