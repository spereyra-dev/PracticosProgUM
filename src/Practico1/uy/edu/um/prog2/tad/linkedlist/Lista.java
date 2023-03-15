package Practico1.uy.edu.um.prog2.tad.linkedlist;

public interface Lista {
    void add(Object value);

    void remove(int position);

    Object get(int position);

    boolean contains(Object value);

    void addFirst(Object value);

    void addLast(Object value);
}
