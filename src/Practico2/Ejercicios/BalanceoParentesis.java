package Practico2.Ejercicios;

import Practico2.Stack.Stack;

public class BalanceoParentesis {
    public static void main(String[] args) {
        balance("(((4+3)*4+(((5)*9+(2-3))+7)))");
    }

    public static void balance(String expr) {
        Stack<Character> E = new Stack<>(); //Pila entrada
        for (int i = 0; i < expr.length(); i++) {
            char parentesis = expr.charAt(i);

            if (parentesis == '(' || parentesis == '[' || parentesis == '{') {
                E.push(parentesis);
            } else if (parentesis == ')' || parentesis == ']' || parentesis == '}') {
                if (parentesis == ')' && E.top() == '(') {
                    E.pop();
                }
                if (parentesis == '}' && E.top() == '{') {
                    E.pop();
                }
                if (parentesis == ']' && E.top() == '[') {
                    E.pop();
                }
            }
        }

        if (E.isEmpty()) {
            System.out.println("Los parentesis estan balanceados");
        } else {
            System.out.println("Los parentesis no estan balanceados");
        }
    }
}
