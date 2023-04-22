package Practico3.PriorityQueue;

import Practico3.EmptyQueueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    private PriorityQueue<String> priorityQueue;

    @BeforeEach
    public void setUp() {
        priorityQueue = new PriorityQueue<>();
    }

    @Test
    public void testEnqueueAndDequeue() throws EmptyQueueException {
        priorityQueue.enqueueWithPriority("task 1", 3);
        priorityQueue.enqueueWithPriority("task 2", 1);
        priorityQueue.enqueueWithPriority("task 3", 2);
        priorityQueue.enqueueWithPriority("task 4", 90);
        priorityQueue.enqueueWithPriority("task 5", 0);

        assertEquals("task 4", priorityQueue.dequeue());
        assertEquals("task 1", priorityQueue.dequeue());
        assertEquals("task 3", priorityQueue.dequeue());
        assertEquals("task 2", priorityQueue.dequeue());
        assertEquals("task 5", priorityQueue.dequeue());
    }

    @Test
    public void testIsEmpty() throws EmptyQueueException {
        assertTrue(priorityQueue.isEmpty());

        priorityQueue.enqueueWithPriority("task 1", 1);

        assertFalse(priorityQueue.isEmpty());

        priorityQueue.dequeue();

        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void testDequeueEmptyQueue() {
        assertThrows(EmptyQueueException.class, () -> {
            priorityQueue.dequeue();
        });
    }
}