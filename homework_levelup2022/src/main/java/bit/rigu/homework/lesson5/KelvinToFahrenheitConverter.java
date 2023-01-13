package bit.rigu.homework.lesson5;

import org.springframework.stereotype.Component;

@Component
public class KelvinToFahrenheitConverter implements Converter {
    public double convert(double temp) {
        return (temp - 273.15) * 9 / 5 + 32 ;
    }
}
