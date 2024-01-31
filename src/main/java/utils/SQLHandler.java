package utils;


public class SQLHandler {

	String create_table_query 
	= "CREATE TABLE Coche (\r\n"
	+ "    id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
	+ "    marca VARCHAR(255) NOT NULL,\r\n"
	+ "    modelo VARCHAR(255) NOT NULL,\r\n"
	+ "    ano_fabricacion INT NOT NULL,\r\n"
	+ "    km INT NOT NULL\r\n"
	+ ");";
	

}
