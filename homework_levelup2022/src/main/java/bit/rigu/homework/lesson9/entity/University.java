package bit.rigu.homework.lesson9.entity;


import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


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
