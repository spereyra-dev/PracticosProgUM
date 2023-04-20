package Practico1.CircularLinkedList;

import Practico1.Lista;

public class CircularLinkedList implements Lista {

    private Nodo first;
    private Nodo last;
    private int size;

    public CircularLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Nodo getFirst() {
        return first;
    }

    public Nodo getLast() {
        return last;
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
            newNodo.setNext(newNodo);
            newNodo.setPrev(newNodo);
        } else if (((Comparable<Object>) newNodo.getValue()).compareTo(this.first.getValue()) < 0) {
            newNodo.setNext(this.first);
            newNodo.setPrev(this.last);
            this.first.setPrev(newNodo);
            this.last.setNext(newNodo);
            this.first = newNodo;
        } else {
            Nodo current = this.first;
            while (current.getNext() != this.first && ((Comparable<Object>) newNodo.getValue()).compareTo(current.getNext().getValue()) >= 0) {
                current = current.getNext();
            }
            newNodo.setNext(current.getNext());
            newNodo.setPrev(current);
            current.getNext().setPrev(newNodo);
            current.setNext(newNodo);
            if (newNodo.getNext() == this.first) {
                this.last = newNodo;
            }
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
            this.first.setPrev(this.last);
            this.last.setNext(this.first);
        } else {
            Nodo current = this.first;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            current.getNext().setPrev(current);
            if (position == this.size - 1) {
                this.last = current;
            }
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
            if (current == this.first) {
                break;
            }
        }
        return false;
    }

}