package com.octest.bdd;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.io.IOException;

import com.octest.beans.*;

public class Nom {
	private Connection connexion=null;
	protected String messagee="walou";
	
private void loadDb() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				
			}
	try {
			
			connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","");//on peut rajouter .../javaee?autoReconnect=true&useSSL=false"
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}

public List<Utilisateurs> getUsers(){
	List<Utilisateurs> users= new ArrayList<Utilisateurs>();
	//chargement du driver
	
	//connexion a la bdd MySQL
	
	Statement statement=null;
	ResultSet resultat=null;
	loadDb();
	try {
		statement=connexion.createStatement();
		//exécuter la requette
		resultat = statement.executeQuery("select nom,prenom from nom;");
		//recupération des données
		while (resultat.next()) {
			String nom=resultat.getString("nom");
			String prenom=resultat.getString("prenom");
			Utilisateurs utilisateur= new Utilisateurs(nom,prenom);
			users.add(utilisateur);
		}
		
		
	}catch(SQLException e) {
		
	}finally {
		//fermeture de la connexion
		try {
			if (resultat !=null)
				resultat.close();
			if (statement !=null)
				statement.close();
			if (connexion !=null)
				connexion.close();
		}catch(SQLException ignore) {
			
		}
	}

	return users;
	
}

public void insertUser(Utilisateurs user) {
	loadDb();
	try {
		PreparedStatement preparedStatement= connexion.prepareStatement("INSERT INTO nom (nom, prenom) VALUES(?, ?);");
		preparedStatement.setString(1, user.getNom());
		preparedStatement.setString(2, user.getPrenom());
		preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}

}

public void supligne(Utilisateurs user) {
	loadDb();
	PreparedStatement prepared;
	try {
		prepared = connexion.prepareStatement("delete from nom where nom=? and prenom=?;");
		prepared.setString(1, user.getNom());
		prepared.setString(2, user.getPrenom());
		prepared.executeUpdate();
	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	 e.printStackTrace();
	 
	}

}
public String erreur(Utilisateurs user) {
	String message="null";
	if ((user.getNom()!=null && !user.getNom().isEmpty()) && (user.getPrenom()!= null && !user.getPrenom().isEmpty())) {
	return message="bien";
}
else {
	return message="introduire le nom et le prénom";
}
	
}

public String getMessagee() {
	return messagee;
}

public void setMessagee(String message) {
	this.messagee = message;
}	
}

