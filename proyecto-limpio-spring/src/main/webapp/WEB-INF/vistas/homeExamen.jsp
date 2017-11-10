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
    h4 { color: red; }
    h1 { color: black; }
  		</style>
  		
  		
	</head>
</head>
<body>
  
<form:form action="corregir-examen" method="POST" modelAttribute="Examen" >
<h1 class="page-header text-center  titulo">${Examen.nombre}</h1>

 <input type="hidden" name="IdExamen" value="${Examen.id}">

	<c:forEach items= "${Examen.preguntas}" var="pregunta" >
	
		<div>${pregunta.nombre}</div>
			
		<c:forEach items= "${pregunta.respuestas}" var="respuesta" >
		 <label for="${respuesta.id}">${respuesta.id}</label>				
	  <input type="checkbox"  name="RespuestadelExamen" value="${respuesta.id}" id="${respuesta.id}" >${respuesta.nombre} <BR> 
					       	    
		</c:forEach> 	 
	 
	</c:forEach> 
<input type="submit"  value="Enviar"/>
</form:form>
 
<br/>
</body>
</html>