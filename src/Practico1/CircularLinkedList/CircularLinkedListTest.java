package Practico1.CircularLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList();

    @Test
    public void testAdd() { //Prueba de agregar elementos a la lista
        circularLinkedList.add(3);
        circularLinkedList.add(1);
        circularLinkedList.add(4);

        assertTrue(circularLinkedList.contains(1));
        assertTrue(circularLinkedList.contains(3));
        assertTrue(circularLinkedList.contains(4));

        assertFalse(circularLinkedList.contains(0));
        assertFalse(circularLinkedList.contains(2));

        assertEquals(3, circularLinkedList.size());
        assertEquals(1, circularLinkedList.getFirst().getValue());
        assertEquals(4, circularLinkedList.getLast().getValue());
    }

    @Test
    public void testEmptyList() { //Prueba de lista vacia
        assertTrue(circularLinkedList.isEmpty());
        assertEquals(0, circularLinkedList.size());
        assertNull(circularLinkedList.getFirst());
        assertNull(circularLinkedList.getLast());
    }

    @Test
    public void testSingleElementList() { //Prueba de lista con un solo elemento
        circularLinkedList.add(1);

        assertFalse(circularLinkedList.isEmpty());
        assertEquals(1, circularLinkedList.size());
        assertEquals(1, circularLinkedList.getFirst().getValue());
        assertEquals(1, circularLinkedList.getLast().getValue());
    }

    @Test
    public void testAddDuplicateElements() { //Prueba de agregar elementos duplicados
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(1);

        assertTrue(circularLinkedList.contains(1));
        assertTrue(circularLinkedList.contains(2));

        assertEquals(3, circularLinkedList.size());
        assertEquals(1, circularLinkedList.getFirst().getValue());
        assertEquals(2, circularLinkedList.getLast().getValue());
    }

    @Test
    public void testRemove() { //Prueba de eliminar elementos de la lista
        circularLinkedList.add(3);
        circularLinkedList.add(1);
        circularLinkedList.add(4);

        assertTrue(circularLinkedList.contains(1));
        assertTrue(circularLinkedList.contains(3));
        assertTrue(circularLinkedList.contains(4));

        assertFalse(circularLinkedList.contains(0));
        assertFalse(circularLinkedList.contains(2));

        assertEquals(3, circularLinkedList.size());

        circularLinkedList.remove(1);

        assertTrue(circularLinkedList.contains(1));
        assertFalse(circularLinkedList.contains(3));
        assertTrue(circularLinkedList.contains(4));

        assertEquals(2, circularLinkedList.size());
        assertEquals(1, circularLinkedList.getFirst().getValue());
        assertEquals(4, circularLinkedList.getLast().getValue());
    }
}