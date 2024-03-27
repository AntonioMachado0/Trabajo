/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

var tabla1 = new tabla('t1', '#usuarios');
var usuarios = [];
var cargos = [];
var contLoad = 0;
var elementSelected;

$(document).on('click', '#btn_inicio', function (evt) {
    location.href = '../index.html';
});

$(document).on('submit', '#fusuarios', function (evt) {
    evt.preventDefault();
    var nombre = document.querySelector('#tnombre').value;
    var apellido = document.querySelector('#tapellido').value;
    var dui = document.querySelector('#tdui').value;
    var telefono = document.querySelector('#ttelefono').value;
    var direccion = document.querySelector('#tdireccion').value;
    var correo = document.querySelector('#tcorreo').value;
    var estado = document.querySelector('#list_estado').value;
    var cargo = document.querySelector('#list_cargos').value;
    var contra = document.querySelector('#tpassword').value;
    if (document.querySelector('#btn_guardar_actualizar').value == 'Guardar') {
        $.ajax({
            url: '../controladorUsuario',
            method: 'POST',
            dataType: 'json',
            data: {'opcion': 3, 'idcargo': cargo, 'nombreusuario': nombre, 'apellidousuario': apellido, 'dui': dui, 'telefono': telefono, 'correo': correo, 'direccion': direccion, 'estado': estado,'claveusuario':contra}
        }).done(function (json) {
            if (json.resultado == true) {
                swal.fire('Datos Guardados', 'Los datos han sido almacenados', 'info');
                document.querySelector('#fusuarios').reset()
                cargarLosDatos();
            } else {
                swal.fire('Error al guardar los datos', 'No fue posible almacenar los datos', 'error');
            }
        }).fail(function () {
            swal.fire('Error de Red', 'La red se encuentra mal en estos momentos', 'error');
        });
    } else {
        $.ajax({
            url: '../controladorUsuario',
            method: 'POST',
            dataType: 'json',
            data: {'opcion': 4, 'idusuario': usuarios[tabla1.getSelectIndex()].getIdUsuario(), 'idcargo': cargo, 'nombreusuario': nombre, 'apellidousuario': apellido, 'dui': dui, 'telefono': telefono, 'correo': correo, 'direccion': direccion, 'estado': estado,'claveusuario':contra}
        }).done(function (json) {
            if (json.resultado == true) {
                swal.fire('Datos Actualizados', 'Los datos han sido actualizados', 'info');
                document.querySelector('#fusuarios').reset()
                cargarLosDatos();
            } else {
                swal.fire('Error al actualizar los datos', 'No fue posible actualizar los datos', 'error');
            }
        }).fail(function () {
            swal.fire('Error de Red', 'La red se encuentra mal en estos momentos', 'error');
        });
        document.querySelector('#fusuarios').reset();
        document.querySelector('#btn_guardar_actualizar').value = 'Guardar';
    }
});

$(document).on('click', '#btn_cancelar', function () {
    document.querySelector('#btn_guardar_actualizar').value = 'Guardar';
});

$(document).on('click', '#btn_actualizar', function () {
    if (tabla1.getSelectIndex() != -1) {
        var lista1 = document.querySelector('#list_cargos').children;
        var lista2 = document.querySelector('#list_estado').children;
        var select = usuarios[tabla1.getSelectIndex()];
        for (var i = 0; i < lista1.length; i++) {
            if (select.getCargo().getIdCargo() == lista1[i].value) {
                document.querySelector('#list_cargos').selectedIndex = i;
            }
        }
        for (var i = 0; i < lista2.length; i++) {
            if (select.getEstado() == lista2[i].value) {
                document.querySelector('#list_estado').selectedIndex = i;
            }
        }
        $.ajax({
            url: '../controladorUsuario',
            method: 'POST',
            dataType: 'json',
            data: {'opcion': 6,'claveusuario':select.getClaveUsuario()}
        }).done(function(json){
            if(json.resultado==true){
                llenarFormActualizar(select,json.claveusuario);
            }else{
                swal.fire('Error Uncripted','El servidor no pudo desencriptar la contraseña','error');
            }
        }).fail(function(){
            swal.fire('Error','Un error de red','error');
        });
    } else {
        swal.fire('No se a seleccionado nada', '', 'info');
    }
});

