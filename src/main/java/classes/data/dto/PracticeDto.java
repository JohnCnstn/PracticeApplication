package classes.data.dto;

import classes.data.entity.HeadMaster;
import classes.data.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class PracticeDto {

    @Getter
    @Setter
    private Date start_date;

    @Getter
    @Setter
    private Date end_date;

    @Getter
    @Setter
    private User user;

    @Getter
    @Setter
    private HeadMaster headMaster;
}
