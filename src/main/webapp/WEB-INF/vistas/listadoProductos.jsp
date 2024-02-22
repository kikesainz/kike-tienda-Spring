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

<h3>Listado Productos</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/listarproductos" id="formulario" method="POST">
				<label>ID Producto:</label> <input type="text" id="idProducto" name="idProducto"><br>
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre"><br>
				<label>Descripción:</label> <input type="text" id="descripcion" name="descripcion"><br>
				<label>Precio:</label> <input type="text" id="precio" name="precio"><br>
				<label>Cantidad en stock:</label> <input type="text" id="cantidadStock" name="cantidadStock"><br>
				<label for="categoria">Categoría:</label><br>
				<select name="idCategroria" id="idCategroria" form="formulario">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosCategorias}" var="categoria">
						<option value="${categoria.id}">${categoria.nombre}</option>
					</c:forEach>
				</select><br>
				<label for="proveedores">Proveedores:</label><br>
				<select name="idProveedor" id="idProveedor" form="formulario">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosProveedores}" var="proveedores">
						<option value="${proveedores.id}">${proveedores.nombre}</option>
					</c:forEach>
				</select><br>
				<input type="submit" value="Buscar">
			</form>

		</div>
		<c:if test="${not empty listaProductos}">
			<table>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>CANTIDAD EN STOCK</th>
					<th>CATEGORIA</th>
					<th>PROVEEDOR</th>
				</tr>
				<c:forEach items="${listaProductos}" var="productos">
					<tr>
						<td>${productos.id}</td>
						<td>${productos.nombre}</td>
						<td>${productos.descripcion}</td>
						<td>${productos.precio}</td>
						<td>${productos.cantidadStock}</td>
						<td>${productos.nombreCategoria}</td>
						<td>${productos.nombreProveedor}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>




</body>
</html>