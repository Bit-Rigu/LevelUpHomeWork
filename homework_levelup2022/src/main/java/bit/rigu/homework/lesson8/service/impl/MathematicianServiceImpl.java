package bit.rigu.homework.lesson8.service.impl;

import bit.rigu.homework.lesson8.entity.Mathematician;
import bit.rigu.homework.lesson8.repository.MathematicianRepository;
import bit.rigu.homework.lesson8.service.MathematicianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MathematicianServiceImpl implements MathematicianService {

    private final MathematicianRepository mathematicianRepository;
    @Override
    public Optional<Mathematician> findById(int id) {
        return mathematicianRepository.findById(id);
    }

    @Override
    public List<Mathematician> findAll() {
        return mathematicianRepository.findAll();
    }

    @Override
    public List<Mathematician> findByYearOfAward(Integer year) {

        return mathematicianRepository.findByYearOfAward(year);
    }

    @Override
    @Transactional
    public void create(Mathematician math) {
        mathematicianRepository.save(math);
    }

    @Override
    @Transactional
    public void update(Mathematician math) {
        mathematicianRepository.save(math);
    }


    @Override
    @Transactional
    public void deletedByNationality(String nationality) {
        mathematicianRepository.findByNationality(nationality).stream()
                .forEach(e -> mathematicianRepository.delete(e));
    }

    private List<Mathematician> findByNationality(String nationality) {
        return mathematicianRepository.findByNationality(nationality);
    }
}
