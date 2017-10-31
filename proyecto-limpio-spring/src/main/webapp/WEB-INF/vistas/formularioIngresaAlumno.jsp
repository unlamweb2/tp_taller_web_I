<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Docente</title>
</head>
<body>
<form:form action="guardarAlumno.html" method="POST" modelAttribute="alumno"> 
	<form:label path="nombre">Nombre </form:label>
	<form:input path="nombre"/><br><br>
	
	<form:label path="apellido">Apellido </form:label>
	<form:input path="apellido"/>
	
	<form:label path="password">Contraseña </form:label>
	<form:input path="password"/>
	
	<form:label path="email">Email </form:label>
	<form:input path="email"/>
	
	<input type="submit" value="Guardar"/>

</form:form>
</body>
</html> 