function llenarFormActualizar(select, contra) {
    document.querySelector('#tnombre').value = select.getNombreUsuario();
    document.querySelector('#tapellido').value = select.getApellidoUsuario();
    document.querySelector('#tdui').value = select.getDui();
    document.querySelector('#ttelefono').value = select.getTelefono();
    document.querySelector('#tcorreo').value = select.getCorreo();
    document.querySelector('#tdireccion').value = select.getDireccion();
    document.querySelector('#tpassword').value = contra;
    document.querySelector('#btn_guardar_actualizar').value = 'Actualizar';
}

$(function () {
    cargarLosDatos();
});

function cargarLosDatos() {
    activLoad();
    $.ajax({
        url: "../controladorUsuario",
        method: "POST",
        dataType: "json",
        data: {"opcion": 1}
    }).done(function (json) {
        if (json.resultado == true) {
            usuarios = [];
            for (var datos of json.usuarios) {
                var tpu = new Usuarios();
                var cargo = new Cargo();
                cargo.setIdCargo(datos.cargo.idcargo);
                cargo.setNombreCargo(datos.cargo.nombrecargo);

                tpu.setIdUsuario(datos.idusuario);
                tpu.setNombreUsuario(datos.nombreusuario);
                tpu.setApellidoUsuario(datos.apellidousuario);
                tpu.setDui(datos.dui);
                tpu.setTelefono(datos.telefono);
                tpu.setCorreo(datos.correo);
                tpu.setDireccion(datos.direccion);
                tpu.setEstado(datos.estado);
                tpu.setClaveUsuario(datos.claveusuario);
                tpu.setCargo(cargo);

                usuarios[usuarios.length] = tpu;
            }
            cargarTabla();
            offLoad();
        } else {
            offLoad();
            swal.fire("Error en extraer los datos", "Ha ocurrido un error al extraer los datos", "error");
        }
    }).fail(function (e) {
        swal.fire("Error al cargar los datos", "No se pudo extraer los datos", "Error");
    });
    activLoad();
    $.ajax({
        url: "../controladorUsuario",
        method: "POST",
        dataType: "json",
        data: {"opcion": 5}
    }).done(function (json) {
        if (json.resultado == true) {
            cargarListaCargos(json);
            offLoad();
        } else {
            offLoad();
            swal.fire("Error en extraer los datos", "Ha ocurrido un error al extraer los datos", "error");
        }
    }).fail(function () {
        swal.fire("Error al cargar los datos", "No se pudo extraer los datos", "Error");
    });
}

function cargarListaCargos(json) {
    var listaCargo = document.querySelector('#list_cargos');
    var HTML = "";
    cargos = [];
    for (var dat of json.cargos) {
        var tc = new Cargo();
        tc.setIdCargo(dat.idcargo);
        tc.setNombreCargo(dat.nombrecargo);
        cargos[cargos.length] = tc;
    }

    for (var dat of cargos) {
        HTML += `<option value="${dat.getIdCargo()}">${dat.getNombreCargo()}</Option>`;
    }
    listaCargo.innerHTML = HTML;
}

function activLoad() {
    if (contLoad == 0) {
        mostrarCargando("Cargando datos", "Esper un momento mientras se cargan los datos");
    }
    contLoad++;
}

function offLoad() {
    if (contLoad > 0) {
        --contLoad;
        if (contLoad == 0) {
            swal.close();
        }
    }
}

function cargarTabla() {
    tabla1.setIndex(0);
    for (var data of usuarios) {
        tabla1.addDatos([
            data.getNombreUsuario(),
            data.getApellidoUsuario(),
            data.getDui(),
            data.getTelefono(),
            data.getCorreo(),
            data.getClaveUsuario(),
            data.getDireccion(),
            data.getCargo().getNombreCargo(),
            data.getEstado()
        ], eventTablaClick);
    }
}

function eventTablaClick(evt) {
    if (elementSelected != null) {
        elementSelected.classList.remove('tabla-select');
    }
    elementSelected = tabla1.getSelect();
    elementSelected.classList.add('tabla-select');
}

function mostrarCargando(titulo, mensaje = "") {
    swal.fire({
        title: titulo,
        html: mensaje,
        timer: 10000,
        timerProgressBar: true,
        didOpen: () => {
            swal.showLoading();
        },
        willClose: () => {
        }
    }).then((result) => {
        if (result.dismiss == swal.DismissReason.timer) {
            swal.fire("TIEMPO SUPERADO", "El servidor no respondio la solicitud", "error");
        }
    });
}