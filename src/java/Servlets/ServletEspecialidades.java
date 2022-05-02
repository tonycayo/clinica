package Servlets;

import Beans.Especialidades;
import Utils.ConexionDB;
import static Utils.Tools.getCurrentTimeStamp;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author administrador
 */
@WebServlet(name = "ServletEspecialidades", urlPatterns = {"/ServletEspecialidades"})
public class ServletEspecialidades extends HttpServlet {

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
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("delete from especialidad where idespecialidad=?");
                sta.setInt(1, Integer.parseInt(borrar));
                sta.executeUpdate();

                response.sendRedirect("ServletEspecialidades");

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else if (actualizar != null) {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from especialidad where idespecialidad=?");
                sta.setInt(1, Integer.parseInt(actualizar));
                ResultSet rs = sta.executeQuery();

                ArrayList<Especialidades> lista = new ArrayList<>();

                while (rs.next()) {
                    Especialidades e = new Especialidades(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getInt(5));
                    lista.add(e);
                }
                request.setAttribute("e_lista", lista);
                request.getRequestDispatcher("e_update.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from especialidad");
                ResultSet rs = sta.executeQuery();

                ArrayList<Especialidades> lista = new ArrayList<>();

                while (rs.next()) {
                    Especialidades e = new Especialidades(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getInt(5));
                    lista.add(e);
                }
                request.setAttribute("e_lista", lista);
                request.getRequestDispatcher("e_listado.jsp").forward(request, response);

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

        String op = request.getParameter("op");

        if (op.equals("nuevo")) {
            try {
                int estado;
                if ("on".equals(request.getParameter("chkActivo"))) {
                    estado = 1;
                } else {
                    estado = 0;
                }

                String codigo = request.getParameter("txtCodigo");
                String descripcion = request.getParameter("txtDescripcion");
                String fecha = request.getParameter("txtFecha_reg");

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("insert into especialidad values(?,?,?,?,?)");

                sta.setInt(1, 0);
                sta.setString(2, codigo);
                sta.setString(3, descripcion);                
                sta.setTimestamp(4, getCurrentTimeStamp());
                out.println("estado: "+estado);
                sta.setInt(5, estado);
                
                sta.executeUpdate();
                
                response.sendRedirect("ServletEspecialidades");

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else if (op.equals("update")) {
            try {
                int estado;
                if ("on".equals(request.getParameter("chkActivo"))) {
                    estado = 1;
                } else {
                    estado = 0;
                }

                int id = Integer.parseInt(request.getParameter("updId"));
                
                String codigo = request.getParameter("txtCodigo");
                String descripcion = request.getParameter("txtDescripcion");
                String fecha = request.getParameter("txtFecha_reg");

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("UPDATE especialidad SET codigo=?,descripcion=?,fecha=?,estado=? WHERE idespecialidad=?");
                
                sta.setString(1, codigo);
                sta.setString(2, descripcion);                
                sta.setTimestamp(3, getCurrentTimeStamp());
                sta.setInt(4, estado);                
                
                sta.setInt(5, id);
                sta.executeUpdate();
                
                response.sendRedirect("ServletEspecialidades");

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
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
