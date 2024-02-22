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

		<h3>Actualizar Pedidos</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/pedidos/formularioactualizarpedidos" id="formulario"
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
		<h3>Resultados de la búsqueda</h3>
		<c:forEach items="${listaPedidos}" var="pedidos">
			<div class="form">
			
			<form action="http://localhost:8080/tienda/pedidos/actualizarpedidos"
				method="POST">
				<label>ID Pedido:</label> <input type="text" id="idPedido" name="idPedido" value="${pedidos.idPedido}" readonly><br>
				<label>ID Detalle:</label> <input type="text" id="idDetallePedido" name="idDetallePedido" value="${pedidos.idPedido}" readonly><br>
				
				<label>Cliente:</label>
				<select name="idCliente" id="idCliente">
					<c:forEach items="${combosClientes}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
					<option value="${pedidos.idCliente}" selected>${pedidos.nombreCliente}</option>
				</select><br>
				<label>Producto:</label> 
				<select name="idProducto" id="idProducto">
					<c:forEach items="${combosProductos}" var="productos">
						<option value="${productos.id}">${productos.nombre}</option>
					</c:forEach>
					<option value="${pedidos.idProducto}" selected>${pedidos.nombreProducto}</option>
				</select><br>
				<label>Cantidad:</label> <input type="number" id="cantidad" name="cantidad" value="${pedidos.cantidad}"><br>
				<label>Precio:</label> <input type="number" id="precio" name="precio" value="${pedidos.precio}"><br>
				<input type="submit" value="Modificar">
			</form>
				</div>
			</c:forEach>
	</div>




</body>
</html>
