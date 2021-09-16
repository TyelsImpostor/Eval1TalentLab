<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Usuario</title>
</head>
<body>
	<div>
		<form:form action="/usuario/modificar" method="post" modelAttribute="usuario">
			<input type="hidden" name="_method" value="put">
			<form:input type="hidden" path="id"/><br>
			
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="apellido">apellido:</form:label>
			<form:input type="text" path="apellido"/><br>
			
			<form:label path="edad">edad:</form:label>
			<form:input type="text" path="edad"/><br>
			
			<form:label path="correo">correo:</form:label>
			<form:input type="text" path="correo"/><br>
			
			<input type="submit" value="Editar Venta">
		</form:form>
	</div>
</body>
</html>