package classes.data.dto;

import classes.data.entity.UserProfile;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

//    @Email
//    @Pattern(regexp=".+@.+\\..+", message="Wrong email!")
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
