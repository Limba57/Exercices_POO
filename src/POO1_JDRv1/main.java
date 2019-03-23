package POO1_JDRv1;

import java.util.HashMap;
import java.util.Scanner;

public class main {

    public static void ranger(Equipement nouveau, HashMap<String, Equipement> map){

        map.put(nouveau.nom, nouveau);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int race;
        int ennemi;
        int compteur;
        String nom;
        String pause;
        HashMap<String, Equipement> armurerie = new HashMap<>();
        Personnage Perso = new Personnage();
        Personnage Ennemi = new Personnage();
        Personnage Gagnant = new Personnage();
        Personnage Perdant = new Personnage();
        int choixEquipement;


        // Creation arme et amurerie

        // epee
        Epee epeeADeuxMain = new Epee("epee a deux mains", 10, -5);
        ranger(epeeADeuxMain, armurerie);
        Epee epeeAUneMain = new  Epee( "epee a une POO1_JDRv1.main",4,0);
        ranger(epeeAUneMain, armurerie);
        Epee katana = new Epee("katana", 2,2);
        ranger(katana, armurerie);

        // armure
        Armure armureLourde = new Armure("armure lourde", -5, 10);
        ranger(armureLourde, armurerie);
        Armure armureMoyenne = new Armure("armure moyenne", 0, 5);
        ranger(armureMoyenne, armurerie);
        Armure armureLegere = new Armure("armure legere", 2,2);
        ranger(armureLegere, armurerie);

        // baton
        Baton batonAttaque = new Baton("baton de feu",5,0);
        ranger(batonAttaque, armurerie);
        Baton batonDefence = new Baton("baton de pierre", 0,5);
        ranger(batonDefence, armurerie);

        // POO1_JDRv1.Pendentif
        Pendentif pendentifAttaque = new Pendentif("collier de force", 2, 0);
        ranger(pendentifAttaque, armurerie);
        Pendentif pendentifDefence = new Pendentif("collier de resistence", 0,2);
        ranger(pendentifDefence, armurerie);

        // Creation de Legolas
        Elfes Legolas = new Elfes("Legolas");
        Legolas.putInventaire(katana);
        Legolas.putInventaire(armureMoyenne);
        Legolas.putInventaire(katana);

        Legolas.equipementObjet(0);
        Legolas.equipementObjet(1);
        Legolas.equipementObjet(2);

        // Creation de Gandalf
        Humain Gandalf = new Humain("Gandalf");
        Gandalf.putInventaire(batonAttaque);
        Gandalf.putInventaire((batonDefence));
        Gandalf.putInventaire(pendentifDefence);

        Gandalf.equipementObjet(0);
        Gandalf.equipementObjet(1);
        Gandalf.equipementObjet(2);

        // Creation de Gnu
        Orc Gnu = new Orc("Gnu");
        Gnu.putInventaire(epeeADeuxMain);
        Gnu.putInventaire(armureLourde);
        Gnu.putInventaire(pendentifAttaque);

        Gnu.equipementObjet(0);
        Gnu.equipementObjet(1);
        Gnu.equipementObjet(2);

        // Creation du combatant
        System.out.println("Creez votre combattant");
        do {
            System.out.println("Choisissez sa race :");
            System.out.println("1 Elfe");
            System.out.println("2 POO1_JDRv1.Humain");
            System.out.println("3 POO1_JDRv1.Orc");
            race = sc.nextInt();
            //sc.nextLine();
        }while (race != 1 && race != 2 && race != 3);

        System.out.println("Choisissez son nom :");
        sc.nextLine();
        nom = sc.nextLine();

        switch (race){
            case 1 :
                 Perso = new Elfes(nom);
                break;
            case 2 :
                 Perso = new Humain(nom);
                break;
            case 3 :
                  Perso = new Orc(nom);
                break;
            default:
                System.out.println("erreur");

        }

        Perso.afficherPersonnage();


        // Choix equipement
        Equipement choix[] = new Equipement[armurerie.size()];

        do {
            do {
                System.out.println("choisissez votre equipement");
                compteur = 0;
                for (String temp : armurerie.keySet()) {
                    choix[compteur] = armurerie.get(temp);
                    System.out.println((compteur + 1) + " --> " + armurerie.get(temp).nom);
                    compteur += 1;
                }
                System.out.println((compteur+1)+" -->  pour sortir");
                choixEquipement = (sc.nextInt() - 1);
                if (choixEquipement < choix.length) {
                    if (Perso.placeInventaire(choix[choixEquipement])) ;
                    {
                        System.out.println("vous avez choisi " + choix[choixEquipement].nom);
                        Perso.affInventaire();
                    }
                }
            } while (choixEquipement+1 < armurerie.size());

        }while (choixEquipement != choix.length);

        // Mettre equipement

        for (int i = 0 ; i< Perso.sac.length ; i++)
            Perso.equipementObjet(i);









        // Choix ennemi
        do{
            System.out.println("choisissez un enemi a affronter");
            System.out.println("-------------------------------");
            System.out.println("1 --> Legolas");
            System.out.println("-------------------------------");
            System.out.println("2 --> Gandalf");
            System.out.println("-------------------------------");
            System.out.println("3 --> Gnu");

            ennemi = sc.nextInt();
        }while(ennemi != 1 && ennemi != 2 && ennemi != 3);

        switch (ennemi){
            case 1 :
                Ennemi = Legolas;
                break;
            case 2 :
                Ennemi = Gandalf;
                break;
            case 3 :
                Ennemi = Gnu;
                break;
            default:
                System.out.println("erreur");

        }


        // Combat
        Ennemi.afficherPersonnage();
        Ennemi.affInventaire();
        Ennemi.crier();
        pause = sc.nextLine();
        // Boucle de combat
        while (Perso.vivant && Ennemi.vivant){
            Perso.attaquer(Ennemi);
            Ennemi.attaquer(Perso);
            Perso.afficherPersonnage();
            Ennemi.afficherPersonnage();
            pause = sc.nextLine();
            if (Perso.vivant == false){
                Perdant = Perso;
                Gagnant = Ennemi;
            }
            if (Ennemi.vivant == false){
                Perdant = Ennemi;
                Gagnant = Perso;
            }
        }

        // Message de fin de combat
        System.out.println(Gagnant.nom+" a défoncé "+Perdant.nom+" fin du combat");


    }// fin POO1_JDRv1.main


}
