package POO4_Librairie;

import java.io.Serializable;

public class Auteur {

    private String nom;               // nom de l'auteur
    private Sexe sexe;                // sexe de l'auteur
    private String dateDeNaissance;   // date de naissance de l'auteur

    // constructeur par defaut
    public Auteur(){

        this.nom = null;
        this.sexe = null;
        this.dateDeNaissance = null;

    }

    // constructeur complet
    public Auteur(String nom, Sexe sexe, String dateDeNaissance){

        this.nom = nom;
        this.sexe = sexe;
        this.dateDeNaissance = dateDeNaissance;

    }

    // toString ...
    public String toString(){
        return "nom : "+this.nom+"\nsexe : "+this.sexe+"\nDate de naissance : "+this.dateDeNaissance+"\n";
    }

}
