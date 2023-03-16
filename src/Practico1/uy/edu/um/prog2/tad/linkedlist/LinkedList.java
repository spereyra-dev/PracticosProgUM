package Practico1.uy.edu.um.prog2.tad.linkedlist;

public class LinkedList implements Lista {
    private Nodo head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(Object value) {
        Nodo newNode = new Nodo(value);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Nodo current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    @Override
    public void remove(int position) {
        if (position < 0 || position >= this.size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (position == 0) {
            this.head = this.head.next;
        } else {
            Nodo previous = this.head;
            Nodo current = this.head.next;
            for (int i = 1; i < position; i++) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }
        this.size--;
    }

    @Override
    public Object get(int position) {
        if (position < 0 || position >= this.size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        Nodo current = this.head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public boolean contains(Object value) {
        Nodo current = this.head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void addFirst(Object value) {
        Nodo newNode = new Nodo(value);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    @Override
    public void addLast(Object value) {
        Nodo newNode = new Nodo(value);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Nodo current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

}