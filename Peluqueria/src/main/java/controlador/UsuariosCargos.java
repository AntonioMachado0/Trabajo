/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuarios;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Jonathan Flores
 */
@WebServlet(name = "UsuariosCargos",  value = "/usuariosCargos")
public class UsuariosCargos extends HttpServlet {


  private ArrayList<Usuarios> listaUsuarios = null;
private UsuarioDao daoUsuarios;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
        daoUsuarios = new UsuarioDao();
        listaUsuarios = daoUsuarios.obtenerUsuariosConCargos();
        
        JSONArray jsonArray = new JSONArray();

        for (Usuarios usuario : listaUsuarios) {
            JSONObject jsonObjectUsuario = new JSONObject();
           
            
            // Establece las propiedades del usuario en el objeto JSON
            jsonObjectUsuario.put("nombre", usuario.getNombreusuario());
            jsonObjectUsuario.put("apellido", usuario.getApellidousuario());
            jsonObjectUsuario.put("dui", usuario.getDui());
            jsonObjectUsuario.put("telefono", usuario.getTelefono());
            jsonObjectUsuario.put("estado", usuario.getEstado());
            jsonObjectUsuario.put("cargo", usuario.getCargo().getNombrecargo());
            
    
            jsonArray.put(jsonObjectUsuario);
        }
        
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Envía la respuesta JSON al cliente
        PrintWriter out = response.getWriter();
        out.print(jsonArray.toString());
    } catch (SQLException ex) {
        Logger.getLogger(UsuariosCargos.class.getName()).log(Level.SEVERE, null, ex);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    
       
    }
}

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
