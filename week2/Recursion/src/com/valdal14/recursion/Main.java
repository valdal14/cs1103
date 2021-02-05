package com.valdal14.recursion;

import java.util.concurrent.Callable;

public class Main implements Callable<Integer> {

	private static final int MAXNUMBER = 45;
	
	public static void main(String[] args) throws Throwable {
		
		System.out.println("Recursive Fibonacci -------------------------");
		// Execute Standard Fibonacci
		calculateRunningTime(new Callable<Integer>() {
			public Integer call() {
				return printFibonacci();
			}
		});
		
		System.out.println("---------------------------------------------");
		
		System.out.println("Recursive Fibonacci with Momoization --------");
		// Execute Memoized Fibonacci
		calculateRunningTime(new Callable<Integer>() {
			public Integer call() {
				return printMemoizedFibonacci();
			}
		});
		
		System.out.println("---------------------------------------------");
		
		System.out.println("Fibonacci Loop ------------------------------");
		// Execute Memoized Fibonacci
		calculateRunningTime(new Callable<Integer>() {
			public Integer call() {
				return printFibonacciLoop();
			}
		});
		
		System.out.println("---------------------------------------------");
		
		System.out.println("Factorial  ----------------------------------");
		long fac = Factorial.calculateFactorial(14);
		System.out.println("The factorial of 14 is: " + fac);

	}
	
	// Fibonacci sequence (Recursion)
	private static Integer printFibonacci() {
		
		for (int i = 0; i < MAXNUMBER; i++) {
			System.out.println(Fibonacci.calculateFibonacciValue(i) +" ");
		}
		
		System.out.println("");
		return 0;
	}
	
	// Memoized Fibonacci sequence (Recursion)
	private static Integer printMemoizedFibonacci() {
		
		for (int i = 0; i < MAXNUMBER; i++) {
			System.out.println(Fibonacci.memoizedFibonacciValue(i) +" ");
		}
		
		System.out.println("");
		return 0;
	}
	
	// Fionacci (Loop version)
	private static Integer printFibonacciLoop() {
		Fibonacci.fibonacciLoop(MAXNUMBER);
		return 0;
	}
	
	
	/**
	 * Calculate the running time of a given function
	 * @param callable
	 * @throws Exception
	 */
	public static void calculateRunningTime(Callable<Integer> callable) throws Exception {
		long startTime = System.nanoTime();
		callable.call();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		double elapsedTimeInSecond = (double)totalTime;
		System.out.println("Runtime was: "  + (elapsedTimeInSecond/1_000_000_000));
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
