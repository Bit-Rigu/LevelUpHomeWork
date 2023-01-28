package bit.rigu.homework.lesson6;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;


@NoArgsConstructor
@Setter
@Getter
@Repository
@ConditionalOnProperty(name = "application.cash.enabled", havingValue = "false")
public class FibonacciDataFieldRepository implements FibonacciData{

    int numberOfFibonacci;

}
