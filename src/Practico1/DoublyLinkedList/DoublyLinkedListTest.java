package Practico1.DoublyLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    DoublyLinkedList linkedList = new DoublyLinkedList();

    @Test
    void testSize() { //Prueba de agregar elementos a la lista y verificar el tamaño coincida
        linkedList.add("hola");
        assertEquals(1, linkedList.size());
    }

    @Test
    void testSizeEmpty() { //Prueba de lista vacia igual a 0
        assertEquals(0, linkedList.size());
    }

    @Test
    void testIsEmpty() { //Prueba de lista vacia
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void testIsNotEmpty() { //Prueba de lista con elementos isEmpty = false
        linkedList.add("hola");
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void testAddSuccess() { //Prueba de agregar elementos a la lista y verificar que se encuentren
        linkedList.add("hola");
        assertEquals("hola", linkedList.get(0));
    }

    @Test
    void testRemoveSuccess() { //Prueba de eliminar elementos de la lista y verificar que se encuentren
        linkedList.add("hola");
        linkedList.add("mundo");
        linkedList.remove(0);
        assertEquals("mundo", linkedList.get(0));
    }

    @Test
    void testRemoveError() { //Prueba de eliminar elementos de la lista y esperar un error al intentar eliminar un elemento que no existe
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(2));
    }

    @Test
    void testGet() { //Prueba de obtener elementos de la lista y verificar que se encuentren en la posicion correcta
        linkedList.add("hola");
        linkedList.add("mundo");
        assertEquals("mundo", linkedList.get(1));
    }

    @Test
    void testGetError() { //Prueba de obtener elementos de la lista y esperar un error al intentar obtener un elemento que no existe
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
    }

    @Test
    void testContains() { //Prueba de verificar si la lista contiene un elemento
        linkedList.add("hola");
        linkedList.add("mundo");
        assertTrue(linkedList.contains("mundo"));
    }

    @Test
    void testContainsError() { //Prueba de verificar si la lista contiene un elemento y devolver false si no lo encuentra
        linkedList.add("hola");
        linkedList.add("mundo");
        assertFalse(linkedList.contains("chau"));
    }

    @Test
    public void testAdd() { //Prueba de agregar elementos a la lista y verificar correctamente el tamaño, el primer elemento y el último.
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(4);

        assertTrue(linkedList.contains(1));
        assertTrue(linkedList.contains(3));
        assertTrue(linkedList.contains(4));

        assertFalse(linkedList.contains(0));
        assertFalse(linkedList.contains(2));

        assertEquals(3, linkedList.size());
        assertEquals(1, linkedList.getFirst().getValue());
        assertEquals(4, linkedList.getLast().getValue());
    }

    @Test
    public void testEmptyList() { //Prueba de lista vacia con isEmpty = true, size = 0, first = null, last = null
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertNull(linkedList.getFirst());
        assertNull(linkedList.getLast());
    }

    @Test
    public void testSingleElementList() { //Prueba de lista con un solo elemento con isEmpty = false, size = 1, first = last
        linkedList.add(1);

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(1, linkedList.getFirst().getValue());
        assertEquals(1, linkedList.getLast().getValue());
    }

    @Test
    public void testAddDuplicateElements() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1);

        assertTrue(linkedList.contains(1));
        assertTrue(linkedList.contains(2));

        assertEquals(3, linkedList.size());
        assertEquals(1, linkedList.getFirst().getValue());
        assertEquals(2, linkedList.getLast().getValue());
    }

    @Test
    public void testRemove() {
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(4);

        assertTrue(linkedList.contains(1));
        assertTrue(linkedList.contains(3));
        assertTrue(linkedList.contains(4));

        assertFalse(linkedList.contains(0));
        assertFalse(linkedList.contains(2));

        assertEquals(3, linkedList.size());

        linkedList.remove(1);

        assertTrue(linkedList.contains(1));
        assertFalse(linkedList.contains(3));
        assertTrue(linkedList.contains(4));

        assertEquals(2, linkedList.size());
        assertEquals(1, linkedList.getFirst().getValue());
        assertEquals(4, linkedList.getLast().getValue());
    }
}