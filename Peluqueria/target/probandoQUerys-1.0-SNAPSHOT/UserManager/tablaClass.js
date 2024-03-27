/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


class tabla {
    idtabla;
    idname;
    arreglo;
    index;
    indexSelect;
    select;
    dataSelect;
    eventos;
    constructor(idname ,idtabla) {
        this.idtabla = idtabla;
        this.idname = idname;
        this.arreglo = [];
        this.eventos = [];
        this.index = 0;
        this.indexSelect = -1;
    }

    setIndex(index) {
        this.indexSelect = -1;
        if (index != null) {
            this.index = index;
            var tp = [];
            for (var i = 0; i < index; i++) {
                tp[i] = this.arreglo[i];
            }
            this.arreglo = tp;
            this.mostrar();
        }
    }

    addDatos(datos, event) {
        if (this.arreglo != null) {
            this.arreglo[this.arreglo.length] = datos;
            this.eventos[this.eventos.length] = event;
            this.mostrar(event);
        }
    }

    getDatos() {
        return this.arreglo;
    }

    getSelect() {
        return this.select;
    }

    setSelect(select) {
        this.select = select;
    }

    getDataSelected() {
        return this.dataSelect;
    }

    setDataSelect(data) {
        this.dataSelect = data;
    }

    getEventos() {
        return this.eventos;
    }
    
    getSelectIndex(){
        return this.indexSelect;
    }
    
    setSelectIndex(index){
        this.indexSelect = index;
    }
    
    setIdName(idname){
        this.idname = idname;
    }
    
    getIdName(){
        return this.idname;
    }

    mostrar() {
        if (this.idtabla != null && this.idname!=null) {
            var tbody = document.querySelector(this.idtabla).children[1];
            var html = "";
            var index = 0;
            var data = this.arreglo;
            for (var datos of this.arreglo) {
                html += `<tr id='${this.idname+index}'>`;
                for (var di of datos) {
                    html += `<th style="cursor: default;">${di}</th>`;
                }
                html += '</tr>';
                index++;
            }
            this.index = this.arreglo.length;
            tbody.innerHTML = html;
            
            var a = this;
            for (var d of tbody.children) {
                d.addEventListener('click', function (b) {
                    var idElement = b.target.closest('tr').id;
                    var id = parseInt(idElement.substr(a.getIdName().length,idElement.length));
                    a.setSelect(b.target.closest('tr'));
                    a.setDataSelect(a.getDatos()[id]);
                    a.setSelectIndex(id);
                    if (a.getEventos()[id] != null) {
                        a.getEventos()[id](b);
                    }
                }, false);
            }
        }
    }
}