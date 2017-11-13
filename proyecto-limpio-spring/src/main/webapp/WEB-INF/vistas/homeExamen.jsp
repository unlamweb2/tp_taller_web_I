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
  		
<script language="javascript">
//VALIDACION CHECKBOX
function validacion(formu, obj) {
  limite=1; //limite de checks a seleccionar
  num=0;
//  if (obj.checked) {
    for (i=0;ele=document.getElementById(formu).children[i] ; i++)
    {   
    	if (ele.checked) 
    	num++;	    	
    }
  if (num>limite)
    obj.checked=false;
  
//  }
}  
</script>  		
  		
	</head>
</head>

<body>
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			
			  
<form:form action="corregir-examen" method="POST" modelAttribute="Examen" >

<h1 class="page-header text-center  titulo">${Examen.nombre}</h1>

 <input type="hidden" name="IdExamen" value="${Examen.id}">

	<c:forEach items= "${Examen.preguntas}" var="pregunta" >
	
		<div id="${pregunta.id}" class = "container" ><h3>${pregunta.nombre}</h3> <BR> 
			
			<c:forEach items= "${pregunta.respuestas}" var="respuesta" >	
		  		<input type="checkbox"  name="RespuestadelExamen" value="${respuesta.id}"  onclick="validacion('${pregunta.id}',this)" >${respuesta.nombre} <BR>			       	    
			</c:forEach> 	
		</div>	 
	 
	</c:forEach> 
<input type="submit"  value="Enviar"/>

</form:form>
			
				<!-- Footer -->	     

	                <div class="footer">
	                    <center><p>Copyright &copy; Proyecto Colmena 2018</p></center>
	                </div> 	
				
	
	
	</body>


</html>