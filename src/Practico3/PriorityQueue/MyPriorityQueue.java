package Practico3.PriorityQueue;

import Practico3.LinkedQueue.MyQueue;

public interface MyPriorityQueue<T> extends MyQueue<T> {
    /* inserta de acuerdo a la prioridad; si hay más de un elemento con la misma prioridad, inserta al final */
    void enqueueWithPriority(T element, int prioridad);
}
