package helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHelper {

	public static boolean createFileText(String path, String content) {
		System.out.println("Creando archivo de texto...");
		System.out.println();
		
		try (FileWriter file = new FileWriter(path); BufferedWriter bw = new BufferedWriter(file)){			
			file.write(content);
			System.out.println("> Archivo creado con éxito");
			return true;
		} catch (Exception e) {
			System.err.println("Error! al crear archivo en " + path);
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static String loadFileText(String path) {
		System.out.println("Cargando archivo de texto...");
		
		
		try (FileReader file = new FileReader(path); BufferedReader br = new BufferedReader(file)){			
			String reader = br.readLine();
			String res = "";
			while(reader != null) {				
				res += reader + "\n";				
				reader = br.readLine();
			}
			System.out.println("> Archivo construido a texto con éxito");
			
			return res;
			
		} catch (Exception e) { 
			System.err.println("Error! al cargar archivo en " + path);
			e.printStackTrace();
		}
		
		return null;
	}
	
}
