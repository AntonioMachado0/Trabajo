/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CorteDao;
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
import modelo.Corte;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author guill
 */
@WebServlet(name = "controladorCorte", value = "/Cortes")
public class controladorCorte extends HttpServlet {

    private ArrayList<Corte> listaCorte = null;
    private CorteDao daocorte;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            daocorte = new CorteDao();
            this.listaCorte = this.daocorte.selectCortes();

            ObjectMapper mapeador = new ObjectMapper();
            PrintWriter pw = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            pw.print(mapeador.writeValueAsString(this.listaCorte));
        } catch (SQLException ex) {
            Logger.getLogger(controladorCorte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorCorte.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
