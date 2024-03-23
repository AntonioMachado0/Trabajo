/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


class Usuarios{
    idUsuario;
    nombreUsuario;
    apellidoUsuario;
    dui;
    telefono;
    correo;
    direccion;
    estado;
    fk_cargo;
    cargo;
    claveusuario;
    
    constructor(){
        this.idUsuario = 0;
        this.nombreUsuario = "";
        this.apellidoUsuario = "";
        this.dui = "";
        this.telefono = "";
        this.correo = "";
        this.direccion = "";
        this.estado = "";
        this.fk_cargo = 0;
        this.claveusuario;
        this.cargo = new Cargo();
    }
    
    getClaveUsuario(){
        return this.claveusuario;
    }
    
    setClaveUsuario(claveusuario){
        this.claveusuario = claveusuario;
    }
    
    getCargo(){
        return this.cargo;
    }
    
    setCargo(cargo){
        this.cargo = cargo;
    }
    //
    getIdUsuario(){
        return this.idUsuario;
    }
    
    setIdUsuario(idUsuario){
        this.idUsuario = idUsuario;
    }
    
    //
    getNombreUsuario(){
        return this.nombreUsuario;
    }
    
    setNombreUsuario(nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
    //
    getApellidoUsuario(){
        return this.apellidoUsuario;
    }
    
    setApellidoUsuario(apellidoUsuario){
        this.apellidoUsuario = apellidoUsuario;
    }
    
    //
    getDui(){
        return this.dui;
    }
    
    setDui(dui){
        this.dui = dui;
    }
    
    //
    getTelefono(){
        return this.telefono;
    }
    
    setTelefono(telefono){
        this.telefono = telefono;
    }
    
    //
    getCorreo(){
        return this.correo;
    }
    
    setCorreo(correo){
        this.correo = correo;
    }
    
    //
    getDireccion(){
        return this.direccion;
    }
    
    setDireccion(direccion){
        this.direccion = direccion;
    }
    
    //
    getEstado(){
        return this.estado;
    }
    
    setEstado(estado){
        this.estado = estado;
    }
    
    //
    getFk_cargo(){
        return this.fk_cargo;
    }
    
    setFk_cargo(fk_cargo){
        this.fk_cargo = fk_cargo;
    }
}