package Practico3.LinkedQueue;

import Practico3.EmptyQueueException;

public interface MyQueue<T> {
    void enqueue(T element);

    T dequeue() throws EmptyQueueException;

    boolean isEmpty();
}
