package PracticoRecursividad;

public class Recursividad {
    // Método para calcular el factorial de un número
    public int factorial(int valor) {
        if (valor == 0) {
            return 1;
        } else {
            return valor * factorial(valor - 1);
        }
    }

    // Método para calcular la potencia de un número real elevado a un entero
    public double potencia(double valor, int potencia) {
        if (potencia == 0) {
            return 1;
        } else {
            return valor * potencia(valor, potencia - 1);
        }
    }

    // Método para calcular la suma de los N primeros números naturales
    public int sumN(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumN(n - 1);
        }
    }

    public static void main(String[] args) {
        Recursividad recursividad = new Recursividad();

        // Prueba de factorial
        System.out.println("Factorial de 5: " + recursividad.factorial(5));

        // Prueba de potencia
        System.out.println("Potencia de 2 elevado a 4: " + recursividad.potencia(2, 4));

        // Prueba de sumN
        System.out.println("Suma de los primeros 10 números naturales: " + recursividad.sumN(10));
    }
}