package com.octest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.octest.bdd.*;
import com.octest.beans.*;

/**
 * Servlet implementation class TestBdd
 */
@WebServlet("/TestBdd")
public class TestBdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestBdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//afficher les nom de la table nom
		Nom tableNom= new Nom();
		Utilisateurs user=new Utilisateurs();
		request.setAttribute("users", tableNom.getUsers());
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/testbdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//créer un nv tuple dans la bdd
        String nom = request.getParameter("nom");
        String prenom= request.getParameter("prenom");
        Utilisateurs user= new Utilisateurs(nom, prenom);
        Nom ajout= new Nom();
        ajout.insertUser(user);
        request.setAttribute("users", ajout.getUsers());
        request.setAttribute("ajout", ajout.erreur(user));
        
        String supNom= request.getParameter("supNom");
        String supPrenom=request.getParameter("supPrenom");
        
        Utilisateurs user2= new Utilisateurs(supNom,supPrenom);
        Nom suprimer = new Nom();
        suprimer.supligne(user2);
        request.setAttribute("users", suprimer.getUsers());
        request.setAttribute("suprime", suprimer.erreur(user2));
        
        
        
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/testbdd.jsp").forward(request, response);
		
	}

}
