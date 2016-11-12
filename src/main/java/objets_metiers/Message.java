/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets_metiers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class Message {
    private int id;
    private String objet;
    private String corps;
    private Abonne abonne;
    
    public Message(){}

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }
    
    public static void addMessage(int idAbonne, String objet, String corps){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Message nvMessage = new Message();
        nvMessage.setObjet(objet);
        nvMessage.setCorps(corps);
        Abonne abonne = session.load(Abonne.class, idAbonne);
        nvMessage.setAbonne(abonne);
        session.save(nvMessage);
        
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<HashMap> getMessages(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        String hql = "SELECT m FROM Message m ORDER BY m.id desc";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        List res = new ArrayList<Message>();
        for(Object o: results){
            HashMap h = new HashMap<String, String>();
            h.put("objet", ((Message)o).getObjet());
            h.put("corps", ((Message)o).getCorps());
            h.put("login", ((Message)o).getAbonne().getLogin());
            res.add(h);
        }
        session.close();
        

        
        return res;
    }
}
