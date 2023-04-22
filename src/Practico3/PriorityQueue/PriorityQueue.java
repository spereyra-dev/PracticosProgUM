package Practico3.PriorityQueue;

import Practico3.EmptyQueueException;
import Practico3.Nodo;

public class PriorityQueue<T> implements MyPriorityQueue<T> {
    private Nodo<T> first;
    private Nodo<T> last;
    private int size;

    @Override
    // Agrega un elemento al final de la queue.
    // Si la queue está vacía, el nuevo nodo se convierte en el primer y el último nodo.
    // De lo contrario, se establece el enlace "next" del último nodo existente para apuntar al nuevo nodo y el último nodo se actualiza al nuevo nodo.
    public void enqueue(T element) {
        Nodo<T> newNode = new Nodo<>(element, 0);

        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    @Override
    // Si la queue está vacía, lanza una excepción.
    // De lo contrario, el primer nodo se actualiza al siguiente nodo y el tamaño de la queue se reduce en 1.
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T value = first.getValue();
        if (size == 1) {
            first = null;
            last = null;
        } else {
            Nodo<T> current = first;
            first = current.getNext();
            if (first != null) {
                first.setPrev(null);
            }
        }
        size--;
        return value;
    }

    @Override
    // Verifica si la queue está vacía.
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    // Inserta un elemento en la queue según su prioridad.
    // Si la queue está vacía, el nuevo nodo se convierte en el primer y el último nodo.
    // Si la prioridad del nuevo nodo es mayor que la del primer nodo, el nuevo nodo se convierte en el primer nodo.
    // De lo contrario, se busca en la queue de prioridad un nodo con una prioridad menor que la del nuevo nodo y se inserta el nuevo nodo después de ese nodo.
    // Si se encuentra un nodo con una prioridad menor o igual a la del nuevo nodo, el nuevo nodo se convierte en el último nodo.
    public void enqueueWithPriority(T value, int priority) {
        Nodo<T> nuevoNodo = new Nodo<>(value, priority);
        if (size == 0) { // si la cola está vacía, se inserta al inicio
            first = last = nuevoNodo;
        } else {
            Nodo<T> actual = first;
            Nodo<T> anterior = null;
            while (actual != null && actual.getPrioridad() >= priority) { // buscamos la posición de inserción
                anterior = actual;
                actual = actual.getNext();
            }
            if (anterior == null) { // si se inserta al inicio
                nuevoNodo.setNext(first);
                first.setPrev(nuevoNodo);
                first = nuevoNodo;
            } else if (actual == null) { // si se inserta al final
                nuevoNodo.setPrev(last);
                last.setNext(nuevoNodo);
                last = nuevoNodo;
            } else { // si se inserta en medio
                nuevoNodo.setNext(actual);
                actual.setPrev(nuevoNodo);
                nuevoNodo.setPrev(anterior);
                anterior.setNext(nuevoNodo);
            }
        }
        size++;
    }

}
