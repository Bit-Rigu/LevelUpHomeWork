package bit.rigu.homework.lesson6;

import java.math.BigInteger;

public interface FibonacciCalculator {

    BigInteger numFibZero = BigInteger.ZERO;
    BigInteger numFibOne = BigInteger.ONE;

    BigInteger calculateFibonacciNumberByNumber(int number);

}
