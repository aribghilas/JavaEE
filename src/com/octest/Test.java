package com.octest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.beans.Auteur;

import java.io.PrintWriter;


@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String message= "bye bye";
		request.setAttribute("var", message);
		
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		System.out.print(name);
		
		 
	    Auteur auteur= new Auteur();//java beans (object)
	    auteur.setNom("Zola");
	    auteur.setPrenom("Emil");
	    auteur.setActif(true);
	    System.out.println(auteur.getPrenom());
	    request.setAttribute("auteur", auteur);
	    this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);//connexion a la JSP
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
