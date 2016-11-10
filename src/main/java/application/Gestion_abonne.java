/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objets_metiers.Abonne;
import objets_metiers.Particulier;

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
                    addParticulier(request);
                    break;
                case "connection":
                    connectionAbonne(request);
                    break;
            }
        }
 
        this.getServletContext().getRequestDispatcher("/WEB-INF/IHM_abonne.jsp").forward(request, response);
    }

    public static void addParticulier(HttpServletRequest request) {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");

        boolean abonneExiste = Abonne.abonneExiste(login);
        
        if (nom != null && prenom != null && login != null && mdp != null && abonneExiste!=true) {
            Particulier.addParticulier(nom, prenom, login, mdp);
        }
    }
    
    public static void connectionAbonne(HttpServletRequest request){
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        
        Abonne abonneExiste = Abonne.connectionAbonne(login, mdp);
            
        if(abonneExiste != null){
            request.setAttribute("abonne", abonneExiste);
            System.out.println(abonneExiste);
        }
    }
}
