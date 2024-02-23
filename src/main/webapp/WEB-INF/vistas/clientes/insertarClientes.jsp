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
	<%@include file="../menu.html"%>

	<h3>Insertar Clientes</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/clientes/insertarclientes"
				id="formulario" method="POST">
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre"><br>
				<label>Correo Electrónico:</label> <input type="text"
					id="correoElectronico" name="correoElectronico"><br> 
				<label for="poblacion">Población:</label><br> 
				<select name="idPoblacion" id="idPoblacion" form="formulario">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosPoblacion}" var="poblacion">
						<option value="${poblacion.id}">${poblacion.nombre}</option>
					</c:forEach>
				</select><br>
				<label for="activo">Activo</label> 
				<input type="checkbox"id="activo" name="activo"><br> 
				<input type="submit" value="Insertar">
			</form>

		</div>
		<c:if test="${resultado == 1}">
			<p>Cliente insertado correctamente</p>
		</c:if>
	</div>
</body>
</html>