package Practico3.LinkedQueue;

import Practico3.EmptyQueueException;
import Practico3.Nodo;

public class Queue<T> implements MyQueue<T> {
    private Nodo<T> first;
    private Nodo<T> last;
    private int size;

    @Override
    //encolo de izquierda a derecha donde el de la izquierda es el primero y el de la derecha el último
    public void enqueue(T element) {
        Nodo<T> newNode = new Nodo<>(element);

        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    @Override
    //desencolo el primero desde la izquierda
    public T dequeue() throws EmptyQueueException {
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
    //devuelve si la cola esta vacia
    public boolean isEmpty() {
        return size == 0;
    }
}
