package Practico1.LinkedList;

class Nodo {
    Object value;
    Nodo next;

    public Nodo(Object value) {
        this.value = value;
        this.next = null;
    }

    //Getters y setters de Value y de Next, necesarios para poder acceder a ellos desde la clase LinkedList
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
}