package bit.rigu.homework.lesson6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsoleUserInterfaceWithMemory extends ConsoleUserInterface {


    public ConsoleUserInterfaceWithMemory(@Autowired FibonacciCalculator calc,
                                          @Autowired FibonacciData data) {
        super(calc, data);
    }


    @Override
    public void printFibonacci() {
        int size = data.getSizeOfList();
        while(!data.isNumberInMemory()) {
            data.putFibonacciAtList(calc.calculateFibonacciNumberByNumber(size++));
        }
        System.out.println(data.getFibonacciByNumberFromList(
                data.getNumberOfFibonacci()
        ));
    }
}
