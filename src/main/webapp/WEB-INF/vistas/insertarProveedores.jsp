<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
<title>Insertar Categorias</title>
</head>
<body>
	<header>
		<h2>Panel de Control Tienda de Productos Informáticos</h2>
	</header>
	<%@include file="/menu.html"%>

	<h3>Insertar Proveedores</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/proveedores/insertarproveedores" id="formulario"
				method="POST">
				<label>ID Proveedor:</label> <input type="text" id="idProveedor" name="idProveedor"><br>
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre"><br>
				<label>Contacto:</label> <input type="text" id="contacto" name="contacto"><br>
				<label>Teléfono:</label> <input type="text" id="telefono" name="telefono"><br>
				<label>Correo Electrónico:</label> <input type="text" id="correoElectronico" name="correoElectronico"><br>
				<label>Dirección:</label> <input type="text" id="direccion" name="direccion"><br>
				<label for="activo">Activo</label>
				<input type="checkbox" id="activo" name="activo"><br>
				<input type="submit" value="Insertar">
			</form>

		</div>
		<c:if test="${resultado == 1}">
			<p>Proveedor insertado correctamente</p>
		</c:if>
	</div>
</body>
</html>