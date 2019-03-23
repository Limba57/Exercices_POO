package POO2_JDRv2;

public class Voleur extends Metier {

    public Voleur(){

        super();
        bonusAttaqueMetier = 2 ;
        bonusPvMetier = -10 ;

    }

    public Voleur(int xp){

        super(xp);

    }


    public void competence(Personnage perso,Personnage enemi) {

        super.competence(perso,enemi);

        int essaiDeVol;

        System.out.println("Tentative de vol ......");
        essaiDeVol = BoiteAOutils.aleatoire(1,6);

        if (essaiDeVol  <= 4){

            System.out.println("REUSSI !!!");
            System.out.println("Voici ce que votre adversaire à dans les mains ....");
            System.out.println(enemi.afficheArmes());

            if (enemi.getDansLesMains().size() != 0){
                for (int i = 0 ; i < enemi.getDansLesMains().size() ; i++){
                    boolean oui;
                    oui = BoiteAOutils.question("Voulez-vous voler cette arme : "+enemi.getDansLesMains().get(i).getNom()+" ?");
                    if (oui)
                        enemi.retraitBonusEquipement(enemi.getDansLesMains().get(i));
                }
            }

        }
        else {

            System.out.println("Loupé ..."+enemi.getNom()+" vous voit arrivé et enchaine un contre .... 10 pts de degat");
            System.out.println(perso.afficheStat());
            perso.degat(10);

        }


    }

    @Override
    String descriptionCompetence() {
        return "Votre competence vous permet de voler une des armes de votre adversaire";
    }
}