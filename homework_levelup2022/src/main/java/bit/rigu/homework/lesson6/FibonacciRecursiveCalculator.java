package bit.rigu.homework.lesson6;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@NoArgsConstructor
@Service
@ConditionalOnProperty(name = "application.type.calculator", havingValue = "recursive")
public class FibonacciRecursiveCalculator implements FibonacciCalculator{


    @Override
    public BigInteger calculateFibonacciNumberByNumber(int number) {
        return functionFibonacci(number);
    }

    private BigInteger functionFibonacci(int n) {
        if (n == 0) return BigInteger.ZERO;
        else if (n == 1) return BigInteger.ONE;
        else return functionFibonacci(n - 1).add(functionFibonacci(n - 2));
    }

}
