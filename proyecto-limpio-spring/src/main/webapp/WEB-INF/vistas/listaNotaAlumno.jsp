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
	    <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet">
	    	    	    	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>		 
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/funciones.js"></script> 
	</head>  
<body>

<header class="panel-primary">
<div class="container-fluid panel-heading">
   <h1><center><img src="${pageContext.request.contextPath}/img/Logo.jpg"/></center></h1>
   <div class="col-md-11"> <center><h2>Listado de Notas del Curso ${Curso.nombre}</h2></center></div> 
   <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>
</header>

<br>
<br>

<div class="contenedor">

<form:form method="GET" modelAttribute="Curso" > 
	    
          
          <table class="table table-hover">
              <thead>
                <tr>
                	<c:if test="${empty Curso.examen}">	  
                		 <th><h3>No hay Notas Disponibles</h3></th>  
                		     
    				</c:if>
    				<c:if test="${not empty Curso.examen}">
    					<th><h3>Id</h3></th> 	  
                		<th><h3>Nombre Examen</h3></th> 
                		<th><h3>Tipo</h3></th> 
                		<th><h3>Fecha Nota</h3></th>                		
                		<th><h3>Calificacion</h3></th>
                		<th><h3>Estado</h3></th>
    				</c:if>  
                </tr>
              </thead>
              <tbody>
	              <c:forEach items= "${Curso.examen}" var="examen">              
	                <tr>	
	                 <td><h4>${examen.id}</h4></td>              
	                  <td><h4>${examen.nombre}</h4></td>	
	                   <td><h4>${examen.tipo}</h4></td>
	                  
                		 <c:forEach items= "${examen.nota}" var="nota">                 		 
                		 	<td><h4>${nota.fecha}</h4></td>
	                  		<td><h4>${nota.calificacion}</h4></td>  
	                  		
	                  		<td>
				                <c:if test="${nota.calificacion >= examen.umbral}">	
								      <div class="panel panel-success"><div class="panel-heading"><center>Aprobado</center></div></div>		     
							        </c:if>	
							        
							        <c:if test="${nota.calificacion < examen.umbral}">			        
								    <div class="panel panel-danger"><div class="panel-heading"><center>Desaprobado</center></div></div>			      	 
							        </c:if>					                
			                 </td>   
			                               		 
                		 </c:forEach> 
                		     
    				
	                
	                   	      
	                </tr> 
	              </c:forEach>               
              </tbody>
            </table>
	   
</form:form>


 </div>	 
 
 <c:if test="${not empty mensageErr}">
			       ${mensageErr}			        
</c:if>	

<!-- Footer -->	     

	                <div class="footer">
	                    <center><p><h6>Copyright &copy; Proyecto Colmena 2018</h6></p></center>
	                </div>
</body>
</html>