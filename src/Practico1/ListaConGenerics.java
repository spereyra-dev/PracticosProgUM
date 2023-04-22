package Practico1;

public interface ListaConGenerics <T>{
    void add(T value);

    void remove(int position);

    void remove(T value);

    T get(int position);

    boolean contains(T value);

    Integer size();
}
