package Practico3.DoubleQueue;

import Practico3.EmptyQueueException;
import Practico3.Nodo;

public class DoubleQueue<T> implements MyDoubleQueue<T> {
    private Nodo<T> first;
    private Nodo<T> last;
    private int size;

    @Override
    //encolo de izquierda a derecha donde el de la derecha es el primero y el de la izquierda el último
    public void enqueueLeft(T element) {
        Nodo<T> newNode = new Nodo<>(element);
        if (isEmpty()) {
            last = newNode;
        }
        if (!isEmpty()) {
            first.setPrev(newNode);
            newNode.setNext(first);
        }
        first = newNode;
        size++;
    }

    @Override
    //encolo de derecha a izquierda donde el de la izquierda es el primero y el de la derecha el último
    public void enqueueRight(T element) {
        Nodo<T> newNode = new Nodo<>(element);

        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrev(last);
        }
        last = newNode;
        size++;
    }


    @Override
    public T dequeueLeft() throws EmptyQueueException { //desencolo el primero desde la izquierda
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T value = first.getValue();
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrev(null);
        }
        size--;
        return value;
    }

    @Override
    public T dequeueRight() throws EmptyQueueException { //desencolo el primero desde la derecha
        if (isEmpty()) {
            throw new EmptyQueueException();
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
    public boolean isEmpty() { //devuelvo si esta vacia
        return size == 0;
    }
}
