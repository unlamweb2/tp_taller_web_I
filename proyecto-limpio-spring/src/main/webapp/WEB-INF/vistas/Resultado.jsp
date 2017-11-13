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
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			
				<form:form action="ir_home_alumno" method="POST" modelAttribute="examen">
			    	<h1 class="page-header text-center titulo">COLMENA</h1>
					<hr class="colorgraph"><br>
					
					<form:label path="nombre" id="nombre"  class="form-control">Examen: ${examen.nombre}</form:label>					
					<form:label path="nombre" id="nombre"   class="form-control">Porcentaje de respuestas correctas: ${nota} %</form:label>
					<form:label path="nombre" id="nombre"   class="form-control">Porcentaje requerido para aprobar: ${examen.umbral} %</form:label>
					
							
				<c:if test="${nota >= examen.umbral}">	
			      <h1>  <label id="nombre"  class="label label-success">Usted a Aprobado</label>	</h1>		     
		        </c:if>	
		        
		        <c:if test="${nota < examen.umbral}">			        
			     <h1>	<label  id="nombre" class="label label-danger"  >Usted a Desaprobado</label> </h1>			      	 
		        </c:if>	
								
				</form:form>
				
			</div>
		</div>
		
	
		<!-- Footer -->	     

	                <div class="footer">
	                    <center><p>Copyright &copy; Proyecto Colmena 2018</p></center>
	                </div> 
	</body>
</html>
