package Practico1.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList linkedList = new LinkedList();

    //Como mi lista es de tipo Object, puedo agregar cualquier tipo de dato,
    // por lo que no es necesario hacer pruebas para cada tipo de dato
    //Solo hago pruebas para ver si se agrega correctamente y si se lanza la excepción
    @Test
    void testSize() {
        linkedList.add("hola");
        assertEquals(1, linkedList.size());
    }

    @Test
    void testSizeEmpty() {
        assertEquals(0, linkedList.size());
    }

    @Test
    void testSizeError() {
        linkedList.add("hola");
        assertNotEquals(0, linkedList.size());
    }

// ------------------------------------------Fin de pruebas Size------------------------------------------

    @Test
    void testAddSuccessfully() {
        linkedList.add("hola");
        assertEquals("hola", linkedList.get(0)); //Pruebo que el elemento que se agregó sea el correcto
    }

    @Test
    void testAddFirst() {
        linkedList.addFirst("hola");
        linkedList.addFirst("mundo");
        assertEquals("mundo", linkedList.get(0)); //Pruebo que el elemento que se agregó sea el correcto
    }

    @Test
    void testAddLast() {
        linkedList.addLast("hola");
        linkedList.addLast("mundo");
        assertEquals("mundo", linkedList.get(1)); //Pruebo que el elemento que se agregó sea el correcto
    }

// ------------------------------------------Fin de pruebas Add-------------------------------------------

    @Test
    void testGetError() { //Pruebo que se lance la excepción por querer acceder a un elemento que no existe
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
    }

    @Test
    void testGetSuccess() {
        linkedList.add("hola");
        linkedList.add("mundo");
        assertEquals("mundo", linkedList.get(1)); //Pruebo que el elemento que se obtuvo sea el correcto
    }

// ------------------------------------------Fin de pruebas Get-------------------------------------------

    @Test
    void testRemoveSuccess() {
        linkedList.add("hola");
        linkedList.add("mundo");

        linkedList.remove(1);
        assertEquals(1, linkedList.size()); //Pruebo que aún eliminando un elemento, el size no cambie
        assertEquals("hola", linkedList.get(0)); //Pruebo que el elemento que queda en la lista sea el correcto
    }

    @Test
    void testRemoveError() { //Pruebo que se lance la excepción por querer eliminar un elemento que no existe
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(0));
    }

// ------------------------------------------Fin de pruebas Remove-------------------------------------------

    @Test
    void testContains() {
        linkedList.add("hola");
        assertTrue(linkedList.contains("hola")); //Pruebo que el elemento que se agregó esté en la lista
    }

    @Test
    void testContainsFalse() {
        linkedList.add("hola");
        assertFalse(linkedList.contains("mundo")); //Pruebo que el elemento que no se agregó no esté en la lista
    }

// ------------------------------------------Fin de pruebas Contains-------------------------------------------
}