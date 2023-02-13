package bit.rigu.homework.lesson10.dto;

import bit.rigu.homework.lesson10.entity.University;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class MathematicianDto {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @Min(1936)
    private Integer yearOfAward;
    @NotBlank
    private String nationality;

    private String researchArea;

    private University university;
}
