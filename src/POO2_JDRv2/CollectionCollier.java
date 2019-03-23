package POO2_JDRv2;

public enum CollectionCollier implements Stock{

    /*
     Ici se trouve toutes les colliers dispo pour le jeux, il suffit de les ajouter
     selon le constructeur et elles seront dispo ds le main sous forme d'objet et de variable nommée.
     Une "base de donnée" des colliers mise a disposition du joueur
    */

    CollierFeu ("Collier de feu", +3, 0),
    CollierPierre ("POO2_JDRv2.Collier de pierre", 0, 3);

    private final String nom;
    private final int bonusAttaque, bonusDefence;

    CollectionCollier(String nom, int bonusAttaque, int bonusDefence){
        this.nom = nom;
        this.bonusAttaque = bonusAttaque;
        this.bonusDefence = bonusDefence;
    }

    public String getNom() {
        return nom;
    }

    public int getBonusAttaque() {
        return bonusAttaque;
    }

    public int getBonusDefence() {
        return bonusDefence;
    }
}
