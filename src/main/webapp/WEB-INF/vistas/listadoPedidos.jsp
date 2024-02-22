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

		<h3>Listado Pedidos</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/pedidos/listarpedidos" id="formulario"
				method="POST">
				<label>ID Pedido:</label> <input type="text" id="idPedido" name="idPedido"><br>
				<label>Nombre Cliente:</label>
				<select name="idCliente" id="idCliente" form="formulario">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosClientes}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
				</select><br>
				
				<label>Fecha Pedido:</label> <input type="date" id="fechaPedido" name="fechaPedido"><br>
				<label for="estado">Estado:</label><br>
				<select name="idEstado" id="idEstado" form="formulario">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosEstados}" var="estado">
						<option value="${estado.id}">${estado.nombre}</option>
					</c:forEach>
				</select><br>
				<input type="submit" value="Buscar">
			</form>

		</div>
		<c:if test="${not empty listaPedidos}">
			<table>
				<tr>
					<th>ID PEDIDO</th>
					<th>NOMBRE CLIENTE</th>
					<th>NOMBRE PRODUCTO</th>
					<th>CANTIDAD</th>
					<th>PRECIO</th>
				</tr>
				<c:forEach items="${listaPedidos}" var="pedidos">
					<tr>
						<td>${pedidos.idPedido}</td>
						<td>${pedidos.nombreCliente}</td>
						<td>${pedidos.nombreProducto}</td>
						<td>${pedidos.cantidad}</td>
						<td>${pedidos.precio}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>




</body>
</html>
