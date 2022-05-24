package Servlets;

import Beans.Horarios;
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
@WebServlet(name = "ServletHorarios", urlPatterns = {"/ServletHorarios"})
public class ServletHorarios extends HttpServlet {

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
        String actualizar = request.getParameter("upd");
        if (borrar != null) {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("delete from horario where idhorario=?");
                sta.setInt(1, Integer.parseInt(borrar));
                sta.executeUpdate();

                response.sendRedirect("ServletHorarios");

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else if (actualizar != null) {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from horario where idhorario=?");
                sta.setInt(1, Integer.parseInt(actualizar));
                ResultSet rs = sta.executeQuery();

                ArrayList<Horarios> lista = new ArrayList<>();

                while (rs.next()) {
                    Horarios h = new Horarios(rs.getInt(1), rs.getInt(2),
                            rs.getInt(3), rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                    lista.add(h);
                }
                request.setAttribute("h_lista", lista);
                request.getRequestDispatcher("h_update.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from horario");
                ResultSet rs = sta.executeQuery();

                ArrayList<Horarios> lista = new ArrayList<>();

                while (rs.next()) {
                    Horarios h = new Horarios(rs.getInt(1), rs.getInt(2),
                            rs.getInt(3), rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                    lista.add(h);
                }
                request.setAttribute("h_lista", lista);
                request.getRequestDispatcher("h_listado.jsp").forward(request, response);

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

                int idpersona = Integer.parseInt(request.getParameter("txtIdpersona"));
                int idespecialidad = Integer.parseInt(request.getParameter("txtIdespecialidad"));
                String fecha_ini = request.getParameter("txtFecha_ini");
                String fecha_fin = request.getParameter("txtFecha_fin");
                String tipo_horario = request.getParameter("txtTipo_horario");
                String comentarios = request.getParameter("txtComentarios");

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("insert into horario values(?,?,?,?,?,?,?,?,?)");

                sta.setInt(1, 0);
                sta.setInt(2, idpersona);
                sta.setInt(3, idespecialidad);
                sta.setTimestamp(4, getCurrentTimeStamp());
                sta.setTimestamp(5, getCurrentTimeStamp());
                sta.setString(6, tipo_horario);
                sta.setString(7, comentarios);
                sta.setTimestamp(8, getCurrentTimeStamp());

                sta.setInt(9, estado);
                sta.executeUpdate();

                response.sendRedirect("ServletHorarios");

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
                
                int idpersona = Integer.parseInt(request.getParameter("txtIdpersona"));
                int idespecialidad = Integer.parseInt(request.getParameter("txtIdespecialidad"));
                String fecha_ini = request.getParameter("txtFecha_ini");
                String fecha_fin = request.getParameter("txtFecha_fin");
                String tipo_horario = request.getParameter("txtTipo_horario");
                String comentarios = request.getParameter("txtComentarios");

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("UPDATE horario SET idpersona=?,idespecialidad=?,fechahorainicio=?,fechahorafin=?,tipohorario=?,comentarios=?,fecha=?,estado=? WHERE idhorario=?");
                
                sta.setInt(1, idpersona);
                sta.setInt(2, idespecialidad);
                sta.setTimestamp(3, getCurrentTimeStamp());
                sta.setTimestamp(4, getCurrentTimeStamp());
                sta.setString(5, tipo_horario);
                sta.setString(6, comentarios);                
                sta.setTimestamp(7, getCurrentTimeStamp());
                sta.setInt(8, estado);
                sta.setInt(9, id);
                sta.executeUpdate();
                
                response.sendRedirect("ServletHorarios");

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
