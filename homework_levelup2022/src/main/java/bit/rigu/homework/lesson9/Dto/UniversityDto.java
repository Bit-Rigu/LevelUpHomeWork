package bit.rigu.homework.lesson9.Dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UniversityDto {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotBlank
    private String country;

    private Integer yearOfEstablishment;
}
