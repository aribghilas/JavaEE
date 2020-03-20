<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h1>page acceuil</h1>
<c:if test="${ !empty sessionScope.nom && !empty sessionScope.prenom }"> <p>bonjour ${sessionScope.nom} </p> </c:if>
<c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
<form method="post" action="acceuil" enctype="multipart/form-data">
 <p>
 <label for="description">description</label>
 <input type="text" id="description" name="description" />
 </p>
 <p>
<label for="fichier">Envoyer un fichier</label>
<input type="file" id="fichier" name="fichier">
</p>
<p>
<input type="submit" name="envoyer" />
</p>
</form>
<c:if test="${ !empty form.resultat }"> <h3> <c:out value="${ form.resultat }" /></h3></c:if>
</body>
</html>