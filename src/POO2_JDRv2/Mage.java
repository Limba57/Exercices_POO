package POO2_JDRv2;

public class Mage extends Metier{

    public Mage(){

        super();

    }

    public Mage(int xp){

        super(xp);

    }

    @Override
    public void competence(Personnage perso, Personnage enemi) {

        super.competence(perso,enemi);

        System.out.println("Sort de soin !!!");
        perso.setPv(perso.getPv()+5);
        System.out.println("gain de 5 pv pour un total de "+perso.getPv());

    }

    @Override
    String descriptionCompetence() {
        return "Votre competence vous permet de lancer un sort de soin";
    }
}
