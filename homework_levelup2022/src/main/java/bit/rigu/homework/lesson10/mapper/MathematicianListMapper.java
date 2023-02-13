package bit.rigu.homework.lesson10.mapper;

import bit.rigu.homework.lesson10.dto.MathematicianDto;
import bit.rigu.homework.lesson10.entity.Mathematician;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(uses = MathematicianMapper.class)
public interface MathematicianListMapper {

    List<Mathematician> toEntityList (List<MathematicianDto> list);
    List<MathematicianDto> toDtoList (List<Mathematician> list);
}
