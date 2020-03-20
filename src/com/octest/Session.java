package com.octest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Session() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
	    String prenom=(String) session.getAttribute("prenom");
	    String nom=(String)session.getAttribute("nom");
	    request.setAttribute("prenom", prenom);
	    request.setAttribute("nom", nom);
	    // recupérer les Cookies
	    Cookie[] cookies= request.getCookies();
	    if(cookies != null) {
	    	for(Cookie cookie : cookies) {
	    		if (cookie.getName().equals("prenomc")) {
	    			request.setAttribute("prenom", cookie.getValue());
	    			System.out.println(cookie.getValue());
	    		}
	    	}
	    }
		this.getServletContext().getRequestDispatcher("/WEB-INF/session.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		HttpSession session=request.getSession();
		
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		String deco=request.getParameter("deco");
		if (deco !=null && !deco.isEmpty()) {
			session.invalidate();
		}
	//les cookie !
		String prenomc = request.getParameter("prenomc");
		Cookie cookie= new Cookie("prenomc",prenomc); //créer un objet cookie
		cookie.setMaxAge(60 * 60); // définir combien de temps le cookie va rester (en sec)
		response.addCookie(cookie); // ajouter le cookie
		this.getServletContext().getRequestDispatcher("/WEB-INF/session.jsp").forward(request, response);
	}

}
