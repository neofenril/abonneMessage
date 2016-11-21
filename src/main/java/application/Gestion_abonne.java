/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objets_metiers.Abonne;
import objets_metiers.Particulier;
import objets_metiers.Entreprise; 
import objets_metiers.Message;

/**
 *
 * @author Yohann
 */
public class Gestion_abonne extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher("/WEB-INF/IHM_abonne.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("gestion_abonne");

        if (action != null) {
            switch (action) {
                case "ajout":
                    addAbonne(request);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/IHM_abonne.jsp").forward(request, response);
                    break;
                case "connection":
                    connectionAbonne(request);
                    List<HashMap> messages = Message.getMessages();
                    request.setAttribute("messages", messages);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/IHM_message.jsp").forward(request, response);
                    break;
            }
        }

    }

    public static void addAbonne(HttpServletRequest request) {
        String typeAbonne = request.getParameter("typeAbonne");
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        boolean abonneExiste = Abonne.abonneExiste(login);
        
        if (!typeAbonne.equals("raison_sociale")) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");

            if (nom != null && prenom != null && login != null && mdp != null && abonneExiste != true) {
                Particulier.addParticulier(nom, prenom, login, mdp);
            }
        } else {
            String rs = request.getParameter("raison_sociale");

            if (rs != null && login != null && mdp != null && abonneExiste != true) {
                Entreprise.addEntreprise(rs, login, mdp);
            }
        }
    }

    public static void connectionAbonne(HttpServletRequest request) {
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");

        Abonne abonneExiste = Abonne.connectionAbonne(login, mdp);

        if (abonneExiste != null) {
            request.setAttribute("abonne", abonneExiste.getId());
        }
    }
}
