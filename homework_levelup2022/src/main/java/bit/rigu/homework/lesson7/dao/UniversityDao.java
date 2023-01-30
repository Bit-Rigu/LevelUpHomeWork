package bit.rigu.homework.lesson7.dao;

import bit.rigu.homework.lesson7.model.University;

import java.util.List;
import java.util.Optional;

public interface UniversityDao {
    List<University> findAll();
    int create(University university);
    Optional<University> getById(int id);
    void deleteById(int id);
    void update(University university);
}
