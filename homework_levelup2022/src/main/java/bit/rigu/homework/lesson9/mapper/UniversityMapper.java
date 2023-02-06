package bit.rigu.homework.lesson9.mapper;

import bit.rigu.homework.lesson9.entity.University;
import bit.rigu.homework.lesson9.Dto.UniversityDto;
import org.mapstruct.Mapper;

import java.util.Optional;


@Mapper(componentModel = "spring")
public interface UniversityMapper {

    University toEntity (UniversityDto universityDto);
    UniversityDto toDto (University university);
    default Optional<University> toEntityOption(Optional<UniversityDto> optional) {
        return optional.map(this::toEntity);
    }
    default Optional<UniversityDto> toDtoOption(Optional<University> optional) {
        return optional.map(this::toDto);
    }
}
