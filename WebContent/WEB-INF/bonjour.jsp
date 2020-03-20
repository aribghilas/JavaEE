<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %> <!-- Include de fichiers  -->
<h2>Expression language</h2>
<p>Bonjour ${ empty name ? "null" : name}</p> <!-- variable name avec Expression Language LE  -->
<h1>la JSTL</h1>
<h2>test de la JSTL</h2>
<h2> <c:out value="test JSTL"/></h2> <!-- test JSTL -->
<h2>agir avec la JSTL sur un java beans</h2>
<c:set target="${ auteur }" property="prenom" value="ghiles "  /> <!-- agir sur un beans avec la JSTL -->
<p> <c:out value="${ auteur.prenom }"/> </p>
<h2>Condition avec la JSTL</h2>
<!-- Condition avec la JSTL -->
<h3>avec un c:if</h3>
<c:if test="${ 50 > 10 }"> c'est vrai ! </c:if> <!-- avec un c:if -->
<h3>avec un c:choose suivis de c:when</h3>
<c:set var="prenom" value="${ auteur.prenom }" scope="page" ></c:set>  <!-- créer une variable prénom qui contien le prénom de l'auteur-->
<p>
<c:choose>
  <c:when test="${prenom !='' && prenom.equals(\"ghiles\")}">c'est vrai </c:when>
   <c:when test="${prenom !='' && prenom!=\"ghiles\"}">le prénom n'est pas le bon </c:when> 
   <c:otherwise>inséré un nom</c:otherwise>
    
</c:choose>
</p>
<p>
<%
String var= (String) request.getAttribute("var");
out.println(var);
%>
</p>
<p> l'auteur ${ auteur.getNom() } ${ auteur.actif ? "vous etes actif": " nope " }</p>
<ul>
<% for(int i = 0; i<20; i++) { %>
	 <li> <%out.println("une nouvelle ligne!");%> </li>
  <% } %>
 
</ul>
</body>
</html>