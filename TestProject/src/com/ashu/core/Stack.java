package com.ashu.core;

public interface Stack<T> {
	void push(T t);
	void pop();
	int size();
	boolean isEmpty();
	boolean isFull();
	T top();
}
