package bit.rigu.homework.lesson9.service;

import bit.rigu.homework.lesson9.entity.University;

import java.util.List;
import java.util.Optional;

public interface UniversityService {
    List<University> findAll();
    Optional<University> findByName(String name);
    List<University> findUniversitiesYoungerGivenDataEstablishment(Integer dateOfEstablishment);
    void create(University university);
    void deleteById(int id);
    Optional<University> findById(int id);
    void update(University university);
}
