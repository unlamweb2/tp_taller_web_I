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
</head>
<body>
<h1>Hola ${usuario.nombre}</h1><br>

<!--<div><div><a href="verCursos/${usuario.id}"  class="btn btn-primary btn-sm active" role="button">Ver Cursos</a></div>-->

<!--<div><a href="rendirExamen22"  class="btn btn-danger btn-sm active" role="button">Rendir examen ENSAYO</a></div><br></br>-->

<div class="row">
  <div class="col-md-4"></div>
<div class="col-md-4">

<table class="table table-hover">
<tr class="danger"><th>Materias</th></tr>

<c:forEach items= "${Materias}" var="cursos" >
<tr ><td class="info"><a href="rendirExamen22/${cursos.id}">${cursos.nombre} </a>${cursos.id}</td></tr>
</c:forEach> </div>

 
</table>
<div class="col-md-4"></div>
</div>


<br><br><br><br><br><br><div><a href="rendirExamen"  class="btn btn-danger btn-sm active" role="button">Rendir examen</a></div>
</body>
</html>