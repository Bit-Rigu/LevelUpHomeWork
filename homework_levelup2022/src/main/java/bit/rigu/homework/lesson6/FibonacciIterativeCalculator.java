package bit.rigu.homework.lesson6;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@NoArgsConstructor
@Service
@ConditionalOnProperty(name = "application.type.calculator", havingValue = "iterative")
public class FibonacciIterativeCalculator implements FibonacciCalculator{


    @Override
    public BigInteger calculateFibonacciNumberByNumber(int number) {
        return functionFibonacci(number,
                numFibOne,
                numFibZero);
    }

    private BigInteger functionFibonacci(int n,
                                         BigInteger actualFibonacciNumber,
                                         BigInteger previousFibonacciNumber) {
        if (n == 1) return actualFibonacciNumber;
        else if(n == 0) return previousFibonacciNumber;
        else
            return functionFibonacci(n-1,
                    actualFibonacciNumber.add(previousFibonacciNumber),
                    actualFibonacciNumber);
    }

}
