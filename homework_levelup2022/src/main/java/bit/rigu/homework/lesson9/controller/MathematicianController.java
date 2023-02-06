package bit.rigu.homework.lesson9.controller;

import bit.rigu.homework.lesson9.service.MathematicianService;
import bit.rigu.homework.lesson9.Dto.MathematicianDto;
import bit.rigu.homework.lesson9.mapper.MathematicianMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/mathematician")
public class MathematicianController {

    private final MathematicianService service;
    private final MathematicianMapper mapper;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void creatMathematician(@Valid @RequestBody MathematicianDto mathDao){
        service.create(mapper.toEntity(mathDao));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MathematicianDto getMathematician(@PathVariable Integer id) {
        return mapper.toDto(service.findById(id).orElse(null));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateMathematician(@Valid @RequestBody MathematicianDto mathDao,
                                    @PathVariable Integer id){
        service.update(mapper.toEntity(mathDao));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMathematician(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
