package bit.rigu.homework.lesson9.mapper;

import bit.rigu.homework.lesson9.entity.Mathematician;
import bit.rigu.homework.lesson9.Dto.MathematicianDto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(uses = MathematicianMapper.class)
public interface MathematicianListMapper {

    List<Mathematician> toEntityList (List<MathematicianDto> list);
    List<MathematicianDto> toDtoList (List<Mathematician> list);
}
