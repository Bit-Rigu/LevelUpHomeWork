package bit.rigu.homework.lesson10.mapper;

import bit.rigu.homework.lesson10.dto.MathematicianDto;
import bit.rigu.homework.lesson10.entity.Mathematician;
import org.mapstruct.Mapper;
import java.util.Optional;

@Mapper
public interface MathematicianMapper {

    Mathematician toEntity (MathematicianDto mathDto);
    MathematicianDto toDto (Mathematician math);
    default Optional<Mathematician> toEntityOption(Optional<MathematicianDto> optional){
        return optional.map(this::toEntity);
    }
    default Optional<MathematicianDto> toDtoOption(Optional<Mathematician> optional){
        return optional.map(this::toDto);
    }
}
