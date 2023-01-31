package bit.rigu.homework.lesson7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mathematician {

    private Integer id;
    private String name;
    private Integer yearOfAward;
    private String nationality;
    private String researchArea;
    private University almaMater;
}
