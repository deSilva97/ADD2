package helper;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Car;

public class ScannerHelper {

	public static int getValidInt(Scanner scanner, String wrong_message) {
		try {						
			int value = scanner.nextInt();
			scanner.nextLine();
			return value;
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.print(wrong_message);	
			scanner.nextLine();
			return getValidInt(scanner, wrong_message);
		}
	}
	
	public static long getValidLong(Scanner scanner, String wrong_message) {
		try {						
			long opcion = scanner.nextLong();
			scanner.nextLine();
			return opcion;
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.print(wrong_message);	
			scanner.nextLine();
			return getValidLong(scanner, wrong_message);
		}
	}
	
	public static String getValidString(Scanner scanner, String wrong_message) {
		String s = scanner.nextLine();
		if(s.isBlank()) {
			System.err.print(wrong_message);
			return getValidString(scanner, wrong_message);
		}
		
		return s;
	}
	
	

}
