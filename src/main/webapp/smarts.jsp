<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div class="container">
<div class="card">
<div class="card-header">
Recherche des smartphones
</div>
<div class="card-body">
<form action="chercher.do" method="get">
<label>Mot Clé</label>
<input type="text" name="motCle" value="${model.motCle}" />
<button type="submit" class="btn btn-primary">Chercher</button>
</form>
<table class="table table-striped">
<tr>
<th>ID</th>
<th>marque</th>
<th> modele</th>
<th>ram</th>
<th>stockage</th>
<th>Prix</th>
</tr>
<c:forEach items="${model.smarts}" var="s">
<tr>
<td>${s.id }</td>
<td>${s.marque }</td>
<td>${s.modele }</td>
<td>${s.ram }</td>
<td>${s.stockage }</td>
<td>${s.prix }</td>
<td><a onclick="return confirm('Etes-vous sûr ?')"
href="supprimer.do?id=${s.id }">Supprimer</a></td>
<td><a href="editer.do?id=${s.id}">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>