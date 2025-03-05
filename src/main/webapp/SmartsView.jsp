<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="controleur" method="post" > 
    <input type="text"  name="motCle"  value="${modele.motCle}"> 
    <input type="submit"  value="OK"> 
  </form> 
  <table border="1" width="80%"> 
    <tr> 
      <th>id</th> <th>marque</th><th>modele</th> <th>ram</th> <th>stockage</th>  <th>Prix</th>  
    </tr> 
   <c:forEach items="${modele.smarts}" var="s"> 
      <tr> 
        <td>${s.id}</td> 
        <td>${s.marque}</td> 
        <td>${s.modele}</td> 
        <td>${s.ram}</td> 
        <td>${s.stockage}</td> 
        <td>${s.prix}</td> 
      </tr> 
   </c:forEach> 
  </table> 
</body>
</html>