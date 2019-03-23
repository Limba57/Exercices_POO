package POO4_Librairie;

public class Utilisateur {

    String nom;              // nom de l'utilisateur
    String adresseMail;      // mail de l'utilisateur

    // constructeur par defaut
    public Utilisateur(){

        this.nom = null;
        this.adresseMail = null;

    }

    // constructeur complet
    public Utilisateur(String nom, String adresseMail) {
        this.nom = nom;
        this.adresseMail = adresseMail;
    }

    // affichage de l'utilisateur
    public String toString(){

        return "\nNom : "+this.nom+"\nadresse Mail : "+this.adresseMail+"\n";

    }
}
