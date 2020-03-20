package com.octest.form;
import javax.servlet.http.*;

public class ConnextionForm {
private String resultat;

public void verifierIdentifiant(HttpServletRequest request) {
 String login = request.getParameter("login");
 String pass= request.getParameter("pass");
 if (pass.equals(login+"123")){
	 this.resultat="bienvenu "+login;
 }
 else {
	 this.resultat = "login ou mot de passe incorrect !"; 
 }
}

public String getResultat() {
	return resultat;
}

public void setResultat(String resultat) {
	this.resultat = resultat;
}


}
