/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


class Cargo{
    idcargo;
    nombrecargo;
    constructor(){
        this.idcargo = 0;
        this.nombrecargo = "";
    }
    
    getIdCargo(){
        return this.idcargo;
    }
    
    setIdCargo(idcargo){
        this.idcargo = idcargo;
    }
    
    getNombreCargo(){
        return this.nombrecargo;
    }
    
    setNombreCargo(nombrecargo){
        this.nombrecargo = nombrecargo;
    }
}