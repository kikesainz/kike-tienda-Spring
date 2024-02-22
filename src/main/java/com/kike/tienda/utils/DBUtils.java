package com.kike.tienda.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {

	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String urlDB = "jdbc:mysql://localhost:3306/tienda?serverTimezone=UTC";
		String user = "root";
		String pass = "PracticaRoot";
		Connection connection = DriverManager.getConnection(urlDB, user, pass);
		System.out.println("Conexión establecida con la DDBB");
		return connection;
	}
	
//	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException, NamingException {
//		
//		Context ctx = new InitialContext();
//		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
//		
//		Connection con = ds.getConnection();
//		
//		return con;
//	}
}
