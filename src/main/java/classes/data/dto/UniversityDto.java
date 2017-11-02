package classes.data.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UniversityDto {
    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String name;
}
