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
<title>Actualizar Productos</title>
</head>
<body>
<header>
	<h2>Panel de Control Tienda de Productos Informáticos</h2>
	</header>
	<%@include file="/menu.html"%>

<h3>Listado Productos</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/formularioactualizarproductos" id="formulario" method="POST">
				<label>ID Producto:</label> <input type="text" id="idProducto" name="idProducto"><br>
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre"><br>
				<label>Descripción:</label> <input type="text" id="descripcion" name="descripcion"><br>
				<label>Precio:</label> <input type="text" id="precio" name="precio"><br>
				<label>Cantidad en stock:</label> <input type="text" id="cantidadStock" name="cantidadStock"><br>
				<label for="categoria">Categoría:</label><br>
				<select name="idCategoria" id="idCategoria" form="formulario">
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

<h3>Resultados de la búsqueda</h3>
		<c:forEach items="${listaProductos}" var="productos">
			<div class="form">
			
				<form action="http://localhost:8080/tienda/actualizarproductos" method="post">
					<label>ID Producto:</label> <input type="text" id="idProducto" name="idProducto" value="${productos.id}"><br>
					<label>Nombre:</label> <input type="text" id="nombre" name="nombre" value="${productos.nombre}"><br>
					<label>Descripción:</label> <input type="text" id="descripcion" name="descripcion" value="${productos.descripcion}"><br>
					<label>Precio:</label> <input type="text" id="precio" name="precio" value="${productos.precio}"><br>
					<label>Cantidad en stock:</label> <input type="text" id="cantidadStock" name="cantidadStock" value="${productos.cantidadStock}"><br>
					<label for="idCategoria">Categoría:</label><br>
					<select name="idCategoria" id="idCategoria">
						<c:forEach items="${combosCategorias}" var="categoria">
							<option value="${categoria.id}">${categoria.nombre}</option>
						</c:forEach>
							<option value="${productos.idCategroria}" selected>${productos.nombreCategoria}</option>
					</select><br>
					<label for="idProveedor">Proveedores:</label><br>
					<select name="idProveedor" id="idProveedor">
						<c:forEach items="${combosProveedores}" var="proveedores">
							<option value="${proveedores.id}">${proveedores.nombre}</option>
						</c:forEach>
							<option value="${productos.idProveedor}" selected>${productos.nombreProveedor}</option> 
					</select><br>
					<input type="submit" value="Modificar">
					</form>
				</div>
			</c:forEach>
	</div>
</body>
</html>