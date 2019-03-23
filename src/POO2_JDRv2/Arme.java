package POO2_JDRv2;

public class Arme extends Equipement{

    // classe arme : elle defini tous les equipement que l'on peut porter en main (bouclier inclus)

    // variable qui indique le nombre de main nessecaire au maniement de l'arme (max 2 ....)
    private int nbrMain ;

    // constructeur complet, les variables sont entrées à la main
    public Arme (String nom, int bonusAttaque, int bonusDefence, int nbrMain ){

        super(nom,bonusAttaque,bonusDefence);
        this.nbrMain = nbrMain;

    }

    // constructeur servant à instentier toutes les armes près etablis (voir collectionArme et POO2_JDRv2.Armurerie)
    public Arme (CollectionArme nouvelleArme){

        super(nouvelleArme.getNom(),nouvelleArme.getBonusAttaque(),nouvelleArme.getBonusDefence());
        this.nbrMain = nouvelleArme.getNbrMain();

    }


    // Getter -----------------------------
    public int getNbrMain() {
        return nbrMain;
    }

    // Setter -----------------------------
    public void setNbrMain(int nbrMain) {
        this.nbrMain = nbrMain;
    }


}
