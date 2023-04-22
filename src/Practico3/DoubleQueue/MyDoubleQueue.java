package Practico3.DoubleQueue;

import Practico3.EmptyQueueException;

public interface MyDoubleQueue<T> {
    void enqueueLeft(T element);

    T dequeueLeft() throws EmptyQueueException;

    void enqueueRight(T element);

    T dequeueRight() throws EmptyQueueException;

    boolean isEmpty();
}
