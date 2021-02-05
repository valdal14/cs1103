import java.util.HashMap;
import java.util.Map;
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

class Fibonacci {

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

