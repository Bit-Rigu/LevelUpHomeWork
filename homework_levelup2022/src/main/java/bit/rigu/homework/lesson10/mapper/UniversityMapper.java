package bit.rigu.homework.lesson10.mapper;

import bit.rigu.homework.lesson10.dto.UniversityDto;
import bit.rigu.homework.lesson10.entity.University;
import org.mapstruct.Mapper;
import java.util.Optional;

@Mapper
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
