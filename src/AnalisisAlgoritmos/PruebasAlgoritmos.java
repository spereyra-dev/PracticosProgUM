package AnalisisAlgoritmos;

public class PruebasAlgoritmos {

    public static void main(String[] args) {
        medirTiempo("caso 1 con N menor", () -> caso1(10));
        medirTiempo("caso 1 con N mayor", () -> caso1(1000));
        System.out.println();
        medirTiempo("caso 2 con N menor", () -> caso2(10));
        medirTiempo("caso 2 con N mayor", () -> caso2(1000));
        System.out.println();
        medirTiempo("caso 3 con N menor", () -> caso3(10));
        medirTiempo("caso 3 con N mayor", () -> caso3(1000));
        System.out.println();
        medirTiempo("caso 4 con N menor", () -> caso4(10));
        medirTiempo("caso 4 con N mayor", () -> caso4(1000));
        System.out.println();
        medirTiempo("caso 5 con N menor", () -> caso5(10));
        medirTiempo("caso 5 con N mayor", () -> caso5(1000));
    }

    //A)
    //El tiempo de ejecución de este código es O(n) porque el bucle for se ejecuta n veces y cada iteración toma un
    //tiempo constante, por lo que la complejidad asintótica es lineal con respecto a n.
    //C)
    //El tiempo de ejecución aumenta linealmente con n, por lo que se respeta la cota superior.
    public static int caso1(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum++;
        }
        return sum;
    }

    //A)
    //El tiempo de ejecución de este código es O(n^2) porque hay dos bucles for anidados y cada iteración toma un tiempo
    //constante, por lo que la complejidad asintótica es cuadrática con respecto a n.
    //C)
    //El tiempo de ejecución aumenta cuadráticamente con n, por lo que se respeta la cota superior.
    public static int caso2(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        return sum;
    }

    //A)
    //El tiempo de ejecución de este código es O(n^3) porque hay dos bucles for anidados y uno externo y cada iteración
    //toma un tiempo constante, por lo que la complejidad asintótica es cúbica con respecto a n.
    //C)
    //El tiempo de ejecución aumenta cúbicamente con n, por lo que se respeta la cota superior.
    public static int caso3(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * n; j++) {
                sum++;
            }
        }
        return sum;
    }

    //A)
    //El tiempo de ejecución de este código es O(n^2) porque hay dos bucles for anidados y el segundo llega a un límite
    //de i en cada iteración, por lo que la complejidad asintótica es cuadrática con respecto a n.
    //C)
    //El tiempo de ejecución aumenta cuadráticamente con n, por lo que se respeta la cota superior.
    public static int caso4(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        return sum;
    }

    //A)
    //El tiempo de ejecución de este código es O(n^4) porque hay tres bucles for anidados y cada iteración toma un
    //tiempo constante, por lo que la complejidad asintótica es de orden n a la cuarta potencia.
    //C)
    //El tiempo de ejecución aumenta de manera muy rápida con n, por lo que se respeta la cota superior.
    public static int caso5(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i * i; j++) {
                for (int k = 0; k < j; k++) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void medirTiempo(String nombreFuncion, Runnable funcion) {
        long startTime = System.nanoTime();
        funcion.run();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Tiempo de ejecución de " + nombreFuncion + ": " + duration + " nanosegundos");
    }


}
