<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Facturation</title>
</head>
<body>
	<h1>Modifier un client</h1>
	<form action="modifierClients?id=${client.id}" method="post">
		<label for="nom">Nom</label>
		<input type="text" name="nom" placeholder="${client.nom}">
		<input type="submit" value="modifier">
	</form>
</body>
</html>