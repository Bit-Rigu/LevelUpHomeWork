package bit.rigu.homework.lesson9.controller;


import bit.rigu.homework.lesson9.service.UniversityService;
import bit.rigu.homework.lesson9.Dto.UniversityDto;
import bit.rigu.homework.lesson9.mapper.UniversityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService service;
    private final UniversityMapper mapper;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUniversity(@Valid @RequestBody UniversityDto universityDto) {
        service.create(mapper.toEntity(universityDto));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UniversityDto getUniversity(@PathVariable Integer id) {
        return mapper.toDtoOption(service.findById(id)).orElse(null);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUniversity(@Valid @RequestBody UniversityDto universityDto,
                                 @PathVariable Integer id) {
        service.update(mapper.toEntity(universityDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUniversity(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
