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
                            rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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
                            rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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

        String op = request.getParameter("op");

        if (op.equals("nuevo")) {
            try {
                int estado;
                if ("on".equals(request.getParameter("chkActivo"))) {
                    estado = 1;
                } else {
                    estado = 0;
                }

                String especialidad = request.getParameter("txtEspecialidad");
                String tipo_persona = request.getParameter("txtTipoPersona");
                String cod_cmp = request.getParameter("txtCodCMP");

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("insert into medico values(?,?,?,?,?,?,?)");

                sta.setInt(1, 0);
                sta.setInt(2, Integer.parseInt(especialidad));
                sta.setString(3, tipo_persona);
                sta.setString(4, cod_cmp);
                sta.setTimestamp(5, getCurrentTimeStamp());
                sta.setTimestamp(6, getCurrentTimeStamp());
                sta.setInt(7, estado);
                sta.executeUpdate();

                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("ServletMedicos");

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

                String id = request.getParameter("updId");
                String especialidad = request.getParameter("txtEspecialidad");
                String tipo_persona = request.getParameter("txtTipoPersona");
                String cod_cmp = request.getParameter("txtCodCMP");

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("UPDATE medico SET idespecialidad=?,tipopersona=?,codigomedico=?,fechaingreso=?,fecha=?,estado=? WHERE idpersona=?");

                sta.setInt(1, Integer.parseInt(especialidad));
                sta.setString(2, tipo_persona);
                sta.setString(3, cod_cmp);
                sta.setTimestamp(4, getCurrentTimeStamp());
                sta.setTimestamp(5, getCurrentTimeStamp());
                sta.setInt(6, estado);
                sta.setInt(7, Integer.parseInt(id));
                sta.executeUpdate();

                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("ServletMedicos");

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
