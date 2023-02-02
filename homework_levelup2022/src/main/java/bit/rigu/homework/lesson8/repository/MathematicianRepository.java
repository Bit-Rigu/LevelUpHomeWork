package bit.rigu.homework.lesson8.repository;

import bit.rigu.homework.lesson8.entity.Mathematician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MathematicianRepository extends JpaRepository<Mathematician, Integer> {

    @Query("SELECT mathematician FROM Mathematician mathematician " +
            "WHERE mathematician.yearOfAward = :year")
    List<Mathematician> findByYearOfAward(Integer year);

    @Query("DELETE FROM Mathematician mathematician " +
            "WHERE mathematician.nationality=:nationality")
    void deleteByNationality(String nationality);

    @Query("SELECT mathematician FROM Mathematician mathematician " +
            "WHERE mathematician.nationality = :nationality")
    List<Mathematician> findByNationality(String nationality);

}
