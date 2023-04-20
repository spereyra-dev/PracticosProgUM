package Practico1.DoublyLinkedList;

import Practico1.Lista;

public class DoublyLinkedList implements Lista {

    private Nodo first;
    private Nodo last;
    private int size;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Nodo getFirst() {
        return first;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public Nodo getLast() {
        return last;
    }

    public void setLast(Nodo last) {
        this.last = last;
    }

    @Override
    public Integer size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(Object value) {
        Nodo newNodo = new Nodo(value);
        if (isEmpty()) {
            this.first = newNodo;
            this.last = newNodo;
        } else if (((Comparable<Object>) newNodo.getValue()).compareTo(this.first.getValue()) < 0) {
            newNodo.setNext(this.first);
            this.first.setPrev(newNodo);
            this.first = newNodo;
        } else {
            Nodo current = this.first;
            while (current.getNext() != null && ((Comparable<Object>) newNodo.getValue()).compareTo(current.getNext().getValue()) >= 0) {
                current = current.getNext();
            }
            if (current.getNext() == null) {
                this.last = newNodo;
            } else {
                newNodo.setNext(current.getNext());
                current.getNext().setPrev(newNodo);
            }
            newNodo.setPrev(current);
            current.setNext(newNodo);
        }
        this.size++;
    }

    @Override
    public void remove(int position) {
        if (position < 0 || position >= this.size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (position == 0) {
            this.first = this.first.getNext();
            if (this.first == null) {
                this.last = null;
            } else {
                this.first.setPrev(null);
            }
        } else if (position == this.size - 1) {
            this.last = this.last.getPrev();
            this.last.setNext(null);
        } else {
            Nodo current = this.first;
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        this.size--;
    }

    @Override
    public Object get(int position) {
        if (position < 0 || position >= this.size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        Nodo current = this.first;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public boolean contains(Object value) {
        Nodo current = this.first;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

}