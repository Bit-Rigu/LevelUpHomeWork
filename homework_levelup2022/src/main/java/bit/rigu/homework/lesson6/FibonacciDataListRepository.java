package bit.rigu.homework.lesson6;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Repository
@ConditionalOnProperty(name = "application.cash.enabled", havingValue = "true")
public class FibonacciDataListRepository implements FibonacciData {

    private List<BigInteger> listOfFibonacci = new ArrayList<>();
    private int number;

    {
        listOfFibonacci.addAll(List.of(BigInteger.ZERO, BigInteger.ONE));
    }

    @Override
    public void setNumberOfFibonacci(int numberOfFibonacci) {
        number = numberOfFibonacci;
    }

    @Override
    public int getNumberOfFibonacci() {
        return number;
    }

    @Override
    public boolean isNumberInMemory() {
        return number < listOfFibonacci.size();
    }

    @Override
    public void putFibonacciAtList(BigInteger fibonacci) {
        listOfFibonacci.add(fibonacci);
    }

    @Override
    public int getSizeOfList() {
        return listOfFibonacci.size();
    }

    @Override
    public BigInteger getFibonacciByNumberFromList(int number) {
        return listOfFibonacci.get(number);
    }
}
