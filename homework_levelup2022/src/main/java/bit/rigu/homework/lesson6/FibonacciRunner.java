package bit.rigu.homework.lesson6;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class FibonacciRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(
                FibonacciRunner.class, args
        );
        ConsoleUserInterfaceWithMemory consoleUserInterface = context.getBean(ConsoleUserInterfaceWithMemory.class);
        while(true) {
            consoleUserInterface.askNumberFibonacci();
            if(consoleUserInterface.getExitStatus()) break;
            consoleUserInterface.printFibonacci();
        }
    }

}
