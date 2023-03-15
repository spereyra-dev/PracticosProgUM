package Practico0;

import java.util.Scanner;

public class NumeroPrimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println("Ingrese un número");
        numero = sc.nextInt();
        System.out.println("El siguiente número es primo: " + new NumeroPrimo().esNumeroPrimo(numero));
    }

    public boolean esNumeroPrimo(int numero) {
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            if (numero % x == 0) {
                return false;
            }
        }
        return true;
    }
}
