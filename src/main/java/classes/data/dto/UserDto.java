package classes.data.dto;

import classes.data.entity.UserProfile;
import classes.data.validation.ValidEmail;
import classes.data.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ValidPassword
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

    @Getter
    @Setter
    private String matchingPassword;

    @ValidEmail
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
