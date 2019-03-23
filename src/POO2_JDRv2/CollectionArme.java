package POO2_JDRv2;

public enum CollectionArme implements Stock {

    /*
     Ici se trouve toutes les armes dispo pour le jeux, il suffit de les ajouter
     selon le constructeur et elles seront dispo sous forme d'objet et de variable nommée.
     Une "base de donnée" des armes mise a disposition du joueur
    */


    EpeeADeuxMain("epée à deux mains",15,-5,2),
    EpeeAUneMain("epée à une main", 5,-1,1),
    Katana("katana", 2,2,1),
    Baton("baton", 2,2,2),
    Bouclier("bouclier",1,7,1);



    private final String nom;
    private final int bonusAttaque, bonusDefence, nbrMain;

    CollectionArme(String nom, int bonusAttaque,int bonusDefence, int nbrMain){

        this.nom = nom;
        this.bonusAttaque = bonusAttaque;
        this.bonusDefence = bonusDefence;
        this.nbrMain = nbrMain;

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

    public int getNbrMain() {
        return nbrMain;
    }
}