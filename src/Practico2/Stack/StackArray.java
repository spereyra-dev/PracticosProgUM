package Practico2.Stack;

import Practico2.MyStack;

import java.util.EmptyStackException;

public class StackArray<T> implements MyStack<T> {

    private T[] stackArray;
    private int topIndex;

    public StackArray(int size) {
        stackArray = (T[]) new Object[size];
        topIndex = -1;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = stackArray[topIndex];
        stackArray[topIndex] = null;
        topIndex--;
        return value;
    }

    @Override
    public T top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[topIndex];
    }

    @Override
    public void push(T element) {
        if (topIndex == stackArray.length - 1) {
            throw new StackOverflowError();
        }
        topIndex++;
        stackArray[topIndex] = element;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public void makeEmpty() {
        while (!isEmpty()) {
            pop();
        }
    }
}
