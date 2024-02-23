<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
<title>Actualizar Categorías</title>
</head>
<body>
<h2>Panel de Control Tienda de Productos Informáticos</h2>
	
	<%@include file="../menu.html"%>

		<h3>Actualizar Proveedores</h3>
	<div class="container">
	<h3>Modificación de Proveedores</h3>
		<div class="form">
			<form action="http://localhost:8080/tienda/proveedores/formularioactualizarproveedores" id="formulario"
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
	<h3>Resultados de la búsqueda</h3>
		<c:forEach items="${listaProveedores}" var="proveedores">
			<div class="form">
			
			<form action="http://localhost:8080/tienda/proveedores/actualizarproveedores" id="formulario"
				method="POST">
				<label>ID Proveedor:</label> <input type="text" id="idProveedor" name="idProveedor" value="${proveedores.idProveedor}" readonly><br>
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre" value="${proveedores.nombre}"><br>
				<label>Contacto:</label> <input type="text" id="contacto" name="contacto" value="${proveedores.contacto}"><br>
				<label>Teléfono:</label> <input type="text" id="telefono" name="telefono" value="${proveedores.telefono}"><br>
				<label>Correo Electrónico:</label> <input type="text" id="correoElectronico" name="correoElectronico" value="${proveedores.correoElectronico}"><br>
				<label>Dirección:</label> <input type="text" id="direccion" name="direccion" value="${proveedores.direccion}"><br>
				<label for="activo">Activo</label>
				<c:if test="${proveedores.activo == 1}">
						<input type="checkbox" id="activo" name="activo"  checked>
					</c:if>
					<c:if test="${proveedores.activo == 0}">
						<input type="checkbox" id="activo" name="activo">
					</c:if>
				<input type="submit" value="Actualizar">
			</form>
			</div>
		</c:forEach>
	</div>

</body>
</html>