package com.ashu.core;

public class StockPrice {

	/**
	 * A Stack implementation using Arrays..
	 * 
	 * @author ashsrivast
	 *
	 */

	public static void main(String args[]) {
		Integer[] stockPrice = new Integer[] { 8, 10, 7, 5, 9, 4, 6 };
		Integer[] arraySpan = new Integer[stockPrice.length];

		for (int i = 0; i < stockPrice.length; i++) {
			int j = 0;
			int span = 0;
			// System.out.println(stockPrice[i - j] + " - " + stockPrice[i]);
			while (stockPrice[i - j] <= stockPrice[i] && j < i) {
				span++;
				j++;
			}
			arraySpan[i] = span;
		}
		for (int i = 0; i < arraySpan.length; i++) {
			System.out.println(arraySpan[i]);
		}
		System.out.println(" * * * * * * * * * * * ");
		arraySpan = new Integer[stockPrice.length];
		StackImpl<Integer> stack = new StackImpl<Integer>(stockPrice.length, Integer.class);
		for (int i = 0; i < stockPrice.length; i++) {
			int h = 0;
			while (!stack.isEmpty()) {
				if (stockPrice[i] >= stockPrice[stack.top()]) {
					stack.pop();
				} else if (stockPrice[i] < stockPrice[stack.top()]) {
					if (stack.isEmpty()) {
						h = -1;
					} else {
						h = stack.top();
					}
					break;
				}
			}
			arraySpan[i] = i - h;
			stack.push(i);
		}
		for (int i = 0; i < arraySpan.length; i++) {
			System.out.println(arraySpan[i]);
		}
	}

}
