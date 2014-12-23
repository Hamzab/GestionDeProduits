<%@page import="model.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de produits</title>
</head>
<body>
<%
 ArrayList<Produit> produits=null;
Long id=null;
String nom="";
String desc="";
int prix=0;
int etat=0;
 if(request.getAttribute("produits") != null){
	 
	 produits=(ArrayList<Produit>)request.getAttribute("produits");
 }else{
	 produits=new ArrayList(); 
 }
if(request.getAttribute("unProduit") != null){
	Produit p=(Produit)request.getAttribute("unProduit");
	%>
 <form  method="post">
  <input type="hidden" name="action_modifier1" value="supp">
   <input type="hidden" name="id" value="<%=p.getId()%>">
  <table border="1" width="50%">
  <tr>
  <td>Nom</td>
  <td><input type="text" name="nom" value="<%=p.getNom()%>"/></td>
  </tr>
  <tr>
  <td>Description</td>
  <td><input type="text" name="desc" value="<%=p.getDesc()%>"/></td>
  </tr> 
    <tr>
  <td>Prix</td>
  <td><input type="text" name="prix" value="<%=p.getPrix()%>"/></td>
  </tr>
    <tr>
  <td>Etat</td>
  <td><input type="text" name="etat" value="<%=p.getEtat()%>"/></td>
  </tr> 
  <td colspan="2"><input type="submit" value="Valider"/></td>
  </tr>
  </table>
  </form>
	<%
}else{
%>
 <form action="prodserv" method="post">
  <table border="1" width="50%">
  <tr>
  <td>Nom</td>
  <td><input type="text" name="nom"/></td>
  </tr>
  <tr>
  <td>Description</td>
  <td><input type="text" name="desc"/></td>
  </tr> 
    <tr>
  <td>Prix</td>
  <td><input type="text" name="prix"/></td>
  </tr>
    <tr>
  <td>Etat</td>
  <td><input type="text" name="etat"/></td>
  </tr> 
  <td colspan="2"><input type="submit" value="Valider"/></td>
  </tr>
  </table>
  </form>
  <%
}
  %>
  <table border="1 solid black">
  <tr>
  <th>ID</th>
  <th>Nom</th>
  <th>Description</th>
  <th>Prix</th>
  <th>Etat</th>
  </tr> 
  <%
  if(produits.size()>0){
   for(int i=0;i<produits.size();i++){
	   
	   
   
  %>
  <tr>
  <td><%=produits.get(i).getId()%></td>
  <td><%=produits.get(i).getNom()%></td>
  <td><%=produits.get(i).getDesc()%></td>
  <td><%=produits.get(i).getPrix()%></td>
  <td><%=produits.get(i).getEtat()%></td>
  <td>
  <form method="post">
  <input type="hidden" name="id" value="<%=produits.get(i).getId()%>">
   <input type="hidden" name="action" value="supp">
  <input type="submit" value="suprimer"/>
  </form>
  </td>
  
    <td>
  <form method="post">
  <input type="hidden" name="id" value="<%=produits.get(i).getId()%>">
   <input type="hidden" name="action_modifier" value="modifier">
  <input type="submit" value="modifier"/>
  </form>
  </td>
  </tr>
 <% 
     }
  }
  %>
  </table>
</body>
</html>