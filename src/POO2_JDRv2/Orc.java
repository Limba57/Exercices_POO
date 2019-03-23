package POO2_JDRv2;

public class Orc implements Race {


    // variable booleen qui dit si le pouvoir est dispo ou pas (une fois par partie)
    private boolean utilisationPouvoir = true ;

    @Override
    // donne 50 de bonus si l'adversaire est un elfes sans bouclier --> retourne true
    // sinon retourne faux
    public int BonusAttaque(Personnage perso,Personnage adversaire) {

        if (adversaire.getRace() instanceof Elfe){
            boolean testBouclier = false;
            for (int i = 0 ; i < adversaire.getDansLesMains().size() ; i++){
                String str = (adversaire.getDansLesMains().get(i).getNom());
                if (str.equals("bouclier")) {
                    testBouclier = true;
                }
            }
            if (!testBouclier) {
                System.out.println("je vais te pulveriser sale POO2_JDRv2.Elfe !!!");
                return 50;
            }
            else {
                System.out.println("T'as raison cache toi ton bouclier oreille pointue ou je te defonce");
                return 0;
            }
        }
        return 0;
    }

    @Override
    // peut parer mais pert 2 point de defence naturel --> return true
    // verification du total de defence naturel --> si zero on ne vas pas plus loin
    public boolean parer(Personnage perso, Personnage adversaire) {
        if( perso.getDefense() < 2) {
            perso.setDefense(0);
            System.out.println("Ma peau est trop blessée pour en supporter d'avantage ... Je dois encaissé");
            return false;
        }
        else{
            perso.setDefense(perso.getDefense()-2);
            System.out.println("Ma peau épaisse encaisse mais elle accuse la coup malus de 2 en defence ... il me reste "+perso.getDefense()+" point de defence");
            return true;
        }

    }

    @Override
    // a revoir, le bonus est permenant, il doit s'annuler une fois le combat fini --> voir avec la classe combat ...
    public boolean pouvoir(Personnage perso) {

        this.utilisationPouvoir = false ;
        System.out.println("mode Berseker !!!! bonus attaque +5");
        perso.setAttaque(perso.getAttaque()+5);
        return false ;
    }

    @Override
    public String descriptionPouvoir() {
        return "Votre pouvoir vous apporte 5 pts de bonus en attaque";
    }

    @Override
    public String toString() {
        return "POO2_JDRv2.Orc";
    }

    public boolean isUtilisationPouvoir() {
        return utilisationPouvoir;
    }

    public void setUtilisationPouvoir(boolean utilisationPouvoir) {
        this.utilisationPouvoir = utilisationPouvoir;
    }
}



