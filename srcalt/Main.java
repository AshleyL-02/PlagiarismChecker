import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		Converter first = generateConverter();
		Converter second = generateConverter();
		Comparer comparer = new Comparer(first, second);
		print(comparer);
	}
	
	// post: returns a scanner based on the user inputted text/file path.
	private static Scanner generateScanner() throws FileNotFoundException {
		Scanner inScanner = new Scanner(System.in);
		String input = inScanner.nextLine();
		Scanner returned = new Scanner(input);
		File file = new File(input);
		if (file.isFile()) {
			returned = new Scanner(file);
		}
		return returned;
	}
	
	// post: returns a converter based on user input.
	private static Converter generateConverter() throws FileNotFoundException {
		System.out.print("Name of file/text for your file: ");
		Converter returned = new Converter(generateScanner());
		System.out.println();
		return returned;
	}
	
	// post: prints the result of the input plagiarism checker in a user-friendly format.
	private static void print(Comparer comparer) throws FileNotFoundException {
		if (comparer.compareNGrams() >= 1) {
			System.out.println("The documents you have inputted are plagiarized from each other");
		} else {
			System.out.println("The documents you have inputted are not plagiarized from each other");
		}
	}

}
