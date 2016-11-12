/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets_metiers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class Abonne {
    private int id;
    private String mdp;
    private String login;
    private Set<Message> lesMessages = new HashSet<Message>();
    
    public Abonne(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public static void addAbonne(){
        
    }

    public Set<Message> getLesMessages() {
        return lesMessages;
    }

    public void setLesMessages(Set<Message> lesMessages) {
        this.lesMessages = lesMessages;
    }
    
    public static Abonne connectionAbonne(String login, String mdp){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        String hql = "SELECT a FROM Abonne a WHERE a.login=:login AND a.mdp=:mdp";
        Query query = session.createQuery(hql);
        query.setParameter("login", login);
        query.setParameter("mdp", mdp);
        List results = query.list();
        
        session.getTransaction().commit();
        session.close();
        
        if(results.isEmpty()){
            return null;
        }else{
            return (Abonne)results.get(0);
        }
    }
    
    public static boolean abonneExiste(String login){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        String hql = "SELECT a FROM Abonne a WHERE a.login=:login";
        Query query = session.createQuery(hql);
        query.setParameter("login", login);
        List results = query.list();
        
        session.getTransaction().commit();
        session.close();
        
        if(results.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
