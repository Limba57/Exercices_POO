package POO4_Librairie;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Livre {

    private String titre;                 // titre du livre
    private String dateDePublication;     // date de publication
    private Genre genre;                  // genre de livre (enum)
    private double prix;                  // prix unitaire du livre
    private Auteur auteur[];              // liste des auteurs

    // constructeur par defaut
    public Livre(){

        this.titre = null;
        this.dateDePublication = null;
        this.genre = null;
        this.prix = 0;
        this.auteur = null;

    }

    // constructeur complet
    public Livre(String titre, String dateDePublication, Genre genre, double prix, Auteur...auteur) {
        this.titre = titre;
        this.dateDePublication = dateDePublication;
        this.genre = genre;
        this.prix = prix;
        this.auteur = auteur;
    }

    // affiche la liste des auteurs
    public String afficheAuteur(){

        String liste = "";

       for (Auteur  a : auteur){
           liste = liste+a.toString();
       }

       return liste;
    }

    // affiche un condensé des infos du livre(titre et prix)
    public String afficheCondense(){

        return "Titre : "+this.titre+"\nPrix : "+this.prix;

    }

    // affichage de toutes les infos du livre
    public String toString(){

        return "Titre : "+this.titre+"\nDate de publication : "+this.dateDePublication+"\nPOO4_Librairie.Genre : "+this.genre.toString()+"\nPrix : "+this.prix+"\nPOO4_Librairie.Auteur(s) : \n"+this.afficheAuteur()+"\n";

    }

    public double getPrix() {
        return prix;
    }

    public String getTitre() {
        return titre;
    }
}
