package bit.rigu.homework.lesson9.repository;

import bit.rigu.homework.lesson9.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<bit.rigu.homework.lesson9.entity.University, Integer> {

    @Query("SELECT university FROM University university " +
            "WHERE university.name = :name")
    Optional<bit.rigu.homework.lesson9.entity.University> findByName(String name);

    @Query("SELECT university FROM University university " +
            "WHERE university.yearOfEstablishment >= :date")
    List<bit.rigu.homework.lesson9.entity.University> findUniversitiesYoungerGivenDataEstablishment(Integer date);
}
