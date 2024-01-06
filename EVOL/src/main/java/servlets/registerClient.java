/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mainClasses.JSON_Converter;
import tables.ClientTable;

/**
 *
 * @author tzeor
 */
public class registerClient extends HttpServlet {


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

        JSON_Converter jc = new JSON_Converter();
        String user = jc.getJSONFromAjax(request.getReader());

        ClientTable client = new ClientTable();
        System.out.println(user);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            client.addClientFromJSON(user);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registerClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.setStatus(200);
        response.getWriter().write(user);


    }
}
