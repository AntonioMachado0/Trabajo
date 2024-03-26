/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CorteDao;
import dao.ReservaDao;
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
import modelo.Reserva;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author guill
 */
@WebServlet(name = "ControladorReserva", value = "/Reserva")
public class ControladorReserva extends HttpServlet{
    
    private ArrayList <Reserva> listReserva = null;
    private ReservaDao daoReserva;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            daoReserva = new ReservaDao();
            this.listReserva = this.daoReserva.selectReserva();
            JSONArray json = new JSONArray();
            
            for (Object obj: listReserva) {
                Reserva res = (Reserva) obj;
                JSONObject jsinto = new JSONObject();
                JSONObject jsinto2 = new JSONObject();
                
                jsinto.put("nombre", res.getCliente().getNombre());
                jsinto.put("correo", res.getCliente().getCorreo());
                jsinto2.put("cliente", jsinto);
                jsinto2.put("estado", res.getEstado());
            
                json.put(jsinto2);
            }
            
            ObjectMapper mapeador = new ObjectMapper();
            PrintWriter pw = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            pw.print(json.toString());
            
//            pw.print(mapeador.writeValueAsString(this.listReserva));
        } catch (SQLException ex) {
            Logger.getLogger(controladorCorte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorCorte.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
