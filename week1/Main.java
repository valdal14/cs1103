import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	private static final int SIZE = 3;
	private static Scanner sc;
	
	public static void main(String[] args) {
		try {
			executeProgram();
		} catch (Exception e) {
			System.out.println("Runtime exception generated: " + e.getMessage());
		}
	}
	
	/**
	 * Executes the calculateRoot() function and asks
	 * the user whether or not it wants to calculate a 
	 * new root
	 * @throws IllegalArgumentException
	 */
	private static void executeProgram() throws IllegalArgumentException {
		while(true) {
			calculateRoot();
			sc = new Scanner(System.in);
			System.out.print("Do you want to enter another equation? :");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("no")) {
				System.out.println("Good bye!!!");
				break;
			}
		}
	}
	
	/**
	 * Calculates the root based on the user inputs and 
	 * prints out the root value if no exceptions are thrown
	 * @throws IllegalArgumentException
	 */
	private static void calculateRoot() throws IllegalArgumentException {
		double[] userInputs = getInputs();
		double value = Main.root(userInputs[0], userInputs[1], userInputs[2]);
		System.out.println("The root value is: " + value);
	}
	
	/**
	 * Allows the user to enter three double values
	 * and return an array of double with data-type checking
	 * @return double[]
	 */
	private static double[] getInputs() {
		double[] inputs = new double[SIZE];
		int counter = 0;
		
		do {
			try {
				System.out.print("Enter the " + (counter + 1) + " value: ");
				sc = new Scanner(System.in);
				double value = sc.nextDouble();
				inputs[counter] = value;
				counter  += 1;
			} catch (InputMismatchException e) {
				System.out.println("Invalid datatype " + e + " please try again!");
			}
		} while (counter != SIZE);
		
		//sc.close();
		return inputs;
	}
	
	/**
	 * Returns the larger of the two roots of the quadratic equation
	 * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
	 * if the discriminant, B*B - 4*A*C, is negative, then an exception
	 * of type IllegalArgumentException is thrown.
	 */
	private static double root( double A, double B, double C ) throws IllegalArgumentException {
	    if (A == 0) {
	      throw new IllegalArgumentException("A can't be zero.");
	    }
	    else {
	       double disc = B*B - 4*A*C;
	       if (disc < 0)
	          throw new IllegalArgumentException("Discriminant < zero.");
	       return  (-B + Math.sqrt(disc)) / (2*A);
	    }
	}

}
