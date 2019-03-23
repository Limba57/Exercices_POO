package POO2_JDRv2;

import java.util.Scanner;

public class Combat {

    // classe permettant d'instencier un combat

    Personnage perso ;
    Personnage ennemi ;
    boolean fuiteCombat ;
    int attaquePerso;
    int defencePerso;


    // constructeur de la classe POO2_JDRv2.Combat, prend en parametre deux POO2_JDRv2.Personnage et appele directement la methode fight
    public Combat (Personnage perso, Personnage ennemi){

        this.perso = perso;
        this.ennemi = ennemi;
        fuiteCombat = false;
        attaquePerso = perso.getAttaque();
        defencePerso = perso.getDefense();
        this.fight();

    }

    // methode fight qui boucle les round en alternant defenseur et attaquant jusqu'a la mort ou la fuite d'un des Personnage
    private Personnage fight (){

        // variable contennant le vainqueur du combat
        Personnage vainqueur;
        // variable contennant le perdant du combat
        Personnage perdant;
        // variable definissant le gain d' xp au terme du combat
        int gainXp;
        // variable prenant la valeur retourné par la methode round --> sert a savoir si le combat continue
        boolean nextRound ;

        // alterne les round entre deux personnage tant que l'un d'entre eux est vivant
        if (!fuiteCombat){
            do{
                nextRound = round(perso,ennemi);
                if(!fuiteCombat) {
                    if (nextRound) {
                        nextRound = round(ennemi, perso);
                    }
                }
            }while (nextRound  && !fuiteCombat);
        }


        System.out.println("Fin du combat");
        if (perso.isVivant()) {
            vainqueur = perso;
            perdant = ennemi;
        }
        else {
            vainqueur = ennemi;
            perdant = perso;
        }

        System.out.println(vainqueur.getNom()+" a remporter le combat !!");
        System.out.println(perdant.getNom()+" s'est fait défoncer...");

        if (vainqueur.getMetier().getNiveau()<perdant.getMetier().getNiveau())
            gainXp = 10;
        else
            gainXp = 5;

        vainqueur.getMetier().gainXp(gainXp);
        System.out.println(vainqueur);

        // A la fin du combat si c'est le hero qui gagne ses points d'attaque et de defence naturel sont re setter
        // ceci pour pouvoir enchainer les combats et rendre le jeu un peu plus facile
        if (perso.isVivant()){

            System.out.println("Vous regagnez vos points de defence et d'attaque");
            System.out.println("Non non pas les points de vie ...");
            perso.setAttaque(attaquePerso);
            perso.setDefense(defencePerso);

        }

        return vainqueur;
    }

    // methode round qui prend en parametre un attaquant et un defenseur
    // Ajoute les bonus/malus de race
    // Demande à l'attaquant si il veut utiliser son pouvoir (si il ne l'a pas deja utiliser)
    // Demande à l'attaquant si il veut utiliser sa compétance metier si oui il pert l'initiative
    // Demande au defenseur si il veut parer l'attaque et applique en fonction du retour les bonus/malus
    private boolean round (Personnage attaquant, Personnage defenseur){

        // variables locales
        boolean reponseParade ;
        boolean reponsePouvoir ;
        boolean reponseCompetence ;

        // calcul du total d'attaque de l' attaquand naturel + equipement + bonus/malus de race
        int forceAttaquant = attaquant.getAttaque() + attaquant.getBonusAttaque() + attaquant.getRace().BonusAttaque(attaquant,defenseur);
        System.out.println("\n"+attaquant.getNom()+" attaque avec un total de "+forceAttaquant);

        // calcul du total de defense du defenseur naturel + equipement + bonus/malus de race
        int forceDefenseur = defenseur.getDefense() + defenseur.getBonusDefense() ;
        System.out.println(defenseur.getNom()+" se defend avec un total de "+forceDefenseur);

        // Déclaration du personnage ayant l'initiative
        System.out.println("\nC'est a "+attaquant.getNom()+" d'attaquer");

        // Demande si utilisation du pouvoir (si celui ci est disponible)
        if (attaquant.getRace().isUtilisationPouvoir()){
            System.out.println(attaquant.getRace().descriptionPouvoir());
            reponsePouvoir = BoiteAOutils.question(attaquant.getNom()+" voulez vous utiliser votre pouvoir ?");
            if (reponsePouvoir){
                fuiteCombat = attaquant.getRace().pouvoir(attaquant);
                if (fuiteCombat){
                    return true;
                }
            }
        }

        // Demande si utilisation de la competance de metier de classe
        System.out.println(attaquant.getMetier().descriptionCompetence());
        reponseCompetence = BoiteAOutils.question("voulez vous utiliser votre compétence de metier");
        if (reponseCompetence){
                attaquant.getMetier().competence(attaquant,defenseur);
                return true;
        }

        // Demande si tentative de parer le coup
        reponseParade = BoiteAOutils.question(defenseur.getNom()+" voulez vous parer ?");

        // si oui à la question --> fonction parer de la race retourne un booleen et applique les differents bonus/malus
        // retourne un booleen si la parade est reussi : true --> bonus forcedefenseur +10, false --> rien
        if (reponseParade) {

            if (defenseur.getRace().parer(defenseur, attaquant)) {
                System.out.println("esquive reussi");
                forceDefenseur += 10;
            } else
                System.out.println(defenseur.getNom()+" a loupé sont esquive");

        }



        // condition des rapport attaque defense et application des dégats

        // attaque sup à defence
        if (forceAttaquant >= forceDefenseur){

            // si la defence naturelle du defenseur est à 0 degat fois deux --> coup critique
            if (defenseur.getDefense() <= 0){
                System.out.println("Coup critique "+defenseur.getNom()+" prend directement "+forceAttaquant*2+" points de degat");
                defenseur.degat(forceAttaquant*2);
                defenseur.setDefense(0);

            }
            // sinon bonus de protection --> degat normaux
            else {
                System.out.println(attaquant.getNom()+" donne un coup normal a "+defenseur.getNom()+" il lui inflige "+forceAttaquant+" point de degat");
                defenseur.degat((forceAttaquant));
                defenseur.setDefense(defenseur.getDefense()-1);
                System.out.println(defenseur.getNom()+" a -1 en defence, la fatigue se fait sentir");
            }

        }

        // la defence est trop forte degat minoré
        else{
            defenseur.degat(forceAttaquant/2);
            System.out.println(defenseur.getNom()+" encaisse le coup, il ne prend que "+(forceAttaquant/2)+" point de degats");

        }
        if (defenseur.isVivant()) {
            System.out.println("\n" + attaquant.getNom() + " : " + attaquant.afficheStat());
            System.out.println("\n" + defenseur.getNom() + " : " + defenseur.afficheStat());
        }


        return defenseur.isVivant();

    }

}
