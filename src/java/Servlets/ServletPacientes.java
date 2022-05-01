package Servlets;

import Beans.Pacientes;
import Utils.ConexionDB;
import static Utils.Tools.getCurrentTimeStamp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ServletPacientes", urlPatterns = {"/ServletPacientes"})
public class ServletPacientes extends HttpServlet {

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
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("delete from persona where idpersona=?");
                sta.setInt(1, Integer.parseInt(borrar));
                sta.executeUpdate();

                response.sendRedirect("ServletPacientes");

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else if (actualizar != null) {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from persona where idpersona=?");
                sta.setInt(1, Integer.parseInt(actualizar));
                ResultSet rs = sta.executeQuery();

                ArrayList<Pacientes> lista = new ArrayList<>();

                while (rs.next()) {
                    Pacientes p = new Pacientes(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14), rs.getInt(15));
                    lista.add(p);
                }
                request.setAttribute("p_lista", lista);
                request.getRequestDispatcher("p_update.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            try {
                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("select * from persona");
                ResultSet rs = sta.executeQuery();

                ArrayList<Pacientes> lista = new ArrayList<>();

                while (rs.next()) {
                    Pacientes p = new Pacientes(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14), rs.getInt(15));
                    lista.add(p);
                }
                request.setAttribute("p_lista", lista);
                request.getRequestDispatcher("p_listado.jsp").forward(request, response);

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

                String id = request.getParameter("updId");
                String tipo_doc = request.getParameter("txtTipoDoc");
                String doc = request.getParameter("txtDoc");
                String apepat = request.getParameter("txtApePat");
                String apemat = request.getParameter("txtApeMat");
                String nombres = request.getParameter("txtNombres");
                String fecha_nac = request.getParameter("txtFechaNac");
                String sexo = request.getParameter("txtSexo");
                String email = request.getParameter("txtEmail");

                int espaciente;
                if ("on".equals(request.getParameter("flexRadioEsPaciente"))) {
                    espaciente = 1;
                } else {
                    espaciente = 0;
                }

                int espersona;
                if ("on".equals(request.getParameter("flexRadioEsPersona"))) {
                    espersona = 1;
                } else {
                    espersona = 0;
                }

                int esmedico;
                if ("on".equals(request.getParameter("flexRadioEsMedico"))) {
                    esmedico = 1;
                } else {
                    esmedico = 0;
                }

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("insert into persona values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                sta.setInt(1, 0);
                sta.setString(2, tipo_doc);
                sta.setString(3, doc);
                sta.setString(4, apepat);
                sta.setString(5, apemat);
                sta.setString(6, nombres);
                sta.setString(7, nombres + " " + apepat + " " + apemat);
                sta.setTimestamp(8, getCurrentTimeStamp());
                sta.setString(9, sexo);
                sta.setString(10, email);
                sta.setInt(11, espaciente);
                sta.setInt(12, espersona);
                sta.setInt(13, esmedico);
                sta.setTimestamp(14, getCurrentTimeStamp());
                sta.setInt(15, estado);
                sta.executeUpdate();

                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("ServletPacientes");

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
                String tipo_doc = request.getParameter("txtTipoDoc");
                String doc = request.getParameter("txtDoc");
                String apepat = request.getParameter("txtApePat");
                String apemat = request.getParameter("txtApeMat");
                String nombres = request.getParameter("txtNombres");
                String fecha_nac = request.getParameter("txtFechaNac");
                String sexo = request.getParameter("txtSexo");
                String email = request.getParameter("txtEmail");

                int espaciente;
                if ("on".equals(request.getParameter("flexRadioEsPaciente"))) {
                    espaciente = 1;
                } else {
                    espaciente = 0;
                }

                int espersona;
                if ("on".equals(request.getParameter("flexRadioEsPersona"))) {
                    espersona = 1;
                } else {
                    espersona = 0;
                }

                int esmedico;
                if ("on".equals(request.getParameter("flexRadioEsMedico"))) {
                    esmedico = 1;
                } else {
                    esmedico = 0;
                }

                PreparedStatement sta = ConexionDB.getConexion().prepareStatement("UPDATE persona SET "
                        + "tipodocumento=?,documento=?,apellidospaterno=?,apellidosmaterno=?,"
                        + "nombres=?, fechanacimiento=?, sexo=?, email=?, espaciente=?, "
                        + "espersona=?,esmedico=?,fecha=?,estado=? WHERE idpersona=?");

                sta.setString(1, tipo_doc);
                sta.setString(2, doc);
                sta.setString(3, apepat);
                sta.setString(4, apemat);
                sta.setString(5, nombres);
                sta.setString(6, fecha_nac);
                sta.setString(7, sexo);
                sta.setString(8, email);
                sta.setInt(9, espaciente);
                sta.setInt(10, espersona);
                sta.setInt(11, esmedico);
                sta.setTimestamp(12, getCurrentTimeStamp());
                sta.setInt(13, estado);
                sta.setInt(14, Integer.parseInt(id));
                sta.executeUpdate();

                response.sendRedirect("ServletPacientes");

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
