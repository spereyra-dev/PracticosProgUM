package Practico2.Stack;

import Practico2.MyStack;

import java.util.EmptyStackException;

public class Stack<T> implements MyStack<T> {

    Nodo<T> first;
    Nodo<T> last;
    int size;

    @Override
    public T pop() throws EmptyStackException { //Delete pop elimina el elemento top de la pila
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = last.getValue();
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.getPrev();
            last.setNext(null);
        }
        size--;
        return value;
    }


    @Override
    public T top() throws EmptyStackException { //top: obtengo el elemento top de la pila
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return last.getValue();
    }

    @Override
    public void push(T element) {//Insert push nuevo elemento
        Nodo<T> newNodo = new Nodo<>(element);
        if (isEmpty()) {
            first = newNodo;
            last = newNodo;
        } else {
            last.setNext(newNodo);
            newNodo.setPrev(last);
            last = newNodo;
        }
        size++;
    }

    @Override
    public boolean isEmpty() { //isEmpty: devuelve true si la pila esta vacia
        return size == 0;
    }

    @Override
    public void makeEmpty() { //makeEmpty: vacia la pila
        first = null;
        last = null;
        size = 0;
    }
}
