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
<title>Actualizar Clientes</title>
</head>
<body>
<header>
	<h2>Panel de Control Tienda de Productos Informáticos</h2>
	</header>
	<%@include file="../menu.html"%>

<h3>Actualizar Peticiones</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/peticiones/formularioactualizarpeticiones" id="formulario"
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
				
				<select name="idProducto" id="producto" form="formulario">
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
		<c:if test="${resultado == 1}">
			<p>Petición modificada correctamente</p>
		</c:if>
		</div>

<h3>Resultados de la búsqueda</h3>
		<c:forEach items="${listaPeticiones}" var="peticiones">
			<div class="form">
			
			<form action="http://localhost:8080/tienda/peticiones/actualizarpeticiones"
				method="POST">
				<label>ID Petición:</label><br> <input type="text" id="idPeticion" name="idPeticion" readonly value="${peticiones.idPeticion}"><br>
				<br><label>Nombre Cliente:</label><br>
				<select name="idCliente" id="idCliente">
					<c:forEach items="${combosClientes}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
					<option value="${peticiones.idCliente}" selected>${peticiones.nombreCliente}</option>
				</select><br>
				
				<br><label for="producto">Seleccionar producto:</label> <br>
				
				<select name="idProducto" id="idProducto">
					<c:forEach items="${combosProductos}" var="productos">
						<option value="${productos.id}">${productos.nombre}</option>
					</c:forEach>
					<option value="${peticiones.idProducto}" selected>${peticiones.nombreProducto}</option>
				</select><br>
				
				<br> <label for="cantidad">Cantidad:</label><br> <input type="number" id="cantidad" name="cantidad" value="1"> <br>
				
				<br><label for="estado">Estado:</label><br>
				<select name="idEstado" id="idEstado">
					<c:forEach items="${combosEstados}" var="estado">
						<option value="${estado.id}">${estado.nombre}</option>
					</c:forEach>
					<option value="${peticiones.idEstado}" selected>${peticiones.estado}</option>
				</select><br>
				
				<br><label>Fecha Pedido:</label><br> <input type="date" id="fechaPedido" name="fechaPedido" value="${peticiones.fechaPedido}"><br>
				
				<input type="submit" value="Modificar">
			</form>

				</div>
			</c:forEach>
	</div>
</body>
</html>