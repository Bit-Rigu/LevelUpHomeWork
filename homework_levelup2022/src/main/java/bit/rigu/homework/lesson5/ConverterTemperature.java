package bit.rigu.homework.lesson5;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConverterTemperature implements Converter {

    final static String CELSIUS = "C";
    final static String KELVIN = "K";
    final static String FAHRENHEIT = "F";

    double unitTemperature;
    String unitFrom;
    String unitTo;


    @Override
    public double convertTo(double temp, String unitFrom, String unitTo)
        throws Exception{
        checkerInputForGrammar(unitFrom, unitTo);
        checkerInputForCorrectness(temp, unitFrom);
        if (unitFrom.equals(unitTo)) return temp;
        if (unitFrom.equals(CELSIUS) &&
                unitTo.equals(KELVIN))
            return convertCelsiusToKelvin(temp);
        if (unitFrom.equals(CELSIUS) &&
                unitTo.equals(FAHRENHEIT))
            return convertCelsiusToFahrenheit(temp);
        if (unitFrom.equals(KELVIN) &&
                unitTo.equals(CELSIUS))
            return convertKelvinToCelsius(temp);
        if (unitFrom.equals(KELVIN) &&
                unitTo.equals(FAHRENHEIT))
            return convertKelvinToFahrenheit(temp);
        if (unitFrom.equals(FAHRENHEIT) &&
                unitTo.equals(CELSIUS))
            return convertFahrenheitToCelsius(temp);
        else return convertFahrenheitToKelvin(temp);
    }

    public static void checkerInputForGrammar(String unitFrom, String unitTo)
        throws Exception {
        if(!unitFrom.equals(CELSIUS)
        && !unitFrom.equals(KELVIN)
        && !unitFrom.equals(FAHRENHEIT))
            throw new Exception("Uncorrected unit of temperature in the first parameter");
        if(!unitTo.equals(CELSIUS)
                && !unitTo.equals(KELVIN)
                && !unitTo.equals(FAHRENHEIT))
            throw new Exception("Uncorrected unit of temperature in the second parameter");
    }

    public static void checkerInputForCorrectness(double temp, String unitFrom)
        throws Exception {
        if(unitFrom.equals(KELVIN) && Math.signum(temp) == -1)
            throw new Exception("Temperature in the Kelvin can't be negative");
    }

    private static double convertCelsiusToKelvin(double temp) {
        return temp + 273.15;
    }
    private static double convertCelsiusToFahrenheit(double temp) {
        return temp * 9 / 5 + 32;
    }
    private static double convertKelvinToCelsius(double temp) {
        return temp - 273.15;
    }
    private static double convertKelvinToFahrenheit(double temp) {
        return (temp - 273.15) * 9 / 5 + 32 ;
    }
    private static double convertFahrenheitToCelsius(double temp) {
        return (temp - 32) * 5 / 9;
    }
    private static double convertFahrenheitToKelvin(double temp) {
        return (temp - 32) * 5 / 9 + 273.15;
    }
}
