<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" >
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>

<body>
<c:forEach items="${personas}" var="persona" >
<div>${persona.nombre}|  ${persona.apellido}<a href="borrar/${persona.nombre}"  class="btn btn-danger btn-sm active" role="button">Ver</a></div></br>
</c:forEach> 
<br/>
<a href="formulario2" class="btn btn-danger btn-lg active" role="button">Ingresar otra persona</a>
</body>
</html>