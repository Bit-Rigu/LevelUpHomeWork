package bit.rigu.homework.lesson6;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ConsoleUserInterface implements UserInterface {


    protected final FibonacciCalculator calc;
    protected final FibonacciData data;
    protected boolean flagExit = false;

    @Override
    public void askNumberFibonacci() {

        boolean isNumber;
        String str;

        do {
            System.out.println("Put the number of fibonacci or exit");
            Scanner sc = new Scanner(System.in);
            str = sc.next();
            isNumber = str.matches("\\d*");
            if(str.equals("exit")) break;
        } while(!isNumber);
        if(isNumber) data.setNumberOfFibonacci(Integer.parseInt(str));
        else flagExit = true;
    }

    @Override
    public void printFibonacci() {

        System.out.println(
                calc.calculateFibonacciNumberByNumber(
                        data.getNumberOfFibonacci()
                ));

    }

    public boolean getExitStatus(){
        return flagExit;
    }
}
