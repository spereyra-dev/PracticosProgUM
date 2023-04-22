package Practico2.Stack;

import Practico2.Stack.StackArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

class StackArrayTest {

    private StackArray<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new StackArray<>(3);
    }

    @Test
    void testPush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertFalse(stack.isEmpty());
    }

    @Test
    void testPushFull() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThrows(StackOverflowError.class, () -> {
            stack.push(4);
        });
    }

    @Test
    void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();

        assertEquals(2, stack.top().intValue());
    }

    @Test
    void testPopEmpty() {
        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void testTop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.top().intValue());
    }

    @Test
    void testTopEmpty() {
        assertThrows(EmptyStackException.class, () -> {
            stack.top();
        });
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(1);

        assertFalse(stack.isEmpty());
    }

    @Test
    void testMakeEmpty() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.makeEmpty();

        assertTrue(stack.isEmpty());
    }

    @Test
    void testStackOverflow() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThrows(StackOverflowError.class, () -> {
            stack.push(4);
        });
    }

}
