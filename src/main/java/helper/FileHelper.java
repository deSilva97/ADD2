package helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHelper {

	public static boolean createFileText(String path, String content) {
		
		try (FileWriter file = new FileWriter(path); BufferedWriter bw = new BufferedWriter(file)){
			System.out.println("Creando archivo de texto...");
			file.write(content);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error! > crear archivo en " + path);
		}
		
		return false;
	}
	
	public static String loadFileText(String path) {
		
		try (FileReader file = new FileReader(path); BufferedReader br = new BufferedReader(file)){
			System.out.println("Cargando archivo de texto...");
			String reader = br.readLine();
			String res = "";
			while(reader != null) {				
				res += reader + "\n";
				System.out.println("Frase: " + reader);
				reader = br.readLine();
			}
			
			System.out.println("Frase en conjunto: ");
			System.out.println(res);
			return res;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
}
