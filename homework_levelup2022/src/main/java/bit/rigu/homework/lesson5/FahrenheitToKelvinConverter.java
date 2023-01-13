package bit.rigu.homework.lesson5;

import org.springframework.stereotype.Component;

@Component
public class FahrenheitToKelvinConverter implements Converter {
    public double convert(double temp) {
        return (temp - 32) * 5 / 9 + 273.15;
    }
}
