package bit.rigu.homework.lesson9.service;

import bit.rigu.homework.lesson9.entity.Mathematician;

import java.util.List;
import java.util.Optional;

public interface MathematicianService {

    Optional<Mathematician> findById(int id);
    List<Mathematician> findAll();
    List<Mathematician> findByYearOfAward(Integer year);
    void create(Mathematician math);
    void update(Mathematician math);
    void deleteByNationality(String nationality);
    void deleteById(int id);
}
