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
	<%@include file="../menu.html"%>

		<h3>Listado Categorías</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/obtenercategorias"
				method="POST">
				<label>ID Categoría:</label> <input type="text" id="id" name="id"><br>
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre"><br>
				<label>Descripción:</label> <input type="text" id="descripcion" name="descripcion"><br>
				<label for="activo">Activo</label>
				<input type="checkbox" id="activo" name="activo"><br>
				<input type="submit" value="Buscar">
			</form>

		</div>
		<c:if test="${not empty listaCategorias}">
			<table>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>DESCRIPCION</th>
					<th>ACTIVO</th>
				</tr>
				<c:forEach items="${listaCategorias}" var="categoria">
					<tr>
						<td>${categoria.id}</td>
						<td>${categoria.nombre}</td>
						<td>${categoria.descripcion}</td>
						<td>${categoria.activo}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>




</body>
</html>
