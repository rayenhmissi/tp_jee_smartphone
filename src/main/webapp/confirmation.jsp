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
    Confirmation Ajout Smartphones 
  </div> 
   <div class="card-body"> 
       
      <div class="form-group"> 
       <label class="control-label">id :</label> 
       <input type="text" name="Nom" class="form-control" 
value="${smartphone.id }"/> 
 <label class="control-label">marque smartphone :</label> 
       <input type="text" name="Nom" class="form-control" 
value="${smartphone.marque }"/> 
 <label class="control-label">modele smartphone :</label> 
       <input type="text" name="Nom" class="form-control" 
value="${smartphone.modele }"/> 
 <label class="control-label">ram  :</label> 
       <input type="text" name="Nom" class="form-control" 
value="${smartphone.ram }"/> 
 <label class="control-label">stockage :</label> 
       <input type="text" name="Nom" class="form-control" 
value="${smartphone.stockage }"/> 
 <label class="control-label">prix smartphone :</label> 
       <input type="text" name="Nom" class="form-control" 
value="${smartphone.prix }"/> 

      </div> 
       </div> 
          
  </div> 
</div> 
</body>
</html>