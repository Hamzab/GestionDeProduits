package web;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Operation;

public class AfficherLesProduits extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
   Operation op= new Operation();

    if(! op.obtenirLesProduits().isEmpty()){
        req.setAttribute("lesProduits", op.obtenirLesProduits()); 	
    }
    req.getRequestDispatcher("afficherLesProduits.jsp").forward(req, resp);	

	}
}
