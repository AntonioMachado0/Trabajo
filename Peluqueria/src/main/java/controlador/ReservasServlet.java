/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controlador;




import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebServlet(name = "ReservasServlet", value = "/ReservasConsul")
public class ReservasServlet extends HttpServlet {

    private ReservaDao daoReserva;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            daoReserva = new ReservaDao();
            ArrayList<Reserva> listReserva = daoReserva.obtenerReservasConDetalles();

            JSONArray json = new JSONArray();

            for (Reserva res : listReserva) {
                JSONObject jsinto = new JSONObject();

                
                jsinto.put("id", res.getIdReserva());
                jsinto.put("fecha", res.getFecha());
                jsinto.put("hora", res.getHora());
                jsinto.put("nombre_cliente", res.getCliente().getNombre());
                jsinto.put("tipocorte", res.getCorte().getTipoCorte());

                json.put(jsinto);
            }

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            try (PrintWriter pw = response.getWriter()) {
                pw.print(json.toString());
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ControladorReserva.class.getName()).log(Level.SEVERE, null, ex);

          
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error en el servidor.");
        }
    }
}
