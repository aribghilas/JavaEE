package com.octest.beans;

public class Utilisateurs {
 private String nom;
 private String prenom;
public Utilisateurs () {}
public Utilisateurs (String nom, String prenom) {
	this.nom=nom;
	this.prenom=prenom;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
 
}
