package Parciales.primero2021.TAD.queue;

public interface MyQueue<T> {

    void enqueue(T value);

    T dequeue() throws EmptyQueueException;

    boolean contains(T value);

    int size();

    void exchangeElements(T value, T value2);

    void removeRepeated(T value);
}
