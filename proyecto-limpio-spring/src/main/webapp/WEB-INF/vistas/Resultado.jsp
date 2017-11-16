<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/estilos.css" rel="stylesheet">
	    
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    <link href="js/bootstrap.min.js" rel="stylesheet" >
	    <link href="js/jquery-1.11.3.min.js" rel="stylesheet" >
		    
	     <style>
    h4 { color: red; }
    h1 { color: white; }
  		</style>
  		
	</head>
	<body>
			<header class="panel-primary">
<div class="container-fluid panel-heading">
  <h1><center><img src="C:\java\proyectos\proyecto-limpio-spring\src\main\webapp\WEB-INF\vistas\Logo.jpg"/></center></h1>
   <div class="col-md-11"> <h4>${Nombre}</h4></div>  <div class="col-md-1"><a href="login"  class="btn btn-info btn-lg active" role="button">Salir</a></div>
</div>

</header>
<div class="row">
  <div class="col-md-4"></div>
<div class="col-md-4">		<br></br>
			
				<form:form action="ir_home_alumno" method="POST" modelAttribute="examen">
			    	
					
					<form:label path="nombre" id="nombre"  class="form-control">Examen: ${examen.nombre}</form:label>					
					<form:label path="nombre" id="nombre"   class="form-control">Porcentaje de respuestas correctas: ${nota} %</form:label>
					<form:label path="nombre" id="nombre"   class="form-control">Porcentaje requerido para aprobar: ${examen.umbral} %</form:label>
					
							
				<c:if test="${nota >= examen.umbral}">	
			      <h1>  <label id="nombre"  class="label label-success">Aprobado</label>	</h1>		     
		        </c:if>	
		        
		        <c:if test="${nota < examen.umbral}">			        
			     <h1>	<label  id="nombre" class="label label-danger"  >Desaprobado</label> </h1>			      	 
		        </c:if>	
								
				</form:form></div>
				
	 <div class="col-md-4"></div></div>	
	
		<!-- Footer -->	     

	                <div class="footer">
	                    <center><p>Copyright &copy; Proyecto Colmena 2018</p></center>
	                </div> 
	</body>
</html>
