<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Facturation</title>
</head>
<body>
	<h1> Facture ${facture.id}</h1>
	
	<p>Client: ${facture.client.nom}</p>
	<p>Date de création: ${facture.dateCreation}</p>
	<p>Date d'echéance: ${facture.dateEcheance}</p>
	
	<h2>Produits</h2>
	<c:forEach var="ligne" items="${lignes}"> 
		<p>Prestation: ${ligne.prestation.nom} - ${ligne.prestation.montant} €</p>
		<p>Quantité: ${ligne.quantite}</p>
		<p>Remise: ${ligne.remise}</p>
	</c:forEach>
	<p>total: ${total}</p>
	<br>
	<a href="ajouterLigneFactures?id=${facture.id}">Ajouter une ligne</a>
</body>
</html>