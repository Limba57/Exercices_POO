package POO2_JDRv2;

public class Collier extends Equipement{

    // classe décrivant les colliers, ils sont simplement des equipements donnant de faible bonus
    // trés semblable à equipement de base

    // constructeur avec les variables entrées à la main
    public Collier(String nom, int bonusAttaque, int bonusDefence){

        super(nom,bonusAttaque,bonusDefence);

    }

    // constructeur utilisant l' enum collectionCollier --> collection instencié en debut de main
    public Collier(CollectionCollier nouveauCollier){

        super(nouveauCollier.getNom(),nouveauCollier.getBonusAttaque(),nouveauCollier.getBonusDefence());

    }


}
