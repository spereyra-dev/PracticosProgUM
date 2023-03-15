package Practico0;

public class Conversion {

    public static void main(String[] args) {
        System.out.println(new Conversion().conversionAFahrenheit(1));
    }

    public double conversionAFahrenheit(Integer tempCelsius) {
        return 1.8 * tempCelsius + 32;
    }
}
