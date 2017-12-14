<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->	 	    
	     <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet">
	    	    	    	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>		 
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/funciones.js"></script> 
	</head> 
<body>

<header class="panel-primary">
<div class="container-fluid panel-heading">
   <h1><center><img src="${pageContext.request.contextPath}/img/Logo.jpg"/></center></h1>
   <div class="col-md-11"> <center><h2>Inscripcion a Cursos</h2></center></div>  
    <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>
</header>


<div class="contenedor">

<form:form method="GET" modelattribute="cursos"> 
	             
          <table class="table table-hover">
              <thead>
                <tr>
                	<c:if test="${empty cursos}">	  
                		 <th><h3>No hay Cursos Disponibles</h3></th>  
    				</c:if>
    				
    				<c:if test="${not empty cursos}">
    					<th><h3>Id</h3></th>	  
                		<th><h3>Curso</h3></th>  
                		<th><h3>Alumnos Inscriptos</h3></th>
                		<th><h3>Alumnos Permitidos</h3></th>
                		<th><h3>Disponibilidad</h3></th>                		
                		<th><h3>Examenes Permitidos</h3></th>
                		<th><h3>Examenes Creados</h3></th>
    				</c:if>                   
                                  
                  
                </tr>
              </thead>
              <tbody>
	              <c:forEach items= "${cursos}" var="curso">              
	                <tr>	
	                <td><h4>${curso.id}</h4></td>	              
	                  <td><h4>${curso.nombre}</h4></td>	
	                   <td><h4>${curso.cantidadAlumnos}</h4></td>
	                   <td><h4>${curso.maximoAlumnos}</h4></td>	                	                 
	                    <c:if test="${curso.cantidadAlumnos>=curso.maximoAlumnos}">	  
                		   <td>	<h4>Curso lleno</h4>    </td>           		
    					</c:if>     					
	    				<c:if test="${curso.cantidadAlumnos<curso.maximoAlumnos}">	
	    				 	<td><h4>Con Vacantes</h4>    				 	
	    				 	</td>                		 
	    				</c:if> 
    				 
    				 <td><h4>${curso.cantidadExamen}</h4></td>
    				 <td><h4>${fn:length(curso.examen)}</h4></td>
	               	                 
	                </tr> 
	              </c:forEach>               
              </tbody>
            </table>
	   
</form:form>


 </div>	 

<!-- Footer -->	     

	                <div class="footer">
	                    <center><p><h6>Copyright &copy; Proyecto Colmena 2018</h6></p></center>
	                </div> 
	</body>
</html>