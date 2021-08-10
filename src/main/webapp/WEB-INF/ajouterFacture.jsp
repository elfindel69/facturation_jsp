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
	<h1>Ajouter une facture</h1>
	<p>Client: ${client.nom}</p>
	<form action="ajouterFactures?clientId=${client.id}" method="post">
		<br>
		<label for="dateCreation">Date de création (format yyyy-MM-dd)</label>
		<input type="date" name="dateCreation">
		<br>
		<label for="dateExpiration">Date d'echéance (format yyyy-MM-dd)</label>
		<input type="date" name="dateExpiration">
		<br>
		<input type="submit" value="ajouter">
	</form>
</body>
</html>