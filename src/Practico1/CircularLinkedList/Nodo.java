package Practico1.CircularLinkedList;

class Nodo {
    private Object value;
    private Nodo next;
    private Nodo prev;

    public Nodo(Object value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getPrev() {
        return prev;
    }

    public void setPrev(Nodo prev) {
        this.prev = prev;
    }
}