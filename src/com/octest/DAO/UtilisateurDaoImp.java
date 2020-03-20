package com.octest.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Utilisateurs;

public class UtilisateurDaoImp implements UtilisateurDao  {
	private DaoFactory daofactory;
	UtilisateurDaoImp(DaoFactory daofactory){
		this.daofactory=daofactory;
	}
public void ajouter(Utilisateurs user) {
	
	Connection connexion=null;
	try {
		connexion=daofactory.getConnexion();
		PreparedStatement preparedStatement= connexion.prepareStatement("INSERT INTO nom (nom, prenom) VALUES(?, ?);");
		preparedStatement.setString(1, user.getNom());
		preparedStatement.setString(2, user.getPrenom());
		preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
}
public List<Utilisateurs> lister(){
	List<Utilisateurs> users= new ArrayList<Utilisateurs>();
	Statement statement=null;
	Connection connexion=null;
	ResultSet resultat=null;
	try {
		connexion=daofactory.getConnexion();
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
public void suprimer(Utilisateurs user) {
	PreparedStatement prepared;
	Connection connexion=null;
	try {
		connexion=daofactory.getConnexion();
		prepared = connexion.prepareStatement("delete from nom where nom=? and prenom=?;");
		prepared.setString(1, user.getNom());
		prepared.setString(2, user.getPrenom());
		prepared.executeUpdate();
	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	 e.printStackTrace();
	 
	}
}
}
