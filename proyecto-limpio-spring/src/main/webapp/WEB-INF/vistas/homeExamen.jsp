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
	         			
  			  			    
	     <style>
    h4 { color: white; }
    h1 { color: black; }
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
  

</script>  		
  		
	</head>
</head>

<body>
		<header class="panel-primary">
<div class="container-fluid panel-heading">
  <h1><center><img src="C:\java\proyectos\proyecto-limpio-spring\src\main\webapp\WEB-INF\vistas\Logo.jpg"/></center></h1>
   <div class="col-md-11"> <h4>${Nombre} ${Apellido}</h4></div>  <div class="col-md-1"><a href="login"  class="btn btn-info btn-lg active" role="button">Salir</a></div>
</div>

</header>
			
<div class="row">
  <div class="col-md-4"></div>
<div class="col-md-4">	<br><br>
<div class="panel panel-primary"><div class="panel-heading">${Examen.nombre}</div></div>		  
<form:form action="corregir-examen" method="POST" modelAttribute="Examen" >

 <input type="hidden" name="IdExamen" value="${Examen.id}">
	<input type="hidden" name="nombre" value="${Nombre}">
  <input type="hidden" name="apellido" value="${Apellido}">
	<!--Union de dos clases-->
	<c:forEach items= "${Examen.preguntas}" var="pregunta" >
	
		<div id="${pregunta.id}" class = "container" ><h3>${pregunta.nombre}</h3> <BR> 
			
			<c:forEach items= "${pregunta.respuestas}" var="respuesta" >	
		  		<input type="checkbox"  name="RespuestadelExamen" value="${respuesta.id}"  onclick="validacion('${pregunta.id}',this)" >${respuesta.nombre} <BR>			       	    
			</c:forEach> 	
		</div>	 
	 
	</c:forEach> 
	<br>
<input type="submit" class="btn btn-lg btn-danger btn-block" value="Enviar"/>

</form:form></div>
	 <div class="col-md-4"></div></div>		
				<!-- Footer -->	     

	                <div class="footer">
	                    <center><p>Copyright &copy; Proyecto Colmena 2018</p></center>
	                </div> 	
				
	
	
	</body>


</html>