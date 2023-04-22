package Practico1.CircularLinkedList;

import Practico1.ListaConGenerics;

import java.util.NoSuchElementException;

public class CircularLinkedList<T extends Comparable<T>> implements ListaConGenerics<T> {

    private Nodo<T> first;
    private Nodo<T> last;
    private int size;

    public CircularLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Nodo<T> getFirst() {
        return first;
    }

    public Nodo<T> getLast() {
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
    public void add(T value) {
        Nodo<T> newNodo = new Nodo<>(value);
        if (isEmpty()) {
            this.first = newNodo;
            this.last = newNodo;
            newNodo.setNext(newNodo);
            newNodo.setPrev(newNodo);
        } else if (newNodo.getValue().compareTo(this.first.getValue()) < 0) {
            newNodo.setNext(this.first);
            newNodo.setPrev(this.last);
            this.first.setPrev(newNodo);
            this.last.setNext(newNodo);
            this.first = newNodo;
        } else {
            Nodo<T> current = this.first;
            while (current.getNext() != this.first && newNodo.getValue().compareTo(current.getNext().getValue()) >= 0) {
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
            Nodo<T> current = this.first;
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
    public void remove(T value) {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía");
        }
        Nodo<T> current = this.first;
        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current == this.first) {
                    this.first = this.first.getNext();
                    this.first.setPrev(this.last);
                    this.last.setNext(this.first);
                } else if (current == this.last) {
                    this.last = this.last.getPrev();
                    this.last.setNext(this.first);
                    this.first.setPrev(this.last);
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                this.size--;
                return;
            }
            current = current.getNext();
            if (current == this.first) {
                break;
            }
        }
        throw new NoSuchElementException("El valor no se encuentra en la lista");
    }

    @Override
    public T get(int position) {
        if (position < 0 || position >= this.size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        Nodo<T> current = this.first;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public boolean contains(T value) {
        Nodo<T> current = this.first;
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

    public void addLast(T value) {
        Nodo<T> newNodo = new Nodo<>(value);
        if (isEmpty()) {
            this.first = newNodo;
            this.last = newNodo;
            newNodo.setNext(newNodo);
            newNodo.setPrev(newNodo);
        } else {
            newNodo.setPrev(this.last);
            newNodo.setNext(this.first);
            this.last.setNext(newNodo);
            this.first.setPrev(newNodo);
            this.last = newNodo;
        }
        this.size++;
    }

}