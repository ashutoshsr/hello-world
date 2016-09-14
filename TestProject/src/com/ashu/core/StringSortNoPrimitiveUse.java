package com.ashu.core;

public class StringSortNoPrimitiveUse {

	public static void main(String[] args) {
		Integer[] expression = new Integer[] { 9, 2, 7, 5, 10, 11, 6, 3, 8 };
		StackImpl<Integer> stack = new StackImpl<Integer>(expression.length, Integer.class);
		for (int c : expression) {
			stack.push(c);
		}
		pushBelowTop(stack, stack.top());
		while (!stack.isEmpty()) {
			System.out.println(stack.top());
			stack.pop();
		}
	}

	private static Stack<Integer> pushBelowTop(Stack<Integer> stack, int anExpression) {
		if (!stack.isEmpty()) {
			int temp = stack.top();
			if (anExpression <= temp) {
				stack.push(anExpression);
			} else {
				pushBelowTop(stack, temp);
			}
			stack.pop();
			stack.push(temp);
		} else if (stack.isEmpty() || anExpression < stack.top()) {
			stack.push(anExpression);
		} else {
			pushBelowTop(stack, anExpression);
		}
		return stack;
	}
}
