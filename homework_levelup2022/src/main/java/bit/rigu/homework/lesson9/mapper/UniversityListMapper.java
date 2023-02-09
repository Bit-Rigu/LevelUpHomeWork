package bit.rigu.homework.lesson9.mapper;

import bit.rigu.homework.lesson9.entity.University;
import bit.rigu.homework.lesson9.Dto.UniversityDto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(uses = UniversityMapper.class)
public interface UniversityListMapper {

    List<University> toEntity(List<UniversityDto> list);
    List<UniversityDto> toDto(List<University> list);
}
