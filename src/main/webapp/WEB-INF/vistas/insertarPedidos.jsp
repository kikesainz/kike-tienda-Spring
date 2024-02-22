<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
<title>Carrito de Compras</title>
</head>

<body>
	<header>
		<h2>Panel de Control Tienda de Productos Informáticos</h2>
	</header>
	<%@include file="/menu.html"%>
	<h1 class="carrito">Carrito de Compras</h1>
	<div class="container">
		<div class="form">

				<label for="cliente">Seleccionar cliente:</label> 
				<select name="idCliente" id="cliente" form="formulario">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${combosClientes}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
				</select><br>
				<br>
				<label for="producto">Seleccionar producto:</label> 
				
				<select name="idProducto" id="producto">
					<c:forEach items="${combosProductos}" var="productos">
						<option value="${productos.id}">${productos.nombre}</option>
					</c:forEach>
					<option value="${pedidos.idProducto}" selected>${pedidos.nombreProducto}</option>
				</select><br>
				
				
				<br> <label for="cantidad">Cantidad:</label> <input type="number" id="cantidad" value="1"> <br>
				<br> <label for="precio">Precio:</label> <input type="number" id="precio"> <br>
				<br>
			
				<button onclick="realizarVenta()">Realizar Venta</button>
					<button onclick="agregarAlCarrito()">Agregar al carrito</button>
	
		<c:if test="${resultado >= 1}">
			<p>Pedido realizado correctamente</p>
		</c:if>		

		</div>

		<h2>Carrito</h2>
		<ul id="listaCarrito">
		</ul>

		<script src="http://localhost:8080/tienda/js/scripts.js"></script>
</body>
</html>