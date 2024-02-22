
/*Código para el cálculo del precio */

//Añadimos listener a los combos 
document.getElementById('cliente').addEventListener('change', calculaPrecio);
document.getElementById('producto').addEventListener('change', calculaPrecio);

function hola(){
	
	console.log ("hola")
}
function calculaPrecio() {

	var cliente = document.getElementById('cliente').value;
	var producto = document.getElementById('producto').value;

	// Crear un objeto con los datos
	var datos = {
		cliente: cliente,
		producto: producto
	};
	if (cliente === "" || producto === "" ) {		
		return; // Detiene la función si algún campo está vacío
	}
	// Realizar una petición POST
	fetch('http://localhost:8080/tienda/pedidos/calculaprecio', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(datos) // Convertir los datos a una cadena JSON
	})
		.then(response => response.text()) // o response.json() si la respuesta es JSON
		.then(data => {
			// Actualizar el input con el resultado
			document.getElementById('precio').value = data;
		})
		.catch(error => console.error('Error:', error));
}

/* Código carrito e insert de pedido */
let carrito = [];

function agregarAlCarrito() {
	
	const clienteSeleccionado = document.getElementById('cliente');
	const clienteID = clienteSeleccionado.value;
	const clienteNombre = clienteSeleccionado.options[clienteSeleccionado.selectedIndex].text;

	const productoSeleccionado = document.getElementById('producto');
	const productoID = productoSeleccionado.value;
	const productoNombre = productoSeleccionado.options[productoSeleccionado.selectedIndex].text;

	const cantidad = parseInt(document.getElementById('cantidad').value);

	const precio = parseFloat(document.getElementById('precio').value);

	const cantidadPagar = (precio * cantidad);
	
	 console.log("Valor del input: ", cantidadPagar);
//Comprobamos que todos los campos tienen valor
	if (clienteID === "" || productoSeleccionado === "" || isNaN(precio)) {
		alert("Por favor, seleccione una opción en todos los campos.");
		return; // Detiene la función si algún campo está vacío
	}
	const itemCarrito = {
		clienteID,
		clienteNombre,
		precio,
		productoID,
		productoNombre,
		cantidad,
		cantidadPagar
	};

	carrito.push(itemCarrito);
	actualizarCarrito();
	return;
}

function actualizarCarrito() {
	const listaCarrito = document.getElementById('listaCarrito');
	listaCarrito.innerHTML = "";

	carrito.forEach((item, index) => {
		const li = document.createElement('li');
		li.textContent = `${item.clienteNombre} - ${item.productoNombre} - ${item.cantidad} - ${item.cantidadPagar}`;
		listaCarrito.appendChild(li);
	});
}

function realizarVenta() {
	fetch('http://localhost:8080/tienda/pedidos/dopedido', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(carrito)
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('La respuesta del servidor no fue exitosa: ' + response.status);
				alert('La respuesta del servidor no fue exitosa: ' + response.status);
			}
			return response.text();
		})
		.then(data => {
		
			if (data === "OK") {
				console.log("Operación exitosa.");
				alert('Pedido realizado con éxito ');
				// Aquí puedes realizar acciones adicionales en caso de éxito
			} else {
				console.log("Respuesta no esperada del servidor: ", data);
				// Manejar otras respuestas
				alert('La respuesta del servidor no fue exitosa: ' + response.status);
			}
		})
		.catch(error => console.error('Error:', error));
}