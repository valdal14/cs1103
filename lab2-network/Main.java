import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

	private static InputStream in = null;
	private static OutputStream out = null;
	private static Scanner sc = null;
	private static String[] userInputs = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * For doing I/O, Java has a pair of nice abstractions: 
		 * InputStream and OutputStream. 
		 * 
		 * These are abstract classes in the package java.io. 
		 * 
		 * An InputStream is a place from which you can read data. 
		 * An OutputStream is a place to which you can write data.
		 */
		userInputs = getUserInputs();
		openUrl(userInputs);
	}
	
	/**
	 * 
	 * @param userInput
	 * @throws MalformedURLException 
	 */
	private static void openUrl(String[] userInput) {
		URL url = null;
		
		try {
			url = new URL(userInput[0]);
			in = url.openStream();
			out = new FileOutputStream(userInput[1]);
			copyStream(in, out);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Asks the user for url and filename
	 * @return
	 * @throws MalformedURLException 
	 */
	private static String[] getUserInputs() {
		String[] inputs = new String[2];
		sc = new Scanner(System.in);
		System.out.print("Enter a url: ");
		inputs[0] = sc.next();
		System.out.print("Enter a filename: ");
		inputs[1] = sc.next();
		return inputs;
	}
	
	/**
	 * Helper method used to copy 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	private static void copyStream(InputStream in, OutputStream out) throws IOException {
		int oneByte = in.read();
		while (oneByte >= 0) { // negative value indicates end-of-stream
			out.write(oneByte);
			oneByte = in.read();
		}
		System.out.println("The file " + userInputs[1] + " was successfully written");
	}

}

