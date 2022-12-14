package bit.rigu.homework.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
public class ConverterDollarsToRubles {
    public static void main(String[] args) {
        SpringApplication.run(ConverterDollarsToRubles.class, args);
    }

    @RestController
    public class ConverterController {

        @GetMapping({"/converter","/converter/{countDollars}"})
        public String hello(@PathVariable Optional<Double> countDollars) {
            return String.format("%10.4f rubles ", countDollars.orElse(0d)*63.80);
        }
    }


}
