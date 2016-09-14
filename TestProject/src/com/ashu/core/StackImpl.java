package com.ashu.core;

import java.lang.reflect.Array;

/**
 * A Stack implementation using Arrays..
 * 
 * @author ashsrivast
 *
 */
public class StackImpl<T> implements Stack<T> {

	public static void main(String args[]) {
		StackImpl<Integer> stack = new StackImpl<Integer>(10, Integer.class);
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		System.out.println("Stack length is " + stack.size());
		for (int i = 0; i < 5; i++) {
			stack.pop();
		}
		System.out.println("Stack length after pop is " + stack.size());
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		System.out.println("Stack length after second push is " + stack.size());
		for (int i = 0; i < 5; i++) {
			System.out.println(stack.top());
		}
		
	}

	T[] arrayStack;
	int actualSize;
	int size;

	public StackImpl(int size, Class<T> type) {
		this.size = size;
		arrayStack = (T[]) Array.newInstance(type, size);
	}

	@Override
	public void push(T t) {
		if (!isFull()) {
			arrayStack[actualSize++] = t;
		}
	}

	@Override
	public void pop() {
		if (!isEmpty()) {
			actualSize--;
			arrayStack[actualSize] = null;
		}
	}

	@Override
	public int size() {
		return actualSize;
	}

	@Override
	public boolean isEmpty() {
		return actualSize == 0;
	}

	@Override
	public boolean isFull() {
		return actualSize == size;
	}

	@Override
	public T top() {
		T returnVar = null;
		if (!isEmpty()) {
			returnVar = arrayStack[actualSize -1];
		}
		return returnVar;
	}
}
