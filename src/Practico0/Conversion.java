package Practico0;

public class Conversion {

    public double conversionAFahrenheit(Integer tempCelsius) {
        return 1.8 * tempCelsius + 32;
    }

    public static void main(String[] args) {
        System.out.println(new Conversion().conversionAFahrenheit(1));
    }
}
