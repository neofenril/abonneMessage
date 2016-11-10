/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets_metiers;

/**
 *
 * @author Yohann
 */
public class Entreprise extends Abonne{
    private int id;
    private String raisonSociale;
    
    public Entreprise(){}

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSocial) {
        this.raisonSociale = raisonSocial;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
