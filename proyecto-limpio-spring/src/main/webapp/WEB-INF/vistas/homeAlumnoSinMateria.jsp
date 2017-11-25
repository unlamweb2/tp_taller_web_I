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
    h3 { color: white; }
    h1 { color: white; }
    h2 {color: white; }
  		</style>
  		

</head>
<body>
<header class="panel-primary">
<div class="container-fluid panel-heading">
  <h1><center><img src="C:\java\proyectos\proyecto-limpio-spring\src\main\webapp\WEB-INF\vistas\Logo.jpg"/></center></h1>
   <div class="col-md-11"> <h3>${Alumno.nombre} ${Alumno.apellido}</h3></div>  <div class="col-md-1"><a href="login"  class="btn btn-info btn-lg active" role="button">Salir</a></div>
</div>

</header><br><br>
<div class="col-md-4"></div>
<div class="col-md-4">
<div class="panel panel-primary"><div class="panel-heading"><center><h3>Materias</h3></center></div>


<form:form action="inscribirAlumno" method="POST" modelAttribute="Chorizo">

<input type="hidden" name="idAlumno" value="${Alumno.id}"/>
<c:forEach items= "${Chorizo}" var="curso" ><br></br>
<div class="col-xs-12">

<input type="checkbox" name="idCurso" value="${curso.id}" > ${curso.nombre}
</div>
</c:forEach> <br><br>
<input type="submit" class="btn btn-lg btn-danger btn-block" value="Anotarse"/>
</form:form>
</div>
<div class="col-md-4"></div>
</body>
</html>

<!-- ESTO MUESTRA BIEN!!! Los id tambien -->
 <!-- <h1>Anotate ${Alumno.id}</h1>
<c:forEach items= "${Materias}" var="cursos" >
<br></br>
${cursos.id}
</c:forEach> -->

