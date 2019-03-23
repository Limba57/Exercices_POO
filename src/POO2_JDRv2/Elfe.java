package POO2_JDRv2;

public class Elfe implements Race{

    // variable booleen qui dit si le pouvoir est dispo ou pas (une fois par partie)
    private boolean utilisationPouvoir = true ;

    @Override
    // bonus d'attaque de l'elfe --> +2 en attaque systematiquement
    public int BonusAttaque(Personnage perso,Personnage adversaire) {

        System.out.println("trop agile le gars, +2 en attaque");
        return 2;

    }

    @Override
    // peut parer mais pert 1 point d'attaque par utilisation
    // verifie aussi qu'il rest des point d'attaque si non --> return false et pas de bonus
    public boolean parer(Personnage perso, Personnage adversaire) {

        if( perso.getAttaque() < 1) {
            perso.setAttaque(0);
            System.out.println("epuiser par le combat...");
            return false;
        }
        else{
            perso.setAttaque(perso.getAttaque()-1);
            System.out.println("je fatigue, malus de 1 à l'attaque ... il me reste "+perso.getAttaque()+" points d'attaque");
            return true;
        }
    }

    @Override
    public boolean pouvoir(Personnage perso) {

        this.utilisationPouvoir = false ;
        System.out.println(perso.getNom()+" vous fuyez lachement ce combat, HONTE à vous");
        return true;

    }

    @Override
    public String descriptionPouvoir() {
        return "Votre pouvoir vous permet de fuir le combat...";
    }

    @Override
    public String toString() {
        return "Elfe";
    }

    public boolean isUtilisationPouvoir() {
        return utilisationPouvoir;
    }

    public void setUtilisationPouvoir(boolean utilisationPouvoir) {
        this.utilisationPouvoir = utilisationPouvoir;
    }
}


