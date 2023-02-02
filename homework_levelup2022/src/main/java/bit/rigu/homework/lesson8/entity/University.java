package bit.rigu.homework.lesson8.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="university")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class University {

    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name= "year_of_establishment")
    private Integer yearOfEstablishment;

}
