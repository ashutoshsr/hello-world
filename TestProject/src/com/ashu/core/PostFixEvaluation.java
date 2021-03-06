package com.ashu.core;

public class PostFixEvaluation {

	public static void main(String[] args) {
		char[] expression = "231*+9-".toCharArray();
		StackImpl<Integer> stack = new StackImpl<Integer>(expression.length, Integer.class);
		final String precedenceArray = new String("-+*^");
		for (char c : expression) {
			// if char is not operator, output
			int readIndex = precedenceArray.indexOf(c);
			if (readIndex < 0) {
				stack.push(Integer.valueOf(String.valueOf(c)));
			} else {
				int c2 = stack.top();
				stack.pop();
				int c1 = stack.top();
				stack.pop();
				stack.push(calculate(c1, c2, c));
			}
		}

		System.out.print(stack.top());
		stack.pop();
	}
	
	private static int calculate(int c1, int c2, char operand) {
		int num1 = Integer.valueOf(c1) ;
		int num2 = Integer.valueOf(c2) ;
		switch (String.valueOf(operand)) {
		case "+":
			return (num1 + num2);
		case "-":
			return (num1 - num2);
		case "*":
			return (num1 * num2);
		case "^":
			return (num1 ^ num2);
		}
		
		return 'c';
	}

}
