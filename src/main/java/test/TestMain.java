package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//https://www.youtube.com/watch?v=nvZqXo7CM2c

public class TestMain {

	static final String PATH = "jdbc:mysql://localhost:3306/bbdd";
	static final String USER = "root";
	static final String PASSWORD = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/* --DEPRECADO--
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se ha encontrado el driver para MySql: " + e.getMessage());
			return;
		}
		*/
		
		//Insert("Diego", 26, 87);
		//Insert("Monica", 26, 50);
		
		//search(1);
		//update(1, "Diego de Silva", 26, 50);
		//delete(1);
		
		///////////////////////////////////////////////////
		
		
		
		
	}
	
	private static void Insert(String nombre, int edad, double peso) {
		try (Connection conn = DriverManager.getConnection(PATH, USER, PASSWORD)){
			System.out.println("Se ha establecido la conexión con al base de datos");

			System.out.println("Ejecutando sentencia...");
			String query = "INSERT INTO PERSONAS (NOMBRE, EDAD, PESO) VALUES (?, ?, ?)"; 
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setInt(2, edad);
			ps.setDouble(3, peso);
			ps.executeUpdate();
			System.out.println("...Sentencia ejecutada");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("No se ha podido establecer la conexión con la base de datos");
			return; 
		}
	}
	
	private static void search(int id) {
		try (Connection conn = DriverManager.getConnection(PATH, USER, PASSWORD)){
			System.out.println("Se ha establecido la conexión con al base de datos");
			
			String query = "SELECT * FROM PERSONAS WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("ID") + " - ");
				System.out.print(rs.getString("NOMBRE") + " - ");
				System.out.print(rs.getInt("EDAD") + " - ");
				System.out.print(rs.getDouble("PESO"));
				System.out.println();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("No se ha podido establecer la conexión con la base de datos");
			return;
		}
	}
	
	private static void update(int id, String nombre, int edad, double peso) {
		try (Connection conn = DriverManager.getConnection(PATH, USER, PASSWORD)){
			System.out.println("Se ha establecido la conexión con al base de datos");
			
			String query = "update personas set NOMBRE=?, EDAD=?, PESO=? WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setInt(2, edad);
			ps.setDouble(3, peso);
			ps.setInt(4, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("No se ha podido establecer la conexión con la base de datos");
			e.printStackTrace();
			return; 
		}
	}
	
	private static void delete(int id) {
		try (Connection conn = DriverManager.getConnection(PATH, USER, PASSWORD)){
			System.out.println("Conexión establecida");
			
			String query = "delete from personas where ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
	}
	
}
