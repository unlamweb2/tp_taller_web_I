<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <div class="col-md-11"> <h4>${usuario.nombre} ${usuario.apellido}</h4></div>  <div class="col-md-1"><a href="login"  class="btn btn-info btn-lg active" role="button">Salir</a></div>
</div>

</header>

<div class="row">
  <div class="col-md-4"></div>
<div class="col-md-4">		<br></br>

<div class="panel panel-primary"><div class="panel-heading">${Materias.nombre}</div>
<form:form action="rendirExamen" method="POST" modelAttribute="Materias" >
  <input type="hidden" name="nombre" value="${usuario.nombre}">
  <input type="hidden" name="apellido" value="${usuario.apellido}">
<div class="form-check" id="${usuario.id}">		

			
			<c:forEach items= "${Materias.examen}" var="examen" >	
				<br>		
		  	<center>	<input class="form-check-input"  type="checkbox"  name="idExamen" value="${examen.id}"  onclick="validacion('${usuario.id}',this)" ><label class="form-check-label">  ${examen.nombre} </label></center>		       	    
			</c:forEach> 
</div>	
<br></br>
<input type="submit" class="btn btn-lg btn-danger btn-block" value="Enviar"/>

</form:form>

	</div>
	</div>
<div class="col-md-4"></div></div>
</body>
</html>