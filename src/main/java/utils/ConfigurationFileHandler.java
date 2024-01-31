package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import model.ConfigurationConnection;

public class ConfigurationFileHandler {
		
	public static final String NAME_PROTOCOL = "protocol";
	public static final String NAME_SUBPROTOCOL = "subprotocol";
	public static final String NAME_HOST = "host";
	public static final String NAME_PORT = "port";
	public static final String NAME_DATABASE = "name";
	public static final String NAME_USER = "user";
	public static final String NAME_PASSWORD = "password";
	
	static final String PROPERTIES_FILE = "properties.dat";
	
	//CONFIGURACION INICIAL
		////////////////////////////////////////////
		public static ConfigurationConnection loadConfiguration() {
			System.out.println("\nCargando configuración...");
			// Cargar configuraciones
			try {
				File file = new File(PROPERTIES_FILE);
				if (!file.exists()) {
					System.err.println("> No se ha encontrado el archivo " + PROPERTIES_FILE);
					ConfigurationConnection config = new ConfigurationConnection();
					createFileText(PROPERTIES_FILE, createTextBy(config));			
					return config;
				} 
				
				System.out.println("> Cargando el archivo " + PROPERTIES_FILE);
				return createConfigBy(loadFileText(PROPERTIES_FILE));
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("> Error! al cargar la configuración");				
			}
			
			System.err.println("> Se ha generado una configuración por defecto");
			return null;
		}
		
		private static String createTextBy(ConfigurationConnection config) {
			System.out.println("\nLeyendo configuración...");		
			
			String title = "--Parámetros de configuración--\n";
			String protocol = NAME_PROTOCOL + "=" + config.getProtocol() + "\n";
			String subprotocol = NAME_SUBPROTOCOL + "=" + config.getSubprotocol() + "\n";;
			String host = NAME_HOST + "=" + config.getHost() + "\n";;
			String port = NAME_PORT + "=" + config.getPort() + "\n";;
			String name = NAME_DATABASE + "=" + config.getName() + "\n";;
			
			String user = NAME_USER + "=" + config.getUser() + "\n";;
			String password = NAME_PASSWORD + "=" + config.getPassword() + "\n";;	
		
			String result = title + protocol + subprotocol + host + port + name + user + password; 
			
			return result;		
		}
		
		private static ConfigurationConnection createConfigBy(String fileText) {
			System.out.println("\nObteniendo configuración...");						
			
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
				System.out.println("> " + config.toString());
				return config;
			} catch (NumberFormatException e) {
				System.err.println("> El puerto no está correctamente formateado");
			}
			catch (Exception e) {
				System.err.println("> Error! en la integración de datos");
				
			}
			
			System.err.println("> Se creará una configuración por defecto");
			return new ConfigurationConnection();
		}
		
		public static boolean createFileText(String path, String content) {
			System.out.println("\nGenerando archivo de configuración...");
			System.out.println();
			
			try (FileWriter file = new FileWriter(path); BufferedWriter bw = new BufferedWriter(file)){			
				file.write(content);
				System.out.println("> Archivo generado con éxito en " + path);
				return true;
			} catch (Exception e) {
				System.err.println("> Error! al crear archivo en " + path);
				e.printStackTrace();
			}
			
			return false;
		}
		
		public static String loadFileText(String path) {
			System.out.println("\nCargando archivo de texto...");
			
			
			try (FileReader file = new FileReader(path); BufferedReader br = new BufferedReader(file)){			
				String reader = br.readLine();
				String res = "";
				while(reader != null) {				
					res += reader + "\n";				
					reader = br.readLine();
				}
				System.out.println("> Archivo cargado con éxito");
				
				return res;
				
			} catch (Exception e) { 
				System.err.println("Error! al cargar archivo en " + path);
				e.printStackTrace();
			}
			
			return null;
		}
		////////////////////////////////////////////
}
