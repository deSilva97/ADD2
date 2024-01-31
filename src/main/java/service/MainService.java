package service;

import java.io.BufferedReader;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ConfigurationConnection;
import helper.FileHelper;

//https://www.youtube.com/watch?v=nvZqXo7CM2c

public class MainService {

	
	
	static final String PATH = "jdbc:mysql://localhost:3306/bbdd";
	static final String USER = "root";
	static final String PASSWORD = "";
	
	static final String FILE = "properties.dat";
	
	boolean firstTime = true;
		
	static ConfigurationConnection currentConfig; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Cargar configuraciones		
		try {
			File file = new File(FILE); 
			if(file.exists()) {				
				System.out.println("El archivo ya existe");
				currentConfig = substractToCreateConfigProperties(FileHelper.loadFileText(FILE));
			} else {
				System.out.println("El archivo no existe");
				FileHelper.createFileText(FILE, createTextBy(new ConfigurationConnection()));
			}
			
		} catch (NullPointerException e) {
			System.err.println("El archivo '" + FILE + "' no se ha encontrado, compruebe la ruta de guardado");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error! > Carga de configuración" );
			e.printStackTrace();
		}
		
	}
	
	private static String createTextBy(ConfigurationConnection config) {
		
		String title = "--Parámetros de configuración--\n";
		String protocol = "protocol=" + config.getProtocol() + "\n";
		String subprotocol = "subprotocol=" + config.getSubprotocol() + "\n";;
		String host = "host=" + config.getHost() + "\n";;
		String port = "port=" + config.getPort() + "\n";;
		String name = "name=" + config.getName() + "\n";;
		
		String user = "user=" + config.getUser() + "\n";;
		String password = "password=" + config.getPassword() + "\n";;	
		
		String result = title + protocol + subprotocol + host + port + name + user + password; 
		System.out.println(result);
		
		return result;		
	}
	
	private static ConfigurationConnection substractToCreateConfigProperties(String fileText) {
		System.out.println("Descomprimiendo");					
		
		String[] lines = fileText.split("\n");
		String[] res = new String[lines.length - 1];		

		for(int i = 1; i < lines.length; i++) {
			String[] split = lines[i].split("=");
			if(split.length > 1)
				res[i - 1] = lines[i].split("=")[1].trim();
			else res[i - 1] = "";			
		}

		try {
			ConfigurationConnection config = new ConfigurationConnection();
			config.setProtocol(res[0]);
			config.setSubprotocol(res[1]);
			config.setHost(res[2]);
			config.setPort(Integer.parseInt(res[3]));
			config.setName(res[4]);
			config.setUser(res[5]);
			config.setPassword(res[6]);
			System.out.println(config.toString());
			return config;
		} catch (NumberFormatException e) {
			System.err.println("El puerto no está correctamente formateado");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error! en la integración de datos");
			
		}
		
		System.err.println("Se devolverá una configuración por defecto");
		return new ConfigurationConnection();
	}
	

}
