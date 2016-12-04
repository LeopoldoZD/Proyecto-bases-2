/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexion;

/**
 *
 * @author rapid
 */
public class ServletAutenticar extends HttpServlet {

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");
            //response.setContentType("application/msword");
            PrintWriter salida=      response.getWriter();
            //Le pedimos los valores al cliente
            String login=  request.getParameter("login");
            String password=  request.getParameter("password");
            
        try {
           
            Conexion.conectarse(login, password);
 RequestDispatcher despachador=request.getRequestDispatcher("/bienvenido.html");
 despachador.forward(request, response);
        } catch (Exception ex) {
           
      RequestDispatcher despachador=request.getRequestDispatcher("/error.html");
 despachador.forward(request, response);
    
          }
    }
}