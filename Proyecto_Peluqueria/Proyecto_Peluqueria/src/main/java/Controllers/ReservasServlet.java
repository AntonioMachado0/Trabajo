/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Dao.ReservasDao;
import Modelss.Reserva;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Machado
 */

@WebServlet(name = "ReservasServlet", value = "/Reservas")
public class ReservasServlet extends HttpServlet {

    private ArrayList<Reserva> listaReserva = null;
    private ReservasDao daoreserva;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            daoreserva = new ReservasDao();
            System.out.println("ddfg");
            this.listaReserva = this.daoreserva.selectCortes();
            System.out.println("laaaa");
            JSONArray json = new JSONArray();
            System.out.println("llllll");
            for(Object obj: listaReserva){
                System.out.println("mmmmmm");
                Reserva res = (Reserva) obj;
                System.out.println("sdfdddd");
                JSONObject jsinto = new JSONObject();
                JSONObject jsinto2 = new JSONObject();
                JSONObject jsinto3 = new JSONObject();
                System.out.println("ssssss");
                jsinto.put("nombre", res.getCliente().getNombre());
                jsinto2.put("Cliente", jsinto);
                System.out.println("lllll");
                jsinto2.put("fecha", res.getFecha());
                System.out.println("kkkkk");
                jsinto3.put("tipocorte", res.getCorte().getTipoCorte());
               
                jsinto2.put("Corte", jsinto3);
                
                json.put(jsinto2);
            }

            ObjectMapper mapeador = new ObjectMapper();
            PrintWriter pw = response.getWriter();
            response.setContentType("application/json");
            System.out.println("aquiiiii");
            System.out.println(json.toString());
            response.setCharacterEncoding("UTF-8");
            pw.print(json.toString());
           
        } catch (SQLException ex) {
            Logger.getLogger(ReservasServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
