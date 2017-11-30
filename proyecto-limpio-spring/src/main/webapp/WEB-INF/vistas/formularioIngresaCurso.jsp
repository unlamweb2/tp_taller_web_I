<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
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
    h6 { color: grey; }
    h4 { color: white; }
    h2 {color: black; }
    h3 {color: black; }
    h1 { color: grey; }
  		</style>
  		
	</head>
<body>

<header class="panel-primary">
<div class="container-fluid panel-heading">
  <h1><center><img src="C:\java\proyectos\proyecto-limpio-spring\src\main\webapp\WEB-INF\vistas\Logo.jpg"/></center></h1>
  <!--   <div class="col-md-11"> <h2>${Usuario} </h2></div>  <center><a href="/proyecto-limpio-spring/exit"  class="btn btn-info btn-lg active" role="button">Salir</a></center>-->
   <div class="col-md-11"> </div>  <center><a href="/proyecto-limpio-spring/exit"  class="btn btn-info btn-lg active" role="button">Salir</a></center>
</div>
</header>
<br><br>
<form:form action="guardarCurso" method="POST" modelAttribute="Materia">


<br>
	<div class="col-md-4"></div>
		<div class="col-md-4">
	<div class="panel panel-primary"><div class="panel-heading">Ingresar curso</div>
	<br><br>
	<div class="col-xs-12">
	<form:input path="nombre" placeholder="Materia" class="form-control"/>
	</div><br><br><br><br>
	<input type="submit" class="btn btn-lg btn-danger btn-block" role="button" value="Guardar"/>
	</div>
	</div>
	<div class="col-md-4"></div>
</form:form>
</body>
</html> 