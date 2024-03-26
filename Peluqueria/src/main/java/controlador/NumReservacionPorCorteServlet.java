/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;


import dao.NumReservacionPorCorteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.NumReservacionPorCorteDTO;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Luis
 */
@WebServlet(name = "NumReservacionPorCorteServlet", urlPatterns = {"/NumReservacionPorCorteServlet"})
public class NumReservacionPorCorteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String filtro = request.getParameter("consultar_datos");

        if (filtro == null) {
            return;
        }
        System.out.println(filtro);

        switch (filtro) {
            case "si_consulta":
                System.out.println("ENTRO A MOSTRAR EN EL SERVLET");
                JSONArray array_reservaciones = new JSONArray();
                String html = "";

                try {
                    NumReservacionPorCorteDAO obaut = new NumReservacionPorCorteDAO();
                    ArrayList<NumReservacionPorCorteDTO> listaReservaciones = obaut.consultarNumReservacionesPorCorte();

                    html += "<table id=\"tabla_reservaciones\""
                            + "+class=\"table table-bordered dt-responsive nowrap\""
                            + "cellspacing=\"0\" width=\"100%\">\n"
                            + "<thead>\n"
                            + "<th>Tipo de Corte</th>\n"
                            + "<th>Número de Reservaciones</th>\n"
                            + "</tr>\n"
                            + "</thead>\n"
                            + "<tbody>";

                    int cont = 0;

                    for (NumReservacionPorCorteDTO objReservacion : listaReservaciones) {
                        System.out.println(objReservacion.getTipoCorte());
                        cont++;
                        html += "<tr>";
                        html += "<td>" + objReservacion.getTipoCorte() + "</td>";
                        html += "<td>" + objReservacion.getCantidadCorte() + "</td>";
                        html += "</tr>";
                    }

                    html += "</tbody>\n"
                            + "\t\t</table>";

                    JSONObject json_reservacion = new JSONObject();
                    json_reservacion.put("resultado", "exito");
                    json_reservacion.put("tabla", html);
                    json_reservacion.put("cuantos", cont);

                    array_reservaciones.put(json_reservacion);

                    out.print(array_reservaciones.toString());

                } catch (SQLException e) {
                    JSONObject json_reservacion = new JSONObject();
                    json_reservacion.put("resultado", "error sql");
                    json_reservacion.put("error", e.getMessage());
                    json_reservacion.put("code error", e.getErrorCode());
                    array_reservaciones.put(json_reservacion);
                    out.print(array_reservaciones.toString());
                } catch (ClassNotFoundException ex) {
                    JSONObject json_reservacion = new JSONObject();
                    json_reservacion.put("resultado", "class not found");
                    json_reservacion.put("error", ex.getMessage());
                    array_reservaciones.put(json_reservacion);
                    out.print(array_reservaciones.toString());
                }
                break;

        }
    }
}
