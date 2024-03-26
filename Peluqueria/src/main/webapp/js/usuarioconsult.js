$(document).ready(function(){
    $.ajax({
        url: "./usuariosCargos", // Ruta del servlet que maneja la solicitud
        dataType: 'json',
        type: 'get',
        cache: false,
        success: function(data){
            console.log(data);
            var event_data = '';

            // Itera sobre los datos recibidos
            for(let usuarioCargo of data){
                event_data += '<tr>'; 
                event_data += '<td>' + usuarioCargo.nombre + '</td>';
                event_data += '<td>' + usuarioCargo.apellido + '</td>'; 
                event_data += '<td>' + usuarioCargo.dui + '</td>'; 
                event_data += '<td>' + usuarioCargo.telefono + '</td>'; 
                event_data += '<td>' + usuarioCargo.estado + '</td>'; 
                event_data += '<td>' + usuarioCargo.cargo + '</td>'; 
                event_data += '</tr>'; 
            }

            // Agrega los datos a la tabla
            $("#list_table_json").append(event_data);
        },
        error: function(){
            console.log("error");
            alert("404 espere hasta que se cargue el archivo");
        }
    });
});


