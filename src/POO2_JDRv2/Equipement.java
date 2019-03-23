package POO2_JDRv2;

public class Equipement {

    // ici sont defini tous les points commun de la classe equipement

    // nom de l'équipement
    private String nom ;
    // bonus d'attaque qu'il proccure
    private int bonusAttaque ;
    // bonus de defence qu'il proccure
    private int bonusDefence ;

    // constructeur
    protected Equipement (String nom, int bonusAttaque,int bonusDefence){

        this.nom = nom;
        this.bonusAttaque = bonusAttaque;
        this.bonusDefence = bonusDefence;


    }

    // Getter --------------------------------------
    public String getNom() {
        return nom;
    }

    public int getBonusAttaque() {
        return bonusAttaque;
    }

    public int getBonusDefence() {
        return bonusDefence;
    }

    // Setter --------------------------------------
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBonusAttaque(int bonusAttaque) {
        this.bonusAttaque = bonusAttaque;
    }

    public void setBonusDefence(int bonusDefence) {
        this.bonusDefence = bonusDefence;
    }


}
