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
	<h1>Liste des clients</h1>
	<table>
		<tr>
			<th>Nom</th>
			<th>Factures</th>
			<th>Action</th>
			<c:forEach var="client" items="${clients}" varStatus="loop">
			<tr>
				<td>${client.nom}</td>
				<td>
					<c:forEach var="facture" items="${factures}" >
						<c:if test="${facture.client.id eq client.id }">
							<a href="factures?id=${facture.id}">Facture ${facture.id}</a><br>
						</c:if>
					</c:forEach>
				</td>
				<td>
					<a href="modifierClients?id=${client.id}">Modifier</a><br>
					<c:if test="${factures eq null}">
						<a href="supprimerClients?id=${client.id}">Supprimer</a><br>
					</c:if>
					<a href="ajouterFactures?id=${client.id}">Ajouter une facture</a>
				</td>
			</tr>
			
			</c:forEach>
		</tr>
	</table>
	<a href="ajouterClients">Ajouter un client</a>
</body>
</html>