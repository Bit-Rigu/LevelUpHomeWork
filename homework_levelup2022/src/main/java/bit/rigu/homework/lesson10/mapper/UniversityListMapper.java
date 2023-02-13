package bit.rigu.homework.lesson10.mapper;

import bit.rigu.homework.lesson10.dto.UniversityDto;
import bit.rigu.homework.lesson10.entity.University;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(uses = UniversityMapper.class)
public interface UniversityListMapper {

    List<University> toEntity(List<UniversityDto> list);
    List<UniversityDto> toDto(List<University> list);
}
