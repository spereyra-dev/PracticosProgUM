package Practico0;

public class Matrices {
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matriz2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] matriz3 = {{1, 2}, {3, 4}, {5, 6}};

        // cantidadFilas
        int filasMatriz1 = new Matrices().filas(matriz1);
        System.out.println("La matriz 1 tiene " + filasMatriz1 + " filas");

        // cantidadColumnas
        int columnasMatriz2 = new Matrices().columnas(matriz2);
        System.out.println("La matriz 2 tiene " + columnasMatriz2 + " columnas");

        // mismaCantidadFilasColumnas
        boolean mismaCantidadFilasColumnasMatriz1 = new Matrices().esCuadrada(matriz1);
        System.out.println("La matriz 1 tiene la misma cantidad de filas y columnas: " + mismaCantidadFilasColumnasMatriz1);

        boolean mismaCantidadFilasColumnasMatriz3 = new Matrices().esCuadrada(matriz3);
        System.out.println("La matriz 3 tiene la misma cantidad de filas y columnas: " + mismaCantidadFilasColumnasMatriz3);

        // imprimirMatriz
        System.out.println("Matriz 1:");
        new Matrices().desplegar(matriz1);

        System.out.println("Matriz 2:");
        new Matrices().desplegar(matriz2);

        // sumarMatrices
        int[][] resultado = new Matrices().sumar(matriz1, matriz2);
        if (resultado != null) {
            System.out.println("Matriz resultante:");
            new Matrices().desplegar(resultado);
        } else {
            System.out.println("Las matrices no tienen el mismo tamaño");
        }
    }

    public void desplegar(int[][] matriz) {
        for (int[] ints : matriz) {
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }
    }

    public boolean esCuadrada(int[][] matriz) {
        int filas = filas(matriz);
        int columnas = columnas(matriz);

        if (filas != columnas) {
            return false;
        }

        for (int i = 1; i < filas; i++) {
            if (matriz[i].length != columnas) {
                return false;
            }
        }

        return true;
    }

    public int filas(int[][] matriz) {
        return matriz.length;
    }

    public int columnas(int[][] matriz) {
        int cantFilas = filas(matriz);
        return cantFilas > 0 ? matriz[0].length : 0;
    }

    public int[][] sumar(int[][] matrizA, int[][] matrizB) {
        if (matrizA.length != matrizB.length || matrizA[0].length != matrizB[0].length) {
            return null;
        }

        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        return resultado;
    }
}
