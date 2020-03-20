package com.octest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
 private String url;
 private String userName;
 private String password;
 
 public DaoFactory (String url, String userName, String passwor) {
	 this.url=url;
	 this.userName=userName;
	 this.password=password;
 }
 
 public static DaoFactory getInstance() {
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
	 }catch(ClassNotFoundException e) {
		 
	 }
	DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/javaee","root","");
	return instance;
 }
 
public Connection getConnexion() throws SQLException {
	return DriverManager.getConnection(url, userName, password);
}

public UtilisateurDao getUtilisateurDao() {
	return new UtilisateurDaoImp(this);
}
}
