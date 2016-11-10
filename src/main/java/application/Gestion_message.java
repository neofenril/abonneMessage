/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import static application.Gestion_abonne.addParticulier;
import static application.Gestion_abonne.connectionAbonne;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yohann
 */
public class Gestion_message extends HttpServlet{
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher("/WEB-INF/IHM_message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/IHM_message.jsp").forward(request, response);
    }
}
