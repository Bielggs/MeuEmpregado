package br.edu.facear.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private Connection con;
	private String driver;
	private String url;
	private String username;
	private String password;
	

	public Conexao(){
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/meuempregado?UseSSL=false";
		username = "root";
		password = "root";
	}
	
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException{
		Class.forName(driver) ;
		this.con = DriverManager.getConnection(url, username, password);
		
		return this.con;
	}

}
