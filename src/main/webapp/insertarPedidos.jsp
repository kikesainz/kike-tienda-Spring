<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
<title>Carrito de Compras</title>
</head>

<body>
	<h1>Carrito de Compras</h1>

    <label for="cliente">Seleccionar cliente:</label>
    <select id="cliente">
		<option value="" disabled selected>Seleccione una opción</option>
		<option value="1">Pepe</option>
        <option value="2">Juanita</option>
        <option value="3">Pepita</option>
    </select>

    <br><br>

    <label for="producto">Seleccionar producto:</label>
    <select id="producto">
		<option value="" disabled selected>Seleccione una opción</option>
        <option value="1">Teclado</option>
        <option value="2">Procesador</option>
        <option value="3">ratón</option>
    </select>

    <br><br>

    <label for="cantidad">Cantidad:</label>
    <input type="number" id="cantidad" value="1">

    <br><br>
        <label for="precio">Precio:</label>
    <input type="number" id="precio" >
   <br><br>
    <button onclick="agregarAlCarrito()">Agregar al carrito</button>
    <button onclick="realizarVenta()">Realizar Venta</button>

    <h2>Carrito</h2>
    <ul id="listaCarrito">
    </ul>

 <script src="js/scripts.js"></script>
</body>
</html>