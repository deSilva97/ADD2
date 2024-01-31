package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.CarDAO;
import model.Car;
import model.ConfigurationConnection;
import utils.ConfigurationFileHandler;

public class CarDAOImpl implements CarDAO{
	
	
	ConfigurationConnection config;
	String table;
	
	public CarDAOImpl(ConfigurationConnection config, String table) {
		super();
		this.config = config;
		this.table = table;
		createTablaIfNotExists();
	}
	
	public void createTablaIfNotExists() {
		try (Connection conn = DriverManager.getConnection(config.getConnectionPath(), config.getUser(), config.getPassword())){
			
			String sql = "CREATE TABLE IF NOT EXISTS " + table  + "("
					+"id INT AUTO_INCREMENT PRIMARY KEY,"
					+"brand VARCHAR(255) NOT NULL,"
					+"model VARCHAR(255) NOT NULL,"
					+"year INT NOT NULL,"
					+"km INT NOT NULL"
					+ ");";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} 	
		catch (SQLException e) {		
					
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean create(Car car) {
		
		try (Connection conn = DriverManager.getConnection(config.getConnectionPath(), config.getUser(), config.getPassword())){
			System.out.println("Añadiendo a la base de datos el coche: " + car.toString() + "...");
			
			String sql = "INSERT INTO " + table + " (brand, model, year, km) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, car.getBrand());
			ps.setString(2, car.getModel());
			ps.setInt(3, car.getBuild_year());
			ps.setLong(4, car.getKm());
			ps.executeUpdate();
			
			System.out.println("> Añadido correctamente!");
			return true;
		} 	
		catch (SQLException e) {		
			System.err.println("Error! en sql");			
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Car update(int id, Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
