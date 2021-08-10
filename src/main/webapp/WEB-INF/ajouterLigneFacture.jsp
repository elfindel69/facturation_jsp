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
	<h1>Facture ${facture.id}</h1>
	
	<form action="ajouterLigneFactures?id=${facture.id}" method="post">
		<label for="prestationId">Prestation</label>
		<select name="prestationId">
			<option>Choisissez une prestation</option>
			<c:forEach var="prestation" items="${prestations}"> 
				<option value="${prestation.id}"> ${prestation.nom} (${prestation.montant} €)</option>
			</c:forEach>
		</select>
		<br>
		<label for="quantite">Quantite</label>
		<input type="number" name="quantite">
		<br>
		<label for="remise">Remise</label>
		<input type="number" name="remise">
		<br>
		<input type="submit" value="Enregistrer">
	</form>
</body>
</html>