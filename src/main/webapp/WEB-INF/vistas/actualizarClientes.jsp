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
<title>Actualizar Clientes</title>
</head>
<body>
<header>
	<h2>Panel de Control Tienda de Productos Informáticos</h2>
	</header>
	<%@include file="/menu.html"%>

<h3>Actualizar Clientes</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/clientes/formularioactualizarclientes" id="formulario"
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

<h3>Resultados de la búsqueda</h3>
		<c:forEach items="${listaClientes}" var="clientes">
			<div class="form">
			
			<form action="http://localhost:8080/tienda/clientes/actualizarclientes"
				method="POST">
				<label>ID Cliente:</label> <input type="text" id="idClientes" name="idClientes" readonly value="${clientes.idClientes}"><br>
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre" value="${clientes.nombre}"><br>
				<label>Correo Electrónico:</label> <input type="text" id="correoElectronico" name="correoElectronico" value="${clientes.correoElectronico}"><br>
				<label for="poblacion">Población:</label><br>
				<select name="idPoblacion" id="idPoblacion">
					<c:forEach items="${combosPoblacion}" var="poblacion">
						<option value="${poblacion.id}">${poblacion.nombre}</option>
					</c:forEach>
					<option value="${clientes.idPoblacion}" selected>${clientes.nombreMunicipio}</option>
				</select><br>
				<label for="activo">Activo</label>
					<c:if test="${clientes.activo == 1}">
						<input type="checkbox" id="activo" name="activo"  checked>
					</c:if>
					<c:if test="${clientes.activo == 0}">
						<input type="checkbox" id="activo" name="activo">
					</c:if><br>
				<input type="submit" value="Modificar">
			</form>
				</div>
			</c:forEach>
	</div>
</body>
</html>