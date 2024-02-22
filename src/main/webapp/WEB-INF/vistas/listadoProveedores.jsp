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

		<h3>Listado Proveedores</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/proveedores/listarproveedores" id="formulario"
				method="POST">
				<label>ID Proveedor:</label> <input type="text" id="idProveedor" name="idProveedor"><br>
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre"><br>
				<label>Contacto:</label> <input type="text" id="contacto" name="contacto"><br>
				<label>Teléfono:</label> <input type="text" id="telefono" name="telefono"><br>
				<label>Correo Electrónico:</label> <input type="text" id="correoElectronico" name="correoElectronico"><br>
				<label>Dirección:</label> <input type="text" id="direccion" name="direccion"><br>
				<label for="activo">Activo</label>
				<input type="checkbox" id="activo" name="activo"><br>
				<input type="submit" value="Buscar">
			</form>

		</div>
		<c:if test="${not empty listaProveedores}">
			<table>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>CONTACTO</th>
					<th>TELÉFONO</th>
					<th>CORREO ELECTRÓNICO</th>
					<th>DIRECCIÓN</th>
					<th>ACTIVO</th>
				</tr>
				<c:forEach items="${listaProveedores}" var="proveedores">
					<tr>
						<td>${proveedores.idProveedor}</td>
						<td>${proveedores.nombre}</td>
						<td>${proveedores.contacto}</td>
						<td>${proveedores.telefono}</td>
						<td>${proveedores.correoElectronico}</td>
						<td>${proveedores.direccion}</td>
						<td>${proveedores.activo}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>




</body>
</html>
