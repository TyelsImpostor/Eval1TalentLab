<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
	<div>
		<form:form action="/usuario/crear" method="post" modelAttribute="usuario">
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
			
			<input type="submit" value="Crear Usuario">
		</form:form>
    		<br>
		<hr>
		<h1>Lista de Usuarios</h1>
		<hr>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Edad</th>
					<th>Correo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${lista_usuarios}" >
				<tr>
					<td><c:out value="${usuario.rut}" /></td>
					<td><c:out value="${usuario.nombre}" /> </td>
					<td><c:out value="${usuario.apellido}" /> </td>
					<td><c:out value="${usuario.edad}" /> </td>
					<td><c:out value="${usuario.correo}" /> </td>
					<td>
						<a href="/usuario/actualizar/${usuario.id}">Editar</a>
						<form action="/usuario/eliminar" method="POST">
							<input type="hidden" name="id" value="<c:out value="${usuario.id}" />"> 
							<input type="submit" value="Eliminar">
						</form>
					</td>
				</tr>
				</c:forEach>
			
			</tbody>
		</table>
	</div>
</body>
</html>