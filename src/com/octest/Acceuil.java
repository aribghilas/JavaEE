package com.octest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.octest.form.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.octest.fichier.*;

@WebServlet("/Acceuil")
public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    public Acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		TraitementFichier file = new TraitementFichier();
		file.envoiDonnée(request);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
	}
	
	

}
