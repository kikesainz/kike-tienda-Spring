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

	<h3>Insertar Peticiones</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/peticiones/insertarpeticiones"
				id="formulario" method="POST">
				<label>Nombre Cliente:</label><br>
				<select name="idCliente" id="idCliente" form="formulario">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosClientes}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
				</select><br>
				<br><label for="producto">Seleccionar producto:</label> <br>
				
				<select name="idProducto" id="producto">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosProductos}" var="productos">
						<option value="${productos.id}">${productos.nombre}</option>
					</c:forEach>
				</select><br>
				
				<br> <label for="cantidad">Cantidad:</label><br> <input type="number" id="cantidad" name="cantidad" value="1"> <br>
				
				<br><label for="estado">Estado:</label><br>
				<select name="idEstado" id="idEstado" form="formulario">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosEstados}" var="estado">
						<option value="${estado.id}">${estado.nombre}</option>
					</c:forEach>
				</select><br>
				<input type="submit" value="Insertar">
			</form>

		</div>
		<c:if test="${resultado == 1}">
			<p>Petición insertada correctamente</p>
		</c:if>
	</div>
</body>
</html>