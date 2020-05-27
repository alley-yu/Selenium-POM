package com.test;

public class test1 {

		
	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 2; i <= 10; i++) {
			System.out.println(i);
			sum = sum + i;
			i = i+1;
		}
		System.out.println("Sum1:" + sum);
		
		int i = 2;
		
		while (i <= 10) {
			System.out.println(i);
			sum = sum + i;
			i = i + 2;
		}
		
		System.out.println("Sum2:" + sum);
		
		
	}

}
