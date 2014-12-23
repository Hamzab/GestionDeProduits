<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 List<Produit> produits=null;
Long id=null;
String nom="";
String desc="";
int prix=0;
int etat=0;
 if(request.getAttribute("lesProduits") != null){
	 
	 produits=(ArrayList<Produit>)request.getAttribute("lesProduits");
 }else{
	 produits=new ArrayList<Produit>(); 
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
  </tr>
 <% 
     }
  }
  %>
  </table>
</body>
</html>