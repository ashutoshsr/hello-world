package com.ashu.core;

public class InsertionSort {

	public static void main(String[] args) {
		Integer[] numbers = new Integer[] {10,8,6,4,3,1};
			System.out.println("length " + numbers.length);
//		for (Integer integer : numbers) {
//		}
		// need to int i and j
		int cost = 0;
		for (int j= 1 ; j < numbers.length ; j++) {
			cost++;
			int max = numbers[j];
			
			for (int i = j - 1; i >= 0; i --) {
				cost ++;
				  if ( numbers[i] > max) {
					int temp = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = temp;
					max = temp;
				  } else {
					  break;
				  }
			}
		}
		for (Integer integer : numbers) {
			System.out.println(integer);
		}
		
		System.out.println("cost" + cost);

	}

}
