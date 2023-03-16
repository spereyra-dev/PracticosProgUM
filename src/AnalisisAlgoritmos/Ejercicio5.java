package AnalisisAlgoritmos;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[] numeros = {3, 1, -3, 4, 5, -2, -1};
        int sumaMinima = new Ejercicio5().sumaMinimaPositivaConsecutiva(numeros);
        System.out.println("La suma mínima positiva consecutiva es: " + sumaMinima);
    }

    public int sumaMinimaPositivaConsecutiva(int[] numeros) {
        int sumaActual = 0;
        int sumaMinimaActual = Integer.MAX_VALUE;

        for (int numero : numeros) {
            sumaActual += numero;
            if (sumaActual < 0) {
                sumaActual = 0;
            }
            if (sumaActual > 0 && sumaActual < sumaMinimaActual) {
                sumaMinimaActual = sumaActual;
            }
        }

        return sumaMinimaActual == Integer.MAX_VALUE ? 0 : sumaMinimaActual;
    }
}
