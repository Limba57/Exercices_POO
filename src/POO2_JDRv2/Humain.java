package POO2_JDRv2;

public class Humain implements Race {

    // variable booleen qui dit si le pouvoir est dispo ou pas (une fois par partie)
    private boolean utilisationPouvoir = true ;

    @Override
    // donne un bonus d'attaque de + 3 si le personnage n'a pas d'arme dans les mains et return true
    // sinon retourne false
    public int BonusAttaque(Personnage perso,Personnage adversaire) {
        if (perso.getMains() == 2) {
            System.out.println("le kung fu est en moi !!!, j'ai 3 point d'attaque en plus ");
            return 3;
        }
        else
            return 0;
    }

    @Override
    // peut parer tout les coup d'un elfe et 50% des orcs et des humains
    public boolean parer(Personnage perso ,Personnage adversaire) {

        if (adversaire.getRace() instanceof Elfe){

            return true;

        }
        else{

            int nombreAleatoire = BoiteAOutils.aleatoire(1,2);
            if (nombreAleatoire == 1)
                return false;
            else
                return true;

        }

    }

    @Override
    // pouvoir de l'humain --> + 20 points de vie
    public boolean pouvoir(Personnage perso) {

        this.utilisationPouvoir = false ;
        System.out.println("premier soin --> pV +20");
        perso.setPv(perso.getPv()+20);
        return false ;

    }

    @Override
    public String descriptionPouvoir() {
        return "Votre pouvoir vous permet de soigner 20 pts de vie";
    }

    @Override
    public String toString() {
        return "POO2_JDRv2.Humain";
    }

    public boolean isUtilisationPouvoir() {
        return utilisationPouvoir;
    }

    public void setUtilisationPouvoir(boolean utilisationPouvoir) {
        this.utilisationPouvoir = utilisationPouvoir;
    }
}
