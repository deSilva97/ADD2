package service;

import java.io.BufferedReader;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import helper.FileHelper;
import model.ConfigurationConnection;
import utils.ConfigurationFileHandler;

//https://www.youtube.com/watch?v=nvZqXo7CM2c

public class MainService {
	
		
	static ConfigurationConnection currentConfig;
		
	public static void main(String[] args) {		
		System.out.println("INCIO DE PROGRAMA");
		System.out.println();
		
		currentConfig = ConfigurationFileHandler.loadConfiguration();
		
		if(currentConfig != null) {
			System.out.println("\nSe ha cargado la configuración correctamente\n");
			
		} 
		
		System.out.println();
		System.out.println("FIN DE PROGRAMA");
		
		//
	}
	

}
