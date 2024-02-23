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

		<h3>Listado Peticiones</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/peticiones/listarpeticiones" id="formulario"
				method="POST">
				<label>ID Petición:</label><br> <input type="text" id="idPeticion" name="idPeticion"><br>
				<br><label>Nombre Cliente:</label><br>
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
				
				<br><label>Fecha Pedido:</label><br> <input type="date" id="fechaPedido" name="fechaPedido"><br>

				<input type="submit" value="Buscar">
			</form>

		</div>
		<c:if test="${not empty listaPeticiones}">
		<h3>Resultado de la Búsqueda</h3>
			<table>
				<tr>
					<th>ID Petición</th>
					<th>Cliente</th>
					<th>Producto</th>
					<th>Fecha Petición</th>
				</tr>
				<c:forEach items="${listaPeticiones}" var="peticiones">
					<tr>
						<td>${peticiones.idPeticion}</td>
						<td>${peticiones.nombreCliente}</td>
						<td>${peticiones.nombreProducto}</td>
						<td>${peticiones.fechaPedido}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>




</body>
</html>
