package bit.rigu.homework.lesson7.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class University {

    private Integer id;
    private String name;
    private String country;
    private Integer yearOfEstablishment;

}
