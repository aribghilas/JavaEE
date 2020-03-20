<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> page test de la bdd</h1>
<p><c:forEach var="utilisateur" items="${ users }">
 <ul> <li><c:out value="${ utilisateur.nom }"/> <c:out value="${ utilisateur.prenom }" /></li></ul> 
</c:forEach>
</p>
<form method="post" action="testbdd">
<p>
<label for="nom">Nom</label>
<input type="text" id="nom" name="nom" />
<label for="prenom">Prenom</label>
<input type="text" id="prenom" name="prenom" />
</p>
<p>
<input type="submit" value="Ajouter" />
</p>
</form>
<h3><c:out value="${ ajout} " /></h3>

<form method="post" action="testbdd">
<p>
<label for="supNom">Nom a supprimer</label>
<input type="text" id="supNom" name="supNom" />
<label for="supPrenom">Prénom a supprimer</label>
<input type="text" id="supPrenom" name="supPrenom" />
<input type="submit" value="Supprimer" name="valider"/>
 </p>
</form>
 <h3><c:out value="${ suprime }" /></h3>
</body>
</html>