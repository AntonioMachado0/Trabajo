$(document).ready(function(){
    $.ajax({
        url:"./Reservas",
        dataType:'json',
        type:'get',
        cache:false,
        success: function(data){
            console.log(data);
            var event_data = '';

             for(let pan of data){
                            event_data += '<tr>'; 
                event_data += '<td>' + pan.Cliente.nombre + '</td>'; 
                event_data += '<td>' + pan.fecha + '</td>'; 
                event_data += '<td>' + pan.Corte.tipocorte + '</td>'; 
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