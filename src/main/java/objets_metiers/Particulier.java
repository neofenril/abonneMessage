/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets_metiers;

import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class Particulier extends Abonne{
    private int id;
    private String nom;
    private String prenom;
    
    public Particulier(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static void addParticulier(String nom, String prenom, String login, String mdp){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Particulier nvParticulier = new Particulier();
        nvParticulier.setNom(nom);
        nvParticulier.setPrenom(prenom);
        nvParticulier.setLogin(login);
        nvParticulier.setMdp(mdp);
        session.save(nvParticulier);
        
        session.getTransaction().commit();
        session.close();
    }
}
