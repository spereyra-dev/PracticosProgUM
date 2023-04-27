package Parciales.primero2021.TAD.stack;


public interface MyStack<T> {

	void push(T value);
	
	T pop() throws EmptyStackException, EmptyStackException, EmptyStackException;
	
	T peek();
	
	int size();
	
}
