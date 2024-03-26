/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
$(document).ready(function(){
    $.ajax({
        url:"./Cortes",
        dataType:'json',
        type:'get',
        cache:false,
        success: function(data){
            console.log(data);
            var event_data = '';
            $.each(data, function(index, value){
                //console.log(value);
                
                event_data += '<tr>'; 
                event_data += '<td>' + value.idCorte + '</td>'; 
                event_data += '<td>' + value.tipoCorte + '</td>'; 
                event_data += '<td>' + value.precio + '</td>'; 
                event_data += '<tr>'; 
                
                
            });
            $("#list_table_json").append(event_data);
        },error:function(d){
            console.log("error");
            alert("404 espere hasta que se cargue el archivo");
        }
    });
    
});