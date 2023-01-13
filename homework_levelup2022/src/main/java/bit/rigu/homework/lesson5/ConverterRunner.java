package bit.rigu.homework.lesson5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.InputStream;
import java.util.Scanner;

public class ConverterRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CelsiusToFahrenheitConverter celsiusToFahrenheitConverter =
               context.getBean(CelsiusToFahrenheitConverter.class);
        CelsiusToKelvinConverter celsiusToKelvinConverter =
                context.getBean(CelsiusToKelvinConverter.class);
        FahrenheitToCelsiusConverter fahrenheitToCelsiusConverter =
                context.getBean(FahrenheitToCelsiusConverter.class);
        FahrenheitToKelvinConverter fahrenheitToKelvinConverter =
                context.getBean(FahrenheitToKelvinConverter.class);
        KelvinToFahrenheitConverter kelvinToFahrenheitConverter =
                context.getBean(KelvinToFahrenheitConverter.class);
        KelvinToCelsiusConverter kelvinToCelsiusConverter =
                context.getBean(KelvinToCelsiusConverter.class);
        InputStream is = celsiusToFahrenheitConverter.getClass().getResourceAsStream("/DataForTesting.txt");
        try(Scanner scanner = new Scanner(is)){
            while(scanner.hasNext()) {
                String[] arr = scanner.nextLine().split("\s");
                System.out.printf("%.3f  =  %s\n",
                        switch(arr[0]) {
                            case "FahrenheitToCelsius"  ->
                                fahrenheitToCelsiusConverter.convert(
                                        Double.parseDouble(arr[1])
                                );
                            case "FahrenheitToKelvin"   ->
                                fahrenheitToKelvinConverter.convert(
                                        Double.parseDouble(arr[1])
                                );
                            case "CelsiusToFahrenheit"  ->
                                celsiusToFahrenheitConverter.convert(
                                        Double.parseDouble(arr[1])
                                );
                            case "CelsiusToKelvin"      ->
                                celsiusToKelvinConverter.convert(
                                        Double.parseDouble(arr[1])
                                );
                            case "KelvinToCelsius"      ->
                                kelvinToCelsiusConverter.convert(
                                        Double.parseDouble(arr[1])
                                );
                            case "KelvinToFahrenheit"    ->
                                kelvinToFahrenheitConverter.convert(
                                        Double.parseDouble(arr[1])
                                );
                            default     ->  Double.parseDouble("0");
                        }, arr[2]);
            }
        }

    }
}
