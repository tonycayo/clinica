package Servlets;

import Beans.Logs;
import Utils.ConexionDB;
import Utils.Tools;
import static Utils.Tools.getCurrentTimeStamp;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ServletLogs", urlPatterns = {"/ServletLogs"})
public class ServletLogs extends HttpServlet {

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
        response.setContentType("text/html;charset=ISO-8859-1");

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

        String borrar = request.getParameter("del");
        if (borrar != null) {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("delete from log where idlog=?");
                sta.setInt(1, Integer.parseInt(borrar));
                sta.executeUpdate();

                response.sendRedirect("ServletLogs");

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from log");
                ResultSet rs = sta.executeQuery();

                ArrayList<Logs> lista = new ArrayList<>();

                while (rs.next()) {
                    Logs lo = new Logs(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                            rs.getString(7), rs.getString(8));
                    lista.add(lo);
                }
                request.setAttribute("lo_lista", lista);
                request.getRequestDispatcher("log.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
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
        processRequest(request, response);
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
