package web;
import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Operation;
import model.Produit;
public class ProduitServlet extends HttpServlet{
	  Operation op= new Operation();
	  
	  Long id=new Long(0);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(req.getParameter("action_modifier")!=null){
			 Long idget=Long.parseLong(req.getParameter("id"));
			 Produit p= op.getProduit(idget);
			 req.setAttribute("unProduit", p);
		}else
		if(req.getParameter("action_modifier1")!=null){
			     Long idget=Long.parseLong(req.getParameter("id"));
		         String nom=req.getParameter("nom");
		         String desc=req.getParameter("desc");
		         String prix=req.getParameter("prix");
		         String etat=req.getParameter("etat");
		         Produit p=new Produit(nom, desc, Integer.parseInt(prix), Integer.parseInt(etat));
			    if(op.getAllProduits().size()>0){
			         op.setProduit(idget, p);
			       
			    }	
			
		}else if(req.getParameter("action")!=null){
			  Long idget=Long.parseLong(req.getParameter("id"));
			  
			    if(op.getAllProduits().size()>0){
			        op.removeProduit(idget);
			       
			    }	
			
		}else{
			id++;
	         String nom=req.getParameter("nom");
	         String desc=req.getParameter("desc");
	         String prix=req.getParameter("prix");
	         String etat=req.getParameter("etat");
	         Produit p=new Produit(nom, desc, Integer.parseInt(prix), Integer.parseInt(etat));
	       
	         op.addProduit(p);
		}
		
         req.setAttribute("produits", op.getAllProduits());
         req.getRequestDispatcher("Produit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		 System.out.println("bbbbbbbbbbbbbbbbbbbb");
        req.setAttribute("produits", op.getAllProduits()); 	
  
	
    req.getRequestDispatcher("Produit.jsp").forward(req, resp);	

	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	/*	 Long idget=Long.parseLong(req.getParameter("id"));
		    if(op.getAllProduits().size()>0){
		        op.removeProduit(idget);
		        req.setAttribute("produits", op.getAllProduits()); 	
		    }
		    req.getRequestDispatcher("Produit.jsp").forward(req, resp);	
*/
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
}
