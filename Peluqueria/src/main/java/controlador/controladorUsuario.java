/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.daoCargo;
import dao.daoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cargo;
import modelo.Usuarios;
import modelo.encriptAES;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author javier
 */
@WebServlet(name = "controladorUsuario", urlPatterns = {"/controladorUsuario"})
public class controladorUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        executar(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        executar(request,response);
    }

    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String opcion = request.getParameter("opcion");
        JSONObject json = new JSONObject();
        JSONObject json2 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Usuarios usu;
        Cargo cargo;
        encriptAES crip = new encriptAES("14B8ER9P0");
        Double errCrip = 1000*Math.random();
        ArrayList<Usuarios> ListUsu;
        ArrayList<Cargo> listCargo;
        daoUsuario daoU = new daoUsuario();
        daoCargo daoC = new daoCargo();
        switch (opcion) {
            case "1":
                //trae todos los usuarios
                ListUsu = daoU.getTodoUsuario();
                for (Usuarios u : ListUsu) {
                    json = new JSONObject();
                    json2 = new JSONObject();
                    
                    json2.put("idcargo", u.getCargo().getIdcargo());
                    json2.put("nombrecargo", u.getCargo().getNombrecargo());
                    
                    json.put("idusuario", u.getIdusuario());
                    json.put("nombreusuario", u.getNombreusuario());
                    json.put("apellidousuario", u.getApellidousuario());
                    json.put("dui", u.getDui());
                    json.put("telefono", u.getTelefono());
                    json.put("correo", u.getCorreo());
                    json.put("direccion", u.getDireccion());
                    json.put("estado", u.getEstado());
                    json.put("claveusuario", u.getClaveusuario());
                    json.put("cargo", json2);
                    jsonArray.put(ListUsu);
                }
                json = new JSONObject();
                if(ListUsu!=null){
                    json.put("usuarios", ListUsu);
                    json.put("resultado", true);
                }else{
                    json.put("resultado", false);
                }
                response.getWriter().write(json.toString());
                break;
            case "2":
                //trae un usuario por el correo
                usu = daoU.getUsuarioPorCorreo(request.getParameter("correo"));
                
                json2.put("idcargo", usu.getCargo().getIdcargo());
                json2.put("nombrecargo", usu.getCargo().getNombrecargo());
                
                json.put("idusuario", usu.getIdusuario());
                json.put("nombreusuario", usu.getNombreusuario());
                json.put("apellidousuario", usu.getApellidousuario());
                json.put("dui", usu.getDui());
                json.put("telefono", usu.getTelefono());
                json.put("correo", usu.getCorreo());
                json.put("direccion", usu.getDireccion());
                json.put("estado", usu.getEstado());
                json.put("claveusuario", usu.getClaveusuario());
                json.put("cargo", json2);
                
                if(usu!=null){
                    json.put("resultado", true);
                }else{
                    json.put("resultado", false);
                }
                
                response.getWriter().write(json.toString());
                break;
            case "3":
                //inserta un usuario
                usu = new Usuarios();
                cargo = new Cargo();
                cargo.setIdcargo(Integer.parseInt(request.getParameter("idcargo")));
                
                usu.setNombreusuario(request.getParameter("nombreusuario"));
                usu.setApellidousuario(request.getParameter("apellidousuario"));
                usu.setDui(request.getParameter("dui"));
                usu.setTelefono(request.getParameter("telefono"));
                usu.setCorreo(request.getParameter("correo"));
                usu.setDireccion(request.getParameter("direccion"));
                usu.setEstado(request.getParameter("estado"));
                try{
                    usu.setClaveusuario(crip.Encriptar(request.getParameter("claveusuario")));
                }catch(Exception e){
                    e.printStackTrace();
                    usu.setClaveusuario("Error:"+errCrip.intValue());
                }
                usu.setCargo(cargo);
                
                if(daoU.insertarUsuario(usu)){
                    json.put("resultado", true);
                }else{
                    json.put("resultado", false);
                }
                response.getWriter().write(json.toString());
                break;
            case "4":
                //actualiza un usuario
                usu = new Usuarios();
                cargo = new Cargo();
                cargo.setIdcargo(Integer.parseInt(request.getParameter("idcargo")));
                
                usu.setIdusuario(Integer.parseInt(request.getParameter("idusuario")));
                usu.setNombreusuario(request.getParameter("nombreusuario"));
                usu.setApellidousuario(request.getParameter("apellidousuario"));
                usu.setDui(request.getParameter("dui"));
                usu.setTelefono(request.getParameter("telefono"));
                usu.setCorreo(request.getParameter("correo"));
                usu.setDireccion(request.getParameter("direccion"));
                usu.setEstado(request.getParameter("estado"));
                try{
                    usu.setClaveusuario(crip.Encriptar(request.getParameter("claveusuario")));
                }catch(Exception e){
                    e.printStackTrace();
                    usu.setClaveusuario("Error:"+errCrip.intValue());
                }
                usu.setCargo(cargo);
                
                if(daoU.actualizarUsuario(usu)){
                    json.put("resultado", true);
                }else{
                    json.put("resultado", false);
                }
                response.getWriter().write(json.toString());
                break;
            case "5":
                //extrae todos los cargos
                listCargo = daoC.getTodoCargo();
                for(Cargo c : listCargo){
                    json.put("idcargo", c.getIdcargo());
                    json.put("nombrecargo", c.getNombrecargo());
                    jsonArray.put(json);
                    json = new JSONObject();
                }
                
                if(listCargo!=null){
                    json.put("resultado", true);
                    json.put("cargos", jsonArray);
                }else{
                    json.put("resultado", false);
                }
                response.getWriter().write(json.toString());
                break;
            case "6":
                //desencripta una clave
                String clave = request.getParameter("claveusuario");
                try{
                    json.put("claveusuario", crip.Desencriptar(clave));
                    json.put("resultado", true);
                }catch(Exception e){
                    json.put("claveusuario", "Error:"+errCrip.intValue());
                    json.put("resultado", false);
                }
                response.getWriter().write(json.toString());
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
