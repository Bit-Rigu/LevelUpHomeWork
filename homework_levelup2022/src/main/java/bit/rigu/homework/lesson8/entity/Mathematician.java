package bit.rigu.homework.lesson8.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mathematician {
    @Id
    @Column(name = "math_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name ="year_of_award")
    private Integer yearOfAward;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "research_area")
    private String researchArea;
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
}
