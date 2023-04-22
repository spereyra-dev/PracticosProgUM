package Practico3;

public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("La cola está vacía");
    }
}
