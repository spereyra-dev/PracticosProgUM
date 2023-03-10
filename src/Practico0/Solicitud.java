package Practico0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solicitud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int positivos = 0;
        int negativos = 0;
        int total = 0;
        List<Integer> listaNums = new ArrayList<>();
        System.out.println("Ingrese un número, para salir ingrese -1");
        numero = sc.nextInt();
        while (numero != -1) {
            listaNums.add(numero);
            if (numero > 0) {
                positivos += numero;
            }
            if (numero < 0) {
                negativos += numero;
            }
            total += numero;
            System.out.println("Ingrese un número, para salir ingrese -1");
            numero = sc.nextInt();
        }
        if (listaNums.size() > 0) {
            System.out.println(Collections.max(listaNums));
            System.out.println(Collections.min(listaNums));
            System.out.println(positivos);
            System.out.println(negativos);
            System.out.println(total / listaNums.size());
        }
    }
}
