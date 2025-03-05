<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256"> 
<title>Insert title here</title> 
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %> 
<p></p> 
<div class="container"> 
<div class="card"> 
<div class="card-header"> 
Modification des Smartphones 
</div> 
<div class="card-body"> 
<form action="update.do" method="post"> 
<div class="form-group"> 
<label class="control-label">Id :</label> 
<input type="text" name="id" class="form-control" 
value="${smartphone.id}"/> 
</div> 
<div class="form-group"> 
<label class="control-label">marque :</label> 
<input type="text" name="marque" class="form-control" 
value="${smartphone.marque}"/> 
</div> 
<div class="form-group"> 
<label class="control-label">modele :</label> 
<input type="text" name="modele" class="form-control" 
value="${smartphone.modele}"/> 
</div> 
<div class="form-group"> 
<label class="control-label">ram :</label> 
<input type="text" name="ram" class="form-control" 
value="${smartphone.ram}"/> 
</div> 
<div class="form-group"> 
<label class="control-label">stockage :</label> 
<input type="text" name="stockage" class="form-control" 
value="${smartphone.stockage}"/> 
</div> 
<div class="form-group"> 
<label class="control-label">prix :</label> 
<input type="text" name="prix" class="form-control" 
value="${smartphone.prix}"/> 
</div> 
<button type="submit" class="btn btn-primary">Modifier</button> 
</body>
</html>