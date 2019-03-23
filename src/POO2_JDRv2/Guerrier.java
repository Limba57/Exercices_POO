package POO2_JDRv2;

public class Guerrier extends Metier{

    public Guerrier(){

        super();

    }

    public Guerrier(int xp){

        super(xp);

    }


    // decrit l'attribut du metier relatif au points de vie, pour le guerrier +10
    public int secondSouffle(){

        System.out.println("SECOND SOUFFLE !!!!");
        System.out.println("C'est pas gagné ... encore un peu d'energie !!!");
        return 10 ;

    }

    public void competence (Personnage perso,Personnage enemi){

        super.competence(perso,enemi);

        System.out.println("FEROCITEE !!!");
        System.out.println("Plus "+perso.getDansLesMains().size()+" points d'attaque");
        perso.setAttaque(perso.getAttaque()+perso.getDansLesMains().size());

    }

    @Override
    String descriptionCompetence() {
        return "Votre competence vous permet de d'améliorer votre attaque selon votre équipement";
    }
}
