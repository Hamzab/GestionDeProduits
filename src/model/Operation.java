package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operation {
 
	 private ArrayList<Produit> produits=new ArrayList<Produit>();

	 
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	
	public void addProduit(Produit p){
	try {
		Connection conn	 =Connexion.getConnexion();
		PreparedStatement pr=conn.prepareStatement("INSERT INTO produit VALUES(NULL,?,?,?,?)");
		pr.setString(1, p.getNom());
		pr.setString(2, p.getDesc());
		pr.setInt(3, p.getPrix());
		pr.setInt(4, p.getEtat());
		pr.execute();
		conn.close();
		produits.add(p);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public boolean removeProduit(Long id){
		boolean estSupeme=false;
		
		try {
			Connection conn	 =Connexion.getConnexion();
			PreparedStatement pr=conn.prepareStatement("DELETE FROM produit WHERE id=?");
			pr.setInt(1,id.intValue());
		
			pr.execute();
			conn.close();
			for(Produit p: produits){
				if(p.getId()==id){
					produits.remove(p);
					estSupeme=true;
					break;
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return estSupeme;
	}
	public ArrayList<Produit> getAllProduits(){
		ArrayList<Produit> lesProduits=new ArrayList<Produit>();
		try {
			
			Connection conn	 =Connexion.getConnexion();
			PreparedStatement pr=conn.prepareStatement("SELECT * FROM produit");
			ResultSet rs=(ResultSet)pr.executeQuery("SELECT * FROM produit") ;
			while(rs.next()){
			int id=rs.getInt("id");
			String nom=rs.getString("nom");
			String desc=rs.getString("desc");
			int prix=rs.getInt("prix");
			int etat=rs.getInt("etat");
			Produit p=new Produit(new Long(id),nom,desc,prix,etat);
			lesProduits.add(p);
			}
			rs.close();
			pr.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return lesProduits;
	}
	
	
	public List<Produit> obtenirLesProduits(){
		List<Produit> lesProduits= new ArrayList<Produit>();
		Connection conn;
		try {
			conn = Connexion.getConnexion();
			PreparedStatement pr=conn.prepareStatement("SELECT * FROM produit");
			ResultSet rs=(ResultSet)pr.executeQuery("SELECT * FROM produit") ;
			while(rs.next()){
			int id=rs.getInt("id");
			String nom=rs.getString("nom");
			String desc=rs.getString("desc");
			int prix=rs.getInt("prix");
			int etat=rs.getInt("etat");
			Produit p=new Produit(new Long(id),nom,desc,prix,etat);
			lesProduits.add(p);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return lesProduits;
	}
	
	public void setProduit(Long id, Produit p){
		try {
			Connection conn	 =Connexion.getConnexion();
			PreparedStatement pr=conn.prepareStatement("UPDATE produit SET nom=?, `desc`=?, prix=?, etat=? WHERE id=?");
			pr.setString(1, p.getNom());
			pr.setString(2, p.getDesc());
			pr.setInt(3, p.getPrix());
			pr.setInt(4, p.getEtat());
			pr.setInt(5,id.intValue());
			pr.executeUpdate();
			pr.close();
			conn.close();
		//	produits.add(p);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Produit getProduit(Long id){
		Produit p=new Produit();
		try {
			Connection conn	 =Connexion.getConnexion();
			PreparedStatement pr=conn.prepareStatement("SELECT * FROM  produit WHERE id=?;");
			pr.setLong(1,id);
            
			ResultSet rs=pr.executeQuery();
			while(rs.next()){
			p.setId(id);	
			p.setNom(rs.getString("nom"));
			p.setDesc(rs.getString("desc"));
			p.setPrix(rs.getInt("prix"));
			p.setEtat(rs.getInt("etat"));
			}
			rs.close();
			pr.close();
			conn.close();
		//	produits.add(p);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	
	
}
