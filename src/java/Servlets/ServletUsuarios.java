package Servlets;

import Beans.Usuarios;
import Utils.ConexionDB;
import static Utils.Tools.getCurrentTimeStamp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ServletUsuarios", urlPatterns = {"/ServletUsuarios"})
public class ServletUsuarios extends HttpServlet {

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
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("delete from usuario where idpersona=?");
                sta.setInt(1, Integer.parseInt(borrar));
                sta.executeUpdate();

                response.sendRedirect("ServletUsuarios");

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else if (actualizar != null) {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from usuario where idpersona=?");
                sta.setInt(1, Integer.parseInt(actualizar));
                ResultSet rs = sta.executeQuery();

                ArrayList<Usuarios> lista = new ArrayList<>();

                while (rs.next()) {
                    Usuarios u = new Usuarios(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                    lista.add(u);
                }
                request.setAttribute("u_lista", lista);
                request.getRequestDispatcher("u_update.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from usuario");
                ResultSet rs = sta.executeQuery();

                ArrayList<Usuarios> lista = new ArrayList<>();

                while (rs.next()) {
                    Usuarios u = new Usuarios(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                    lista.add(u);
                }
                request.setAttribute("u_lista", lista);
                request.getRequestDispatcher("u_listado.jsp").forward(request, response);

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

                String usuario = request.getParameter("txtUsuario");
                String u_pass = request.getParameter("txtPassword");
                String tipo_usuario = request.getParameter("txtTipoUsuario");

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("insert into usuario values(?,?,?,?,?,?)");

                sta.setInt(1, 0);
                sta.setString(2, usuario);
                sta.setString(3, u_pass);
                sta.setString(4, tipo_usuario);
                sta.setTimestamp(5, getCurrentTimeStamp());
                sta.setInt(6, estado);
                sta.executeUpdate();

                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("ServletUsuarios");

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
                String u_pass = request.getParameter("txtPassword");
                String tipo_usuario = request.getParameter("txtTipoUsuario");

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("UPDATE usuario SET password=?,tipousuario=?,fecha=?,estado=? WHERE idpersona=?");

                sta.setString(1, u_pass);
                sta.setString(2, tipo_usuario);
                sta.setTimestamp(3, getCurrentTimeStamp());
                sta.setInt(4, estado);
                sta.setInt(5, id);
                sta.executeUpdate();

                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("ServletUsuarios");

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
