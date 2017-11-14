<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="css/bootstrap.min.css" rel="stylesheet" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    
	   
	    
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/estilos.css" rel="stylesheet">
	    
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    <link href="js/bootstrap.min.js" rel="stylesheet" >
	    <link href="js/jquery-1.11.3.min.js" rel="stylesheet" >
	    
	      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  			
  			
  			<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/estilos.css" rel="stylesheet">
	    
	     <style>
    h4 { color: white; }
    h1 { color: white; }
   
  		</style>
  		
	    
</head>
<body>

<header class="panel-primary">
<div class="container-fluid panel-heading">
  <h1><center><img src="C:\java\proyectos\proyecto-limpio-spring\src\main\webapp\WEB-INF\vistas\Logo.jpg"/></center></h1>
   <div class="col-md-11"> <h4>${usuario.nombre} ${usuario.apellido}</h4></div>  <div class="col-md-1"><a href="login"  class="btn btn-info btn-lg active" role="button">Salir</a></div>
</div>

</header>


<div class="row">
  <div class="col-md-4"></div>
<div class="col-md-4">
<br></br>
<table class="table table-hover">
<tr class="danger" ><th><h2><center>Materias</center></h2></th></tr>

<c:forEach items= "${Materias}" var="cursos" >
<tr ><td class="info"><h2><a href="rendirExamenDinamico/${cursos.id}">${cursos.nombre} </a></h2>COD: ${cursos.id}</td></tr>
</c:forEach> </div>

 
</table>
<div class="col-md-4"></div>
</div>


<br><br><br><br><br><br><div><a href="rendirExamen"  class="btn btn-danger btn-sm active" role="button">Rendir examen</a></div>
</body>
</html>