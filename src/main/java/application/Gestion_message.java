/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objets_metiers.Abonne;
import objets_metiers.Message;

/**
 *
 * @author Yohann
 */
public class Gestion_message extends HttpServlet{
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HashMap> messages = Message.getMessages();
        request.setAttribute("messages", messages);
        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher("/WEB-INF/IHM_message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String objet = request.getParameter("objet");
        String corps = request.getParameter("message");
        int abonne = Integer.valueOf(request.getParameter("abonne"));
        
        if (objet != null && corps != null) {
            Message.addMessage(abonne, objet, corps);
        }
        
        List<HashMap> messages = Message.getMessages();
        request.setAttribute("messages", messages);
        this.getServletContext().getRequestDispatcher("/WEB-INF/IHM_message.jsp").forward(request, response);
    }
}
