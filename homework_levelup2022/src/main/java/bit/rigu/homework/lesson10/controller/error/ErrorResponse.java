package bit.rigu.homework.lesson10.controller.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {

    private final int code;
    private final String message;
    private List<Field> fields = new ArrayList<>();

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class Field {
        private final String name;
        private final String message;
    }

    public void addField(String field, String message) {
        if (Objects.isNull(fields)) {
            fields = new ArrayList<>();
        }
        fields.add(new Field(field, message));
    }


}
