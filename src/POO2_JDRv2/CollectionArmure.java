package POO2_JDRv2;

public enum CollectionArmure implements Stock{

    /*
     Ici se trouve toutes les armures dispo pour le jeux, il suffit de les ajouter
     selon le constructeur et elles seront dispo ds le main sous forme d'objet et de variable nommée.
     Une "base de donnée" des armures mise a disposition du joueur
    */

    ArmureLourde("armure lourde", -5, 15),
    ArmureMoyenne("armure moyenne", 0, 7),
    ArmureLegere("armure legere", 1, 5),
    RobeDeMagicien("robe de magicien",0,4);

    private final String nom;
    private final int bonusAttaque, bonusDefence;

    CollectionArmure(String nom, int bonusAttaque, int bonusDefence){

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
