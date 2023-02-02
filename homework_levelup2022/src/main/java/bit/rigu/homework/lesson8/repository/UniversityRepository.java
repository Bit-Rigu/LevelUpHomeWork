package bit.rigu.homework.lesson8.repository;

import bit.rigu.homework.lesson8.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Integer> {

    @Query("SELECT university FROM University university " +
            "WHERE university.name = :name")
    Optional<University> findByName(String name);

    @Query("SELECT university FROM University university " +
            "WHERE university.yearOfEstablishment >= :date")
    List<University> findUniversitiesYoungerGivenDataEstablishment(Integer date);
}
