<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items= "${ListadoPreguntas}" var="pregunta" >

<div>${pregunta.descripcion}</div>

<div class="myDiv">
    <div class="divClass">
           <input type="checkbox" name="someData" value="0" id="id1">
        <label for="id1">${pregunta.rtaCorrecta}</label>
    </div>
    <div class="divClass">
        <input type="checkbox" name="someData" value="1" id="id2">
        <label for="id2">${pregunta.rtaIncorrecta1}</label>
    </div>
    <div class="divClass">
        <input type="checkbox" name="someData" value="2" id="id3">
            <label for="id3">${pregunta.rtaIncorrecta2}</label>
    </div>
    </br>
</div>



</c:forEach> 
<br/>
</body>
</html>