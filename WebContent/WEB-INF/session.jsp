<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test session</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<c:if test="${ !empty nom && !empty prenom }"> <p>bonjour ${nom} ${ prenom } </p> </c:if>
<form method ="post" action="session">
<p>
<label for="nom"> Nom</label>
<input type="text" id="nom" name="nom" />
<label for="prenom">prenom</label>
<input type="text" id="prenom" name="prenom" />
</p>
<p> <input type="submit"></p>
</form>
<h3>les Cookies !!!</h3>
<form method="post" action="session">
<p>
<label for="nomc"> Nom</label>
<input type="text" id="nomc" name="nomc" />
<label for="prenomc">prenom</label>
<input type="text" id="prenomc" name="prenomc" />
</p>
<p> <input type="submit"></p>
</form>
<h3>la valeur du cookie est <c:out value="${ prenom }" /> </h3>
</body>
</html>