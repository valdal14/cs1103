package com.valdal14.recursion;

public class Factorial {
	
	/**
	 * Return the factorial of a given positive integer
	 * @param n
	 * @return
	 */
	public static long calculateFactorial(int n) {		
		if(Math.abs(n) == 0)
			return 1;
		
		if(Math.abs(n) == 1) {
			return 1;
		} else {
			return Math.abs(n) * calculateFactorial(Math.abs(n)-1);
		}
	}
}
