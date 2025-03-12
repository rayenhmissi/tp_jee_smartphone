<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Saisie des Smartphones
</div>
<div class="card-body">
<form action="save.do" method="post">
<div class="form-group">
<label class="control-label">marque:</label>
<input type="text" name="marque" class="form-control"/>
</div>
<div class="form-group">
<label class="control-Label">modele: </label>
<input type="text" name="modele" class="form-control"/>
</div>
<div class="form-group">
<label class="control-label">ram:</label>
<input type="text" name="ram" class="form-control"/>
</div>
<div class="form-group">
<label class="control-label">stockage:</label>
<input type="text" name="stockage" class="form-control"/>
</div>
<div class="form-group">
<label class="control-label">Prix:</label>
<input type="text" name="prix" class="form-control"/>
</div>
<div>
<button type="submit" class="btn btn-primary">Ajouter</button>
</div>
</form>
</div>
</div>
</div>
</body>
</html>