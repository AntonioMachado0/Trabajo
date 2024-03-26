/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

$(document).ready(function(){
    $.ajax({
        url:"./Reserva",
        dataType:'json',
        type:'get',
        cache:false,
        success: function(data){
            console.log(data);
            var event_data = '';
            
    for(let pan of data){
        event_data += '<tr>'; 
                event_data += '<td>' + pan.cliente.nombre + '</td>'; 
                event_data += '<td>' + pan.cliente.correo + '</td>'; 
                event_data += '<td>' + pan.estado + '</td>'; 
               event_data += '<tr>'; 
    }

            console.log(data);
            $("#list_table_json").append(event_data);
        },error:function(d){
            console.log("error");
            alert("404 espere hasta que se cargue el archivo");
        }
    });
});
