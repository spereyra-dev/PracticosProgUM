package Parciales.primero2021.TAD.linkedlist;


import Parciales.primero2021.TAD.queue.EmptyQueueException;
import Parciales.primero2021.TAD.queue.MyQueue;
import Parciales.primero2021.TAD.stack.EmptyStackException;
import Parciales.primero2021.TAD.stack.MyStack;

public class MyLinkedListImpl<T> implements MyList<T>, MyQueue<T>, MyStack<T> {

    private Node<T> first;

    private Node<T> last;

    public MyLinkedListImpl() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(T value) {
        addToTheEnd(value);
    }

    private void addToBeginning(T value) {
        if (value != null) {

            Node<T> elementToAdd = new Node<>(value);

            if (this.first == null) { // si la lista es vacia

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else { // en caso de no ser vacia se agrega al comienzo

                elementToAdd.setNext(this.first);
                this.first = elementToAdd;
            }

        } else {
            // si el elemento es vacio se ignora
        }
    }

    private void addToTheEnd(T value) {
        if (value != null) {

            Node<T> elementToAdd = new Node<>(value);

            if (this.first == null) { // si la lista es vacia

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else { // en caso de no ser vacia se agrega al final

                this.last.setNext(elementToAdd);
                this.last = elementToAdd;
            }

        } else {
            // si el elemento es vacio se ignora
        }
    }


    @Override
    public T get(int position) {
        T valueToReturn = null;
        int tempPosition = 0;
        Node<T> temp = this.first;

        // Se busca el nodo que corresponde con la posicion
        while (temp != null && tempPosition != position) {

            temp = temp.getNext();
            tempPosition++;

        }

        // si se encontro la posicion se retorna el valor
        // en caso que se haya llegado al final y no se llego a la posicion se retorna null
        if (tempPosition == position) {


            valueToReturn = temp.getValue();

        }

        return valueToReturn;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        Node<T> temp = this.first;

        while (temp != null && !temp.getValue().equals(value)) {

            temp = temp.getNext();

        }

        if (temp != null) { // Si no se llego al final de la lista, se encontro el valor

            contains = true;

        }

        return contains;
    }

    @Override
    public void remove(T value) {
        Node<T> beforeSearchValue = null;
        Node<T> searchValue = this.first;

        // Busco el elemento a eliminar teniendo en cuenta mantener una referencia al elemento anterior
        while (searchValue != null && !searchValue.getValue().equals(value)) {

            beforeSearchValue = searchValue;
            searchValue = searchValue.getNext();

        }

        if (searchValue != null) { // si encontre el elemento a eliminar

            // Verifico si es el primer valor (caso borde) y no es el ultimo
            if (searchValue == this.first && searchValue != this.last) {

                Node<T> temp = this.first;
                this.first = this.first.getNext(); // salteo el primero

                temp.setNext(null); // quito referencia del elemento eliminado al siguiente.

                // Verifico si es el primer valor (caso borde) y no el primero
            } else if (searchValue == this.last && searchValue != this.first) {

                beforeSearchValue.setNext(null);
                this.last = beforeSearchValue;

                // Si es el primer valor y el ultimo (lista de un solo valor)
            } else if (searchValue == this.last && searchValue == this.first) {

                this.first = null;
                this.last = null;

            } else { // resto de los casos

                beforeSearchValue.setNext(searchValue.getNext());
                searchValue.setNext(null);

            }

        } else {

            // Si no es encuentra el valor a eliminar no se realiza nada

        }

    }

    private T removeLast() { // esta operación remueve el último elemento y retorna el elemento eliminado
        T valueToRemove = null;

        if (this.last != null) {
            valueToRemove = this.last.getValue();

            remove(valueToRemove);
        }

        return valueToRemove;
    }

    @Override
    public int size() {
        int size = 0;

        Node<T> temp = this.first;

        while (temp != null) {

            temp = temp.getNext();
            size++;

        }

        return size;
    }

    // Operaciones particulares a Queue

    @Override
    public void enqueue(T value) {
        addToBeginning(value);
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (this.last == null) { // si la queue esta vacia

            throw new EmptyQueueException();
        }

        return removeLast();
    }

    // Operaciones particulares a Stack

    @Override
    public void push(T value) {
        addToTheEnd(value);
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.last == null) { // si la pila esta vacia

            throw new EmptyStackException();
        }

        return removeLast();
    }

    @Override
    public T peek() {
        T valueToReturn = null;

        if (this.last != null) {
            valueToReturn = this.last.getValue();
        }

        return valueToReturn;
    }

    /**
     * Esta operación intercambia los valores de 2 nodos 1 una sola recorrida
     *
     * @param value
     * @param value2
     */
    public void exchangeElements(T value, T value2) {
        Node<T> searchValue1 = null;
        Node<T> searchValue2 = null;
        Node<T> tmpNode = this.first;

        // Busco en una sola recorrida los dos nodos buscados (pedido por la letra)
        while (tmpNode != null) {

            if (tmpNode.getValue().equals(value)) {
                searchValue1 = tmpNode;
            } else if (tmpNode.getValue().equals(value2)) {
                searchValue2 = tmpNode;
            }

            tmpNode = tmpNode.getNext();
        }


        if (searchValue1 != null && searchValue2 != null) {
            searchValue1.setValue(value2);
            searchValue2.setValue(value);
        } else {
            // La letra no indica nada en caso que no existe alguno de los dos elementos, por lo que no hacemos nada.
            // Se podría lanzar una excepcion

        }
    }

    /**
     * Esta operación elimina los repetidos dejando la última ocurrencia en 1 sola recorrida. Se hace luego una recorrida por los elementos marcados a eliminar.
     */
    public void removeRepeated(T value) {
        MyList<Node<T>> elementsToRemove = new MyLinkedListImpl<>();
        MyList<Node<T>> elementsToRemoveBefore = new MyLinkedListImpl<>();

        Node<T> beforeSearchValue = null;
        Node<T> searchValue = this.first;

        // Busco los posibles elementos a eliminar y el elemento anterior en 2 listas en una sola recorrida (pedido en la letra)
        while (searchValue != null) {

            if (searchValue.getValue().equals(value)) {
                elementsToRemoveBefore.add(beforeSearchValue);
                elementsToRemove.add(searchValue);
            }

            beforeSearchValue = searchValue;
            searchValue = searchValue.getNext();
        }

        // si el elemento esta repetido mas de una vez se procede a eliminar las ocurrencias
        // Aquí se hace una nueva recorrida por los nodos repetidos (es inevitable dado que la única forma de saber si realmente hay repetidos es recorriendo).
        if (elementsToRemove.size() > 1) {

            for(int i = 0; i < elementsToRemove.size() - 1; i++) { // Itero dejando la última ocurrencia por fuera

                searchValue = elementsToRemove.get(i);
                beforeSearchValue = elementsToRemoveBefore.get(i);

                // Verifico si es el primer valor (caso borde)
                if (searchValue == this.first) {

                    Node<T> temp = searchValue;
                    this.first = searchValue.getNext(); // salteo el primero

                } else { // resto de los casos

                    beforeSearchValue.setNext(searchValue.getNext());

                }
            }
        }
    }
}
