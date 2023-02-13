package bit.rigu.homework.lesson10.service.impl;

import bit.rigu.homework.lesson10.entity.Mathematician;
import bit.rigu.homework.lesson10.repository.MathematicianRepository;
import bit.rigu.homework.lesson10.service.MathematicianService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
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
    public void deleteByNationality(String nationality) {
        mathematicianRepository.deleteByNationality(nationality);
    }

    @Override
    @Transactional
    @Modifying
    public void deleteById(int id) {
        mathematicianRepository.deleteById(id);
    }

}
