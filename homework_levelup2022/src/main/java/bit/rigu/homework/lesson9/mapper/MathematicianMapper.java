package bit.rigu.homework.lesson9.mapper;

import bit.rigu.homework.lesson9.entity.Mathematician;
import bit.rigu.homework.lesson9.Dto.MathematicianDto;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
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
