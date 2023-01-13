package bit.rigu.homework.lesson5;

import org.springframework.stereotype.Component;

@Component
public class FahrenheitToCelsiusConverter implements Converter{
    public double convert(double temp) {
        return (temp - 32) * 5 / 9;
    }
}
