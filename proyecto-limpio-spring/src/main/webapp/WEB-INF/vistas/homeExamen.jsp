<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="css/bootstrap.min.css" rel="stylesheet" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 class="page-header text-center titulo">${Examen.nombre}</h1>
<form:form action="corregir-examen.html" method="POST" modelAttribute="Examen">
<c:forEach items= "${Examen.preguntas}" var="pregunta" >

<div>${pregunta.nombre}</div>

	<c:forEach items= "${pregunta.respuestas}" var="respuesta" >
				
		<div class="divClass">
          <input type="checkbox" name="Respuesta" value="${pregunta.respuestas}" id="${pregunta.id}">
        <label for="id1">${respuesta.nombre}</label>
   </div>
    
</c:forEach> 

 
</c:forEach> 
<input type="submit" value="Enviar"/>
</form:form>
<br/>
</body>
</html>