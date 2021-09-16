<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Venta</title>
</head>
<body>
	<div>
		<form:form action="/venta/modificar" method="post" modelAttribute="venta">
			<input type="hidden" name="_method" value="put">
			<form:label path="id">id:</form:label>
			<form:input type="text" path="id"/><br>
			
			<form:label path="cantidad">cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br>
			
			<form:label path="total">total:</form:label>
			<form:input type="text" path="total"/><br>
			
			<form:label path="descripcion">descripcion:</form:label>
			<form:input type="text" path="descripcion"/><br>
			
			<input type="submit" value="Editar Venta">
		</form:form>
	</div>
</body>
</html>