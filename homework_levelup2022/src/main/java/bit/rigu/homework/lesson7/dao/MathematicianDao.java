package bit.rigu.homework.lesson7.dao;

import bit.rigu.homework.lesson7.model.Mathematician;

import java.util.List;
import java.util.Optional;

public interface MathematicianDao {
    List<Mathematician> findAll();
    int create(Mathematician math);
    Optional<Mathematician> getById(int id);
    void deleteById(int id);
    void update(Mathematician math);
}
