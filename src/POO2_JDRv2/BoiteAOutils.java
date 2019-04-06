package POO2_JDRv2;

import java.util.Scanner;

public abstract class BoiteAOutils {

    // ici sont toute les fonctions qui me servent partout dans mon code, main classe ....

    // genere aleatoirrement une race et un metier a un personnage, l'equipement est donné en fonction du metier
    public static Personnage generationAleatoireEnnemi (String nom){

        int choixRace = aleatoire(1,3);
        Race raceAleat;
        int xp = BoiteAOutils.aleatoire(10,80);

        switch (choixRace){
            case 1 :
                raceAleat = new Humain();
                break ;
            case 2 :
                raceAleat = new Orc() ;
                break ;
            case 3 :
                raceAleat = new Elfe() ;
                break ;
            default :
                raceAleat = new Humain() ;
        }

        int choixMetier = aleatoire(1,3);
        Metier metierAleat;

        switch ( (choixMetier)){
            case 1 :
                metierAleat = new Guerrier(xp);

                break;
            case 2 :
                metierAleat = new Mage(xp);
                break;
            case 3 :
                metierAleat = new Voleur(xp);
                break ;
            default :
                metierAleat = new Guerrier(xp);
        }

        Personnage Ennemi = new Personnage(nom, raceAleat, metierAleat);

        Armurerie armurerie = new Armurerie();

        Ennemi = armurerie.equipementAleatoire(Ennemi);

        return Ennemi;

    }

    // generation aleatoire d' un nombre entre mini et maxi inclus
    public static int aleatoire (int mini ,int maxi){

        int nombreAleatoire = mini + (int)(Math.random() * ((maxi - mini) + 1));
        return nombreAleatoire;
    }

    // pose la question donné en parametre et attent une reponse 'o' ou 'n' --> retoure un booleen true = oui, false = non
    public static boolean question (String question){

        Scanner sc = new Scanner(System.in);
        char reponse;

        do{
            System.out.println(question+" (o/n) :");
            try {

                reponse = sc.nextLine().charAt(0);

            }catch (Exception e){

                reponse = 'u';

            }

        }while (reponse != 'o' && reponse != 'n');

        if (reponse == 'o')
            return true;
        else
            return false;


    }

    // generation d'un Hero
    public static Personnage generationDuHeros(){

        Scanner sc = new Scanner(System.in);
        String nom;
        int reponseRace;
        int reponseMetier;
        Race race;
        Metier metier;
        Personnage perso;


        System.out.println("Il est temps de créer votre heros !");
        System.out.println("\nChoisisez votre nom :");
        nom = sc.nextLine();
        System.out.println("\nChoisisez votre race :");

        do {
            System.out.println("1 POO2_JDRv2.Humain");
            System.out.println("2 POO2_JDRv2.Elfe");
            System.out.println("3 POO2_JDRv2.Orc");

            try {

                reponseRace = sc.nextInt();

            }catch (Exception e){

                reponseRace = 0;
                sc.nextLine();

            }

        }while (reponseRace != 1 && reponseRace != 2 && reponseRace != 3);

        switch (reponseRace){
            case 1 :
                race = new Humain();
                break;
            case 2 :
                race = new Elfe();
                break;
            case 3 :
                race = new Orc();
                break;
            default :
                race = new Humain();
        }
        System.out.println("\nChoisisez votre Metier :");

        do{
            System.out.println("1 Mage");
            System.out.println("2 Voleur");
            System.out.println("3 Guerrier");
            sc.nextLine();

            try {

                reponseMetier = sc.nextInt();

            }catch (Exception e){

                reponseMetier = 0;
                sc.nextLine();
            }

        }while (reponseMetier != 1 && reponseMetier != 2 && reponseMetier != 3);

        switch (reponseMetier){
            case 1 :
                metier = new Mage();
                break;
            case 2 :
                metier = new Voleur();
                break;
            case 3 :
                metier = new Guerrier();
                break;
            default:
                metier = new Guerrier();
        }

        perso = new Personnage(nom,race,metier);
        System.out.println("\nVoici votre avatar :");
        System.out.println(perso);
        return perso;


    }

}
