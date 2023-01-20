package bit.rigu.homework.lesson6;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;


@NoArgsConstructor
@Repository
@ConditionalOnProperty(name = "application.cash.enabled", havingValue = "false")
public class FibonacciDataFieldRepository implements FibonacciData{

    int numberOfFibonacci;

    @Override
    public void setNumberOfFibonacci(int numberOfFibonacci) {
        this.numberOfFibonacci = numberOfFibonacci;
    }

    @Override
    public int getNumberOfFibonacci() {
        return numberOfFibonacci;
    }
}
