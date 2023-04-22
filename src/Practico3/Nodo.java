package Practico3;

public class Nodo<T> {
    private T value;
    private Nodo<T> next;
    private Nodo<T> prev;
    private int prioridad;

    public Nodo(T value, int prioridad) {
        this.value = value;
        this.prioridad = prioridad;
    }

    public Nodo(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
        this.prioridad = 0;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo<T> getPrev() {
        return prev;
    }

    public void setPrev(Nodo<T> prev) {
        this.prev = prev;
    }
}
