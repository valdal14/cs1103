import java.util.Arrays;
import java.util.concurrent.Callable;

public class Main implements Callable<String> {

	private static final int SIZE = 100000;
	private static int[] arrOne = new int[SIZE];
	private static int[] arrTwo = new int[SIZE];
	
	public static void main(String[] args) throws Exception {
		
		arrOne = fillArray(SIZE);
		arrTwo = fillArray(SIZE);

		// call to My version of the insertion sort
		calculateRunningTime(new Callable<String>() {
			   public String call() {
				   System.out.println("Insertion sort ------------");
			       return insertionSort(arrOne);
			   }
		});
		
		// call to Java Array.sort():
		calculateRunningTime(new Callable<String>() {
			   public String call() {
				   System.out.println("Array,sort() Java ---------");
			       return javaArraySorting(arrTwo);
			   }
		});
		
	}
	
	/**
	 * Helper method used to fill an array of constant size
	 * with random integers
	 * 
	 * @param size - integer
	 * @return - integer[]
	 */
	private static int[] fillArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < SIZE; i++) {
			array[i] = (int)(Integer.MAX_VALUE * Math.random());
		}
		return array;
	}
	
	
	/**
	 * Executes my insertion sort algo
	 * @param array
	 * @return
	 */
	private static String insertionSort(int[] array) { 		
        for (int i = 1; i < array.length; ++i) { 
            int key = array[i]; 
            int j = i - 1; 
  
            while (j >= 0 && array[j] > key) { 
            	array[j + 1] = array[j]; 
                j = j - 1; 
            } 
            array[j + 1] = key; 
        }
		
		return "Done";
	}
	
	/**
	 * java Array.sort()
	 * @param array
	 * @return
	 */
	private static String javaArraySorting(int[] array) {
		int[] newArr = array;
		Arrays.sort(newArr);
		return "Done";
	}
	

	/**
	 * Prints out the running time based on the chosen sorting method
	 * @param myFunc - function
	 * @throws Exception
	 */
	public static void calculateRunningTime(Callable<String> myFunc) throws Exception {
	       // do something
		long startTime = System.nanoTime();
		myFunc.call();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		double elapsedTimeInSecond = (double)totalTime;
		System.out.println("Time to sort the array was: "  + (elapsedTimeInSecond/1_000_000_000));
	}
	
	public String myMethod(Callable<String> func) throws Exception {
	    return func.call();
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
