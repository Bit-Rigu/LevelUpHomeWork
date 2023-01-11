package bit.rigu.homework.lesson5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.Scanner;

public class ConverterRunner {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ConverterTemperature converter = context.getBean(ConverterTemperature.class);
        File file = new File("src/main/java/bit/rigu/homework/lesson5/resources/DataForTesting.txt");
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNext()) {
                String[] arr = scanner.nextLine().split("\s");
                System.out.printf("%.3f  =  %s\n", converter.convertTo(Double.parseDouble(arr[2]), arr[0], arr[1]), arr[3]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
