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
    h2 {color: black; }
    h3 {color: black; }
    h1 { color: grey; }
  		</style>
  		<script language="javascript">
//VALIDACION CHECKBOX
function validacion(formu, obj) {
  limite=1; //limite de checks a seleccionar
  num=0;
    for (i=0;ele=document.getElementById(formu).children[i] ; i++)
    {   
    	if (ele.checked) 
    	num++;	    	
    }
  if (num>limite)
    obj.checked=false;  
}  
</script>
  		
	</head>
<body>

<header class="panel-primary">
<div class="container-fluid panel-heading">
  <h1><center><img src="C:\java\proyectos\proyecto-limpio-spring\src\main\webapp\WEB-INF\vistas\Logo.jpg"/></center></h1>
   <div class="col-md-11"> <center><h2>${usuario.nombre} ${usuario.apellido}</h2></center></div>  <a href="/proyecto-limpio-spring/exit"  class="btn btn-info btn-lg active" role="button">Salir</a>
</div>
</header><br><br>
<div class="col-md-4"></div>
<div class="col-md-4">
<div class="panel panel-primary"><div class="panel-heading"><center>Ingresa tus datos</center></div>

<form:form action="guardarAlumno" method="POST" modelAttribute="Alumno"> 
	<br><br>
	<div class="col-xs-12">
	<form:input path="nombre" placeholder="Nombre" class="form-control"/>
	</div><br><br><br><br>
	<div class="col-xs-12">
	<form:input path="apellido" placeholder="Apellido" class="form-control"/>
	</div><br><br><br><br>
	<div class="col-xs-12">
	<form:input path="password" placeholder="Contraseņa" class="form-control"/>
	</div><br><br><br><br>
	<div class="col-xs-12">
	<form:input path="email" placeholder="Mail" class="form-control"/>
	</div><br>
	
	<div class="col-xs-12">
	<c:forEach items= "${Chorizo}" var="materias" ><br></br>	
	<!--  <input type="checkbox" name="idCurso" value="${materias.id}" > ${materias.nombre}-->
	<input type="checkbox"  name="idCurso" value="${materias.id}"  onclick="validacion('${materias.id}',this)" >${materias.nombre}
	</c:forEach>
	<br>
	</div>
	<br>
	<button class="btn btn-lg btn-danger btn-block" Type="Submit">Guardar</button>
	</form:form>
	</div>
<br>

</div>
<div class="col-md-4"></div>
</body>
</html> 