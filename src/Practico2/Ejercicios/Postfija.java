package Practico2.Ejercicios;

import Practico2.Stack.Stack;

public class Postfija {
    public static void main(String[] args) {
        evaluarPostfija("2 23 6 + * 1 -");
    }

    private static void evaluarPostfija(String expr) {
        String[] post = expr.split(" ");
        Stack<String> E = new Stack<>(); //Pila entrada
        Stack<String> P = new Stack<>(); //Pila de operandos
        //Añadir post (array) a la Pila de entrada (E)
        for (int i = post.length - 1; i >= 0; i--) {
            E.push(post[i]);
        }

        //Algoritmo de Evaluación Postfija
        String operadores = "+-*/%";
        while (!E.isEmpty()) {
            if (operadores.contains(E.top())) {
                P.push(String.valueOf(evaluar(E.pop(), P.pop(), P.pop())));
            } else {
                P.push(E.pop());
            }
        }

        //Mostrar resultados:
        System.out.println("Expresion: " + expr);
        System.out.println("Resultado: " + P.top());
    }

    private static int evaluar(String op, String n2, String n1) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        if (op.equals("+")) return (num1 + num2);
        if (op.equals("-")) return (num1 - num2);
        if (op.equals("*")) return (num1 * num2);
        if (op.equals("/")) return (num1 / num2);
        if (op.equals("%")) return (num1 % num2);
        return 0;
    }

}
