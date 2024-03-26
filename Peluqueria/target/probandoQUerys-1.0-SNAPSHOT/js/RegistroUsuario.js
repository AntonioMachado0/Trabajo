$(document).ready(function() {
    // Selector para el formulario de registro
    var form = $('#registro');
    var tablaUsuarios = $('#tablaUsuarios');

    // Función para manejar el envío del formulario
    form.submit(function(event) {
        // Evita que el formulario se envíe de forma tradicional
        event.preventDefault();

        // Obtener los datos del formulario
        var nombre = $('#nombre').val();
        var apellido = $('#apellido').val();
        var dui = $('#dui').val();
        var telefono = $('#telefono').val();
        var correo = $('#correo').val();
        var direccion = $('#direccion').val();
        var estado = $('#estado').val();
        var cargo = $('#cargo').val();

        // Crear un objeto con los datos del usuario
        var usuario = {
            nombre: nombre,
            apellido: apellido,
            dui: dui,
            telefono: telefono,
            correo: correo,
            direccion: direccion,
            estado: estado,
            cargo: cargo
        };

        // Hacer una solicitud AJAX para registrar el usuario
        $.ajax({
            type: 'POST',
            url: 'RegistrarUsuarioServlet', // Ajustar la URL según la ruta de tu proyecto
            data: usuario,
            success: function(response) {
                // Manejar la respuesta del servidor aquí
                console.log(response);
                alert('Usuario registrado con éxito.');

                // Limpiar el formulario después de registrar el usuario
                form.trigger('reset');

                // Mostrar la tabla actualizada de usuarios
                mostrarTablaUsuarios();
            },
            error: function(xhr, status, error) {
                // Manejar errores de la solicitud AJAX aquí
                console.error(xhr.responseText);
                alert('Error al registrar el usuario. Por favor, inténtalo de nuevo.');
            }
        });
    });

    // Función para mostrar la tabla de usuarios
    function mostrarTablaUsuarios() {
        // Hacer una solicitud AJAX para obtener la lista de usuarios
        $.ajax({
            type: 'GET',
            url: 'ObtenerUsuariosServlet', // Ajustar la URL según la ruta de tu proyecto
            success: function(response) {
                // Limpiar la tabla de usuarios
                tablaUsuarios.empty();

                // Agregar encabezados de la tabla
                tablaUsuarios.append('<tr><th>Nombre</th><th>Apellido</th><th>DUI</th><th>Teléfono</th><th>Correo</th><th>Dirección</th><th>Estado</th><th>Cargo</th></tr>');

                // Agregar filas de usuarios
                response.forEach(function(usuario) {
                    tablaUsuarios.append('<tr><td>' + usuario.nombre + '</td><td>' + usuario.apellido + '</td><td>' + usuario.dui + '</td><td>' + usuario.telefono + '</td><td>' + usuario.correo + '</td><td>' + usuario.direccion + '</td><td>' + usuario.estado + '</td><td>' + usuario.cargo + '</td></tr>');
                });
            },
            error: function(xhr, status, error) {
                // Manejar errores de la solicitud AJAX aquí
                console.error(xhr.responseText);
                alert('Error al obtener la lista de usuarios.');
            }
        });
    }

    // Mostrar la tabla de usuarios al cargar la página
    mostrarTablaUsuarios();
});

