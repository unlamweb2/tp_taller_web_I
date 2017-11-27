<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<h1>Anotate ${Alumno.nombre}</h1>

<form:form action="inscribirAlumno" method="POST" modelAttribute="Chorizo">

<input type="hidden" name="idAlumno" value="${Alumno.id}"/>
<c:forEach items= "${Chorizo}" var="curso" ><br></br>

<input type="checkbox" name="idCurso" value="${curso.id}" > ${curso.nombre}

</c:forEach> 
<input type="submit" class="btn btn-lg btn-danger btn-block" value="Anotarse"/>
</form:form>
</body>
</html>

<!-- ESTO MUESTRA BIEN!!! Los id tambien -->
 <!-- <h1>Anotate ${Alumno.id}</h1>
<c:forEach items= "${Materias}" var="cursos" >
<br></br>
${cursos.id}
</c:forEach> -->

