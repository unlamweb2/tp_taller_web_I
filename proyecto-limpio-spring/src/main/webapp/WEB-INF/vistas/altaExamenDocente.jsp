<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    h2 {color: white; }
    h3 {color: black; }
    h1 { color: grey; }
  		</style>
  		
	</head>
<body>

<header class="panel-primary">
<div class="container-fluid panel-heading">
  <h1><center><img src="C:\java\proyectos\proyecto-limpio-spring\src\main\webapp\WEB-INF\vistas\Logo.jpg"/></center></h1>
   <div class="col-md-11"> <center><h2>Cargue el Exámen Profesor ${usuario.nombre} ${usuario.apellido}</h2></center></div>  <div class="col-md-1"><a href="/proyecto-limpio-spring/exit"  class="btn btn-info btn-lg active" role="button">Salir</a></div>
</div>
</header>

<br>
<br>
<h3>Nuevo Exámen</h3>

<form:form action="guardarExamen" method="POST" modelAttribute="Examen"> 

		
	<form:input path="nombre" id="nombre"  class="form-control" />
	<br>
	<form:input path="fecha" id="fecha" class="form-control" />
	<br>
	<form:input path="tipo" id="tipo" class="form-control" />
	<br>
	<form:input path="umbral" id="umbral" class="form-control" />
	<br>
	
			
	<input type="submit" value="Guardar Nuevo Exámen"/>
    
</form:form>

<!-- Footer -->	     

	                <div class="footer">
	                    <center><p><h6>Copyright &copy; Proyecto Colmena 2018</h6></p></center>
	                </div> 
</body>
</html>