package service;

import java.util.Scanner;

import helper.ScannerHelper;
import model.Car;
import model.ConfigurationConnection;
import utils.ConfigurationFileHandler;

//https://www.youtube.com/watch?v=nvZqXo7CM2c

public class MainService {
	
		
	static ConfigurationConnection currentConfig;
	static CarDAOImpl carImpl;
	static Scanner scanner;
	
	public static void main(String[] args) {		
		System.out.println("INCIO DE PROGRAMA");
		System.out.println();
					
		currentConfig = ConfigurationFileHandler.loadConfiguration();
		
		if(currentConfig != null) {
			System.out.println("\nSe ha cargado la configuración correctamente\n");
			
			scanner = new Scanner(System.in);
			carImpl = new CarDAOImpl(currentConfig, "coche");	
			
			mainMenu();
		} 
		
		System.out.println("Cerrando...");
		
		
		System.out.println();
		System.out.println("FIN DE PROGRAMA");		
	}
	
	private static void mainMenu() {
		
		int option = 0;
		do {
			System.out.println();
			System.out.println("MAIN MENU");
			System.out.println("----x----");
			System.out.println("1. Añadir nuevo coche");
			System.out.println("2. Borrar coche por ID");
			System.out.println("3. Consultar coche por ID");
			System.out.println("4. Modificar coche por ID");
			System.out.println("5. Listado coches");
			System.out.println("6. Terminar programa");
			System.out.print("Opción: ");
			option = ScannerHelper.getValidInt(scanner, "Introduce un número entero: ");
			System.out.println("----x----");
			
			mainMenuHandleOption(option);
			
		} while(option != 6);
	}
	
	private static void mainMenuHandleOption(int option) {
		switch (option) {
		case 1: 
			//Car car = getScannerCar(scanner);
			carImpl.create(new Car(0, "Seat", "Ibiza", 1997, 0));
			break;
		case 2: System.err.println("¡¡No definido!!");
			break;
		case 3: System.err.println("¡¡No definido!!");
			break;
		case 4: System.err.println("¡¡No definido!!");
			break;
		case 5: System.err.println("¡¡No definido!!");
			break;
		case 6: System.err.println("¡¡No definido!!");
			break;
		default: System.err.println("Opción no encontrada");
			break;
		}
	}
	
	public static Car getScannerCar(Scanner scanner) {
		System.out.println("Introduce los datos del coche"); 
		int id = 0, year;
		String brand, model;
		long km;
		
		System.out.print("> Marca: ");
		brand = ScannerHelper.getValidString(scanner, "Introduce una marca: ");
		System.out.print("> Modelo: ");
		model = ScannerHelper.getValidString(scanner, "Introduce un modelo: ");
		System.out.print("> Año de fabricación: ");
		year = ScannerHelper.getValidInt(scanner, "Introduce un número: ");
		System.out.print("> kilómetros: ");
		km = ScannerHelper.getValidLong(scanner, "Introduce un número válido: ");
		
		Car car = new Car(id, brand, model, year, km);
		System.out.println("> " + car.toString());
		return car;
	}

}
