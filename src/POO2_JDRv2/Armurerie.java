package POO2_JDRv2;

import java.util.HashMap;
import java.util.Scanner;

public class Armurerie {

    HashMap<String, HashMap<Stock,Equipement>> ratelier;
    HashMap<Stock, Equipement> stockArme;
    HashMap<Stock, Equipement> stockArmure;
    HashMap<Stock, Equipement> stockCollier;

    // constructeur, permet d'instancier les differents Equipements dispo dans le jeu
    // les classent ds des hashmap elles meme classée
    // cette methode peut etre inutilement compliqué mais
    // je me suis un peu amusé a trituré tout cela pour faire une sorte de
    // base de donnée d' objet
    public Armurerie() {

        ratelier = new HashMap<>();
        stockArme = new HashMap<>();
        stockArmure = new HashMap<>();
        stockCollier = new HashMap<>();

        for (CollectionArme temp : CollectionArme.values())
            stockArme.put(temp, new Arme(temp));

        for (CollectionArmure temp : CollectionArmure.values())
            stockArmure.put(temp, new Armure(temp));

        for (CollectionCollier temp : CollectionCollier.values())
            stockCollier.put(temp, new Collier(temp));

        ratelier.put("armes", stockArme);
        ratelier.put("armures", stockArmure);
        ratelier.put("colliers", stockCollier);

        //System.out.println(ratelier);


    }

    // retourne une HashMap contenant tout les objets Equipement classé
    public HashMap<String, HashMap<Stock,Equipement>> ratelier (){

        return ratelier;

    }

    // passe une hashmap d 'POO2_JDRv2.Equipement et permet d'en selectionner un
    // revoie l'equipement choisi, a solidifier
    private Equipement choixDeStuf (HashMap<Stock, Equipement> stock){

        Scanner sc = new Scanner(System.in);
        int choix ;

        System.out.println("Voici la liste disponible");
        int i = 1;
        for(Stock clef : (stock.keySet())){

            System.out.println(i+" --> "+stock.get(clef).getNom()+" --> bonus attaque :"+stock.get(clef).getBonusAttaque()+" bonus de defence "+stock.get(clef).getBonusDefence());
            i ++;

        }

        do {
            System.out.println("Entrer votre choix :");
            try {

                choix = sc.nextInt();

            }catch (Exception e){
                choix = 0;
                sc.nextLine();
            }
        }while (choix < 1 || choix > stock.size());

        i = 1;

        for(Stock clef : (stock.keySet())){

            if ( i == choix){
                return stock.get(clef);
            }

            i ++;

        }

        return null;


    }

    // methode appeler pour equiper completement un personnage
    public Personnage choixEquipement (Personnage perso){

        boolean reponseArmure = BoiteAOutils.question("Voulez-vous vous équiper d'une armure");

        if (reponseArmure){

            perso.placeDispoEtEquipement(choixDeStuf(ratelier.get("armures")));

        }

        boolean reponseArme = BoiteAOutils.question("Voulez-vous vous équiper d'une arme ");

        if (reponseArme){

            perso.placeDispoEtEquipement(choixDeStuf(ratelier.get("armes")));

        }

        if (perso.getMains() != 0){

           reponseArme = BoiteAOutils.question("Il vous reste une main de libre, voulez vous prendre un autre equipement ?");

           if (reponseArme){

               perso.placeDispoEtEquipement(choixDeStuf(ratelier.get("armes")));

           }
        }

        boolean reponseCollier = BoiteAOutils.question("Voulez-vous vous équiper d'un collier ?");

        if (reponseCollier){

            perso.placeDispoEtEquipement(choixDeStuf(ratelier.get("colliers")));

        }

        System.out.println(perso);

        return perso;


    }

    // methode qui retourne aleatoirement un equipemnt d'une hashmap
    public Equipement stuffAleatoire (HashMap<Stock, Equipement> stock){

        int choix = BoiteAOutils.aleatoire(1,stock.size());

        int i = 1;

        for(Stock clef : (stock.keySet())){

            if ( i == choix){
                return stock.get(clef);
            }

            i ++;

        }

        return null;

    }

    // methode appeler pour equiper automatiquement un personnage
    public Personnage equipementAleatoire (Personnage perso){

        perso.placeDispoEtEquipementAleatoire(stuffAleatoire(ratelier.get("armures")));

        perso.placeDispoEtEquipementAleatoire(stuffAleatoire(ratelier.get("armes")));

        if (perso.getMains() != 0){

            do{

            }while (!perso.placeDispoEtEquipementAleatoire(stuffAleatoire((ratelier.get("armes")))));

        }

        perso.placeDispoEtEquipementAleatoire((stuffAleatoire(ratelier.get("colliers"))));

        return perso;

    }

}
