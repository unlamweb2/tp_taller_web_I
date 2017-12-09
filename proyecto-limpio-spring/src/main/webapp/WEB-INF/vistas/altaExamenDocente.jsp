<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/estilos.css" rel="stylesheet">
	    	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>		 
	    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/funciones.js"></script>    	  		
	</head>
<body>

<header class="panel-primary">
<div class="container-fluid panel-heading">
 <h1><center><img src="img/Logo.jpg"/></center></h1>
   <div class="col-md-11"> <center><h2>Cargue el Exámen Profesor ${usuario.nombre} ${usuario.apellido}</h2></center></div>  <div class="col-md-1"><a href="/proyecto-limpio-spring/exit"  class="btn btn-info btn-lg active" role="button">Salir</a></div>
</div>
</header>

<br>
<br>

<div class="contenedor">

<h3>Nuevo Exámen</h3>
		
	
<form:form action="guardarExamen" method="POST" modelAttribute="Examen"> 

	<select id="IdCurso" name="IdCurso" class="form-control"  >
	<option value="${Curso.id}" selected>${Curso.nombre}</option>		
	</select> 	
	<br>		
	<form:input path="nombre" id="nombre"  class="form-control" placeholder="Nombre del Examen"  />
	<br>
	<form:input path="fecha" id="fecha" class="form-control"  placeholder="Fecha del Examen"/>
	<br>	
	<form:input path="tipo" id="tipo" class="form-control"  placeholder="Tipo de Examen"/>
	<br>
	<h5>Porcentaje de respuestas correctas:</h5>
	<form:input path="umbral" id="umbral" class="form-control" value="70"  />
	<br>
				
	<input class="btn btn-success" type="submit" value="Guardar Nuevo Exámen"/>
	
    
</form:form>

</div>

<!-- Footer -->	     

	                <div class="footer">
	                    <center><p><h6>Copyright &copy; Proyecto Colmena 2018</h6></p></center>
	                </div> 
</body>
</html>