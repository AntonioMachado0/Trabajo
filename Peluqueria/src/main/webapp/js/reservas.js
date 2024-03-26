$(document).ready(function(){
    $.ajax({
        url: "./ReservasConsul",
        dataType: 'json',
        type: 'GET',
        cache: false,
        success: function(data){
            console.log("Datos recibidos:", data);

            if (data && Array.isArray(data) && data.length > 0) {
                var event_data = '';
                for (let value of data) {
                    event_data += '<tr>'; 
                    event_data += '<td>' + value.id + '</td>'; 
                    event_data += '<td>' + value.fecha + '</td>'; 
                    event_data += '<td>' + value.hora + '</td>'; 
                    event_data += '<td>' + value.nombre_cliente + '</td>'; 
                    event_data += '<td>' + value.tipocorte + '</td>'; 
                    event_data += '</tr>';
                }
                $("#list_table_json").html(event_data);
            } else {
                console.error("Error al procesar los datos: La respuesta no es un array válido o está vacía.");
            }
        },
        error: function(){
            console.error("Error en la solicitud AJAX.");
            alert("404 espere hasta que se cargue el archivo");
        }
    });
});
