package com.ashu.core;

public class PostFix {

	public static void main(String[] args) {
		char[] expression = "a+b*(c^d-e)^(f+g*h)-i".toCharArray();
		StackImpl<Character> stack = new StackImpl<Character>(expression.length, Character.class);
		final String precedenceArray = new String(")(-+*^");
		for (char c : expression) {
			// if char is not operator, output
			int readIndex = precedenceArray.indexOf(c);
			if (readIndex < 0) {
				System.out.print(c);
				continue;
			}
			while (!stack.isEmpty()) {
				if (readIndex > precedenceArray.indexOf(stack.top()) || readIndex == 1) {
					stack.push(c);
					break;
				} /*else if (readIndex == 0) {
					// do-nothing
				} */else {
					char bracketExpectedRead = stack.top();
					if (precedenceArray.indexOf(bracketExpectedRead) <= 1) {
						break;
					}
					System.out.print(stack.top());
					stack.pop();
				}
			}
			if (stack.isEmpty()) {
				stack.push(c);
				continue;
			}
			// encountered ')'
			if (readIndex == 0) {
				while (!stack.isEmpty()) {
					char bracketExpectedRead = stack.top();
					stack.pop();
					if (precedenceArray.indexOf(bracketExpectedRead) == 1) {
						break;
					}
					if (precedenceArray.indexOf(bracketExpectedRead) > 1) {
						System.out.print(bracketExpectedRead);
					}
				}
			}
		}
		System.out.print(stack.top());
		stack.pop();
	}

}