package classes.data.dto;

import classes.data.entity.Faculty;
import classes.data.entity.UserProfile;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String firstName;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String lastName;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String userName;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String password;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String email;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String faculty;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private UserProfile userProfile;
}
