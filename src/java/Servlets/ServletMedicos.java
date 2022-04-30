package Servlets;

import Beans.Medicos;
import Utils.ConexionDB;
import static Utils.Tools.getCurrentTimeStamp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author administrador
 */
@WebServlet(name = "ServletMedicos", urlPatterns = {"/ServletMedicos"})
public class ServletMedicos extends HttpServlet {

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
        String actualizar = request.getParameter("upd");
        if (borrar != null) {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("delete from medico where idpersona=?");
                sta.setInt(1, Integer.parseInt(borrar));
                sta.executeUpdate();

                response.sendRedirect("ServletMedicos");

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else if (actualizar != null) {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from medico where idpersona=?");
                sta.setInt(1, Integer.parseInt(actualizar));
                ResultSet rs = sta.executeQuery();

                ArrayList<Medicos> lista = new ArrayList<>();

                while (rs.next()) {
                    Medicos m = new Medicos(rs.getInt(1), rs.getInt(2),
                            rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    lista.add(m);
                }
                request.setAttribute("m_lista", lista);
                request.getRequestDispatcher("m_update.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from medico");
                ResultSet rs = sta.executeQuery();

                ArrayList<Medicos> lista = new ArrayList<>();

                while (rs.next()) {
                    Medicos m = new Medicos(rs.getInt(1), rs.getInt(2),
                            rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    lista.add(m);
                }
                request.setAttribute("m_lista", lista);
                request.getRequestDispatcher("m_listado.jsp").forward(request, response);

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
