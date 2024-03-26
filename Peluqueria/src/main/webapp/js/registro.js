$(document).ready(function() {
    $('#submit').click(function(event) {
        // Evitar que el formulario se envíe de forma tradicional
        event.preventDefault();

        // Obtener los datos del formulario
        var nombre = $('#nombre').val();
        var apellido = $('#apellido').val();
        var telefono = $('#telefono').val();
        var correo = $('#correo').val();
        var clave = $('#clave').val();

        // Crear un objeto con los datos del usuario
        var usuario = {
            nombre: nombre,
            apellido: apellido,
            telefono: telefono,
            correo: correo,
            clave: clave
        };

        // Hacer una solicitud AJAX para enviar los datos al servidor
        $.ajax({
            type: 'POST',
            url: 'RegistrarUsuarioServlet', // Ajustar la URL según la ruta de tu proyecto
            data: usuario,
            success: function(response) {
                // Manejar la respuesta del servidor aquí
                console.log(response);
                alert('Usuario registrado con éxito.');
            },
            error: function(xhr, status, error) {
                // Manejar errores de la solicitud AJAX aquí
                console.error(xhr.responseText);
                alert('Error al registrar el usuario. Por favor, inténtalo de nuevo.');
            }
        });
    });
});
