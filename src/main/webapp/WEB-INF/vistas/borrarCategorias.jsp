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

		<h3>Listado Categorías</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/formularioborrarcategorias"
				method="POST">
				<label>ID Categoría:</label> <input type="text" id="id" name="id"><br>
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre"><br>
				<label>Descripción:</label> <input type="text" id="descripcion" name="descripcion"><br>
				<label for="activo">Activo</label>
				<input type="checkbox" id="activo" name="activo"><br>
				<input type="submit" value="Buscar">
			</form>

		</div>
	<h3>Resultados de la búsqueda</h3>
		<c:forEach items="${listaCategorias}" var="categorias">
			<div class="form">
			
				<form action="http://localhost:8080/tienda/borrarcategorias" method="post">
					<label>ID Categoría:</label> <input type="text" id="id" name="id" value="${categorias.id}" readonly>
					<label>Nombre:</label> 
					<input type="text" id="nombre" name="nombre" value="${categorias.nombre}" readonly> 
					<label>Descripción:</label> 
					<input type="text" id="descripcion" name="descripcion" value="${categorias.descripcion}" readonly>
					<label for="activo">Activo</label>
					<c:if test="${categorias.activo == 1}">
						<input type="checkbox" id="activo" name="activo"  checked>
					</c:if>
					<c:if test="${categorias.activo == 0}">
						<input type="checkbox" id="activo" name="activo">
					</c:if>
				<input type="submit" value="Borrar">
				</form>
			</div>
		</c:forEach>
	</div>




</body>
</html>