/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function cargarTabla(estado = 1) {
    mostrar_cargando("procesando solicitud", "Espere mientas se procesa la información");
    var datos = {"consultar_datos": "si_consulta", "estado": estado};
    console.log("esta aqui");
    $.ajax({
        dataType: "json",
        method: "POST",
        url: "RegAutor",
        data: datos
    }).done(function (json) {
        Swal.close();
        console.log("datos consultados: ", json);
        if (json[0].resultado == "exito") {
            $("#aqui_tabla").empty().html(json[0].tabla);
            document.querySelector("#Autores_registradas").textContent = json[0].cuantos;
            $("#tabla_autores").DataTable({
                "language": {
                    "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                }
            });
        } else {

            Swal.fire('Accion no completada', 'No pudo obtener los datos', 'error');
        }
    }).fail(function () {

    }).always(function () {

    });
}

function mostrar_cargando(titulo, mensaje = "") {
    Swal.fire({
        title: titulo,
        html: mensaje,
        timer: 2000,
        timerProgessBar: true,
        didOpen: () => {
            Swal.showLoading();
        },
        willClose: () => {
        }
    }).then((result) => {
        if (result.dismiss === Swal.DismissReason.timer) {

            console.log('I was closed by timer');
            }

        });
}   