package bit.rigu.homework.lesson5;

import org.springframework.stereotype.Component;

@Component
public class CelsiusToFahrenheitConverter implements Converter{
    public double convert(double temp) {
        return temp * 9 / 5 + 32;
    }

}
