<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%@include file="/menu.html"%>

		<h3>Listado Categorías</h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/insertarcategorias"
				method="POST">
				<label>Nombre:</label> <input type="text" id="nombre" name="nombre"><br>
				<label>Descripción:</label> <input type="text" id="descripcion" name="descripcion"><br>
				<label for="activo">Activo</label>
				<input type="checkbox" id="activo" name="activo"><br>
				<input type="submit" value="Insertar">
			</form>

		</div>

	</div>
</body>
</html>