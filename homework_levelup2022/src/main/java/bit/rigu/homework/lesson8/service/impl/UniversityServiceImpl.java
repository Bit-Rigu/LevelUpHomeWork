package bit.rigu.homework.lesson8.service.impl;

import bit.rigu.homework.lesson8.entity.University;
import bit.rigu.homework.lesson8.repository.UniversityRepository;
import bit.rigu.homework.lesson8.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }

    @Override
    public Optional<University> findByName(String name) {
        return universityRepository.findByName(name);
    }

    @Override
    public List<University> findUniversitiesYoungerGivenDataEstablishment(Integer dateOfEstablishment) {
        return universityRepository.findUniversitiesYoungerGivenDataEstablishment(dateOfEstablishment);
    }

    @Override
    @Transactional
    public void create(University university) {
        universityRepository.save(university);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        universityRepository.deleteById(id);
    }
}
