<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
</head>
<body>
	<div>
		<form:form action="/venta/crear" method="post" modelAttribute="venta">
			<form:label path="cantidad">cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br>
			
			<form:label path="total">total:</form:label>
			<form:input type="text" path="total"/><br>
			
			<form:label path="descripcion">descripcion:</form:label>
			<form:input type="text" path="descripcion"/><br>
			
			<input type="submit" value="Crear Venta">
		</form:form>
    		<br>
		<hr>
		<h1>Lista de Ventas</h1>
		<hr>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Cantidad</th>
					<th>Total</th>
					<th>Descripcion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="venta" items="${lista_ventas}" >
				<tr>
					<td><c:out value="${venta.cantidad}" /></td>
					<td><c:out value="${venta.total}" /> </td>
					<td><c:out value="${venta.descripcion}" /> </td>
					<td>
						<a href="/venta/actualizar/${venta.id}">Editar</a>
						<form action="/venta/eliminar" method="POST">
							<input type="hidden" name="id" value="<c:out value="${venta.id}" />"> 
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