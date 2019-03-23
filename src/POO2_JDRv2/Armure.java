package POO2_JDRv2;

public class Armure extends Equipement{

    // classe decrivant les armures, trés semblable à equipement de base

    // constructeur avec tout les parametres entrés à la main
    public Armure(String nom, int bonusAttaque, int bonusDefence){

        super(nom, bonusAttaque,bonusDefence);

    }

    // constructeur se servant des enum collection armures (voir POO2_JDRv2.CollectionArmure et Armurerie)
    public Armure(CollectionArmure nouvelleArmure){

        super(nouvelleArmure.getNom(), nouvelleArmure.getBonusAttaque(), nouvelleArmure.getBonusDefence());

    }

    }

