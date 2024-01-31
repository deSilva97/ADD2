package model;

public class ConfigurationConnection {

	String protocol;
	String subprotocol;
	String host;
	int port;
	String name;
	
	String user;
	String password;	
	
	public ConfigurationConnection() {		
		protocol = "jdbc";
		subprotocol = "mysql";
		host = "localhost";
		port = 3306;
		name = "bbdd";
		
		user = "root";
		password = "";			
	}
	
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getSubprotocol() {
		return subprotocol;
	}

	public void setSubprotocol(String subprotocol) {
		this.subprotocol = subprotocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConnectionPath() {
		return protocol + ":" + subprotocol + "://" + host + ":" + port + "/" + name; 	
	}

	@Override
	public String toString() {
		return "ConfigurationConnection [protocol=" + protocol + ", subprotocol=" + subprotocol + ", host=" + host
				+ ", port=" + port + ", name=" + name + ", user=" + user + ", password=" + password + "]";
	}
	
	
}
