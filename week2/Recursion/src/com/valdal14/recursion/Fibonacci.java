package com.valdal14.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static Map<Integer, Integer> memo = new HashMap<>();
	
	/**
	 * Calculate the Fibonacci sequence given a positive integer
	 * @param n int
	 * @return int
	 */
	public static int calculateFibonacciValue(int n) {		
		if(n == 0) {
			return 0;
		} else if(n >=1 && n <= 2) {
			return 1;
		} else {
			return calculateFibonacciValue(n-1) + calculateFibonacciValue(n-2);
		}
	}
	
	/**
	 * Calculate the Fibonacci (Memoized version) sequence given a positive integer
	 * @param n
	 * @return
	 */	    		
	public static int memoizedFibonacciValue(int n) {
		
		if(n == 0 || n == 1) {
			return n;
		}else if(memo.containsKey(n)) {
			System.out.printf("grabbing memo[%d]\n", memo.get(n));
            return memo.get(n);
		} else {
			int v = memoizedFibonacciValue(n-1) + memoizedFibonacciValue(n-2);
			memo.put(n, v);
			return v;
		}
	}
	
	public static void fibonacciLoop(int n) {
		int count = 0;
		int n1 = 0;
		int n2 = 1;
		int num = 0;
		
		if(n == 0 || n == 1) {
			System.out.println(n);
		} else {
			while(count < (n - 1)) {
				System.out.println(num);
				num = n1 + n2;
				n1 = n2;
				n2 = num;
				count += 1;
			}
		}
	}
}
