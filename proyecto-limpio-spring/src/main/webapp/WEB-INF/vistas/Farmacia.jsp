<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
			
	 <h3>Farmacia</h3> 
	 		<c:forEach items="${command}" var="listaFarmacia" >
	 		${listaFarmacia.nombre} 
	 		</c:forEach>		  						

	</body>
</html>
