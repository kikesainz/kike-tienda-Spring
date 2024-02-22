<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
	<header>
		<h2>Panel de Control Tienda de Productos Informáticos</h2>
	</header>
	<%@include file="/menu.html"%>

		<h3>Listado Clientes</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/clientes/listarclientes" id="formulario"
				method="POST">
				<label>ID Cliente:</label> <input type="text" id="idClientes" name="idClientes"><br>
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre"><br>
				<label>Correo Electrónico:</label> <input type="text" id="correoElectronico" name="correoElectronico"><br>
				<label for="poblacion">Población:</label><br>
				<select name="idPoblacion" id="idPoblacion" form="formulario">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosPoblacion}" var="poblacion">
						<option value="${poblacion.id}">${poblacion.nombre}</option>
					</c:forEach>
				</select><br>
				<label for="activo">Activo</label>
				<input type="checkbox" id="activo" name="activo"><br>
				<input type="submit" value="Buscar">
			</form>

		</div>
		<c:if test="${not empty listaClientes}">
			<table>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>CORREO ELECTRÓNICO</th>
					<th>POBLACIÓN</th>
					<th>ACTIVO</th>
				</tr>
				<c:forEach items="${listaClientes}" var="clientes">
					<tr>
						<td>${clientes.idClientes}</td>
						<td>${clientes.nombre}</td>
						<td>${clientes.correoElectronico}</td>
						<td>${clientes.nombreMunicipio}</td>
						<td>${clientes.activo}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>




</body>
</html>
