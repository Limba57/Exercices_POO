package POO4_Librairie;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InterfaceLibrairie {

    ArrayList<Livre> bibliotheque;  // liste des livres disponoble
    ArrayList<Livre> panier;        // liste contenant les livres de la commande
    Utilisateur utilisateur;        // utilisater de l'interface


    // Constructeur de l'interface, prend en parametre une araylist de livre
    public InterfaceLibrairie(ArrayList<Livre> bibliotheque){
        this.bibliotheque = bibliotheque;
        panier = new ArrayList<>();

        this.interfaceUtilisateur();
    }

    // retourne un string de la date et heure de la validation de la commande
    private String dateAujourdhui (){

        Date date = new Date();
        DateFormat formatCourt = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
        return formatCourt.format(date);
    }

    // retourne un nombre aleatoire --> simule le numero de commande
    private int aleatoire (int mini ,int maxi){

        int nombreAleatoire = mini + (int)(Math.random() * ((maxi - mini) + 1));
        return nombreAleatoire;
    }

    // menu proposant les livres a l'achat
    private  void AchatLivre (){

        Scanner sc = new Scanner(System.in);
        int reponse;

        System.out.println("Voici la liste de nos livres : \n");
        int i = 1;
        for (Livre livre : bibliotheque){
            System.out.println(i+"-->"+livre.afficheCondense()+"\n");
            i++;
        }

        do{
            System.out.println("Choisissez le titre du livre souhaiter ou entrez 0 pour revenir au menu");
            try {
                reponse = sc.nextInt();
            }catch (Exception e){
                reponse = bibliotheque.size()+2;
                sc.nextLine();
            }
        }while(reponse > bibliotheque.size());

        if (reponse == 0){
            this.Menu();
        }

            //System.out.println(this.bibliotheque.get(reponse-1));
            this.panier.add(this.bibliotheque.get(reponse-1));
            this.Menu();


    }

    // affichage des livres disponible avec tout leur details
    private void ListeLivreComplete (){
        System.out.println("Voici la liste de nos livres : \n");
        int i = 1;
        Scanner sc = new Scanner(System.in);
        for (Livre livre : bibliotheque){
            System.out.println(i+"-->"+livre.toString()+"\n");
            i++;
            System.out.println("pressez une touche pour voir le livre suivant");
            sc.nextLine();
        }


    }

    // renvoi un boolean suite a une question type oui/non
    private boolean question (String question){

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

    // affiche la commande en l'etat
    private void panier(){

        if (panier.size() == 0){
            System.out.println("\n----Votre panier est vide----\n");
            this.Menu();
        }else {
            Scanner sc = new Scanner(System.in);

            double total = 0;

            for (Livre livre : panier) {
                System.out.println(livre.afficheCondense());
                total += livre.getPrix();
            }

            System.out.println("\nTotal : " + total+"\n");
            System.out.println("pressez une touche pour revenir au menu");
            sc.nextLine();
            this.Menu();
        }
    }

    // valide la commande et cree l'objet commande et le sauvegarde en json
    private void finDeCommande(){

        System.out.println("Voici votre panier : ");
        System.out.println(panier);

        if(question("Voulez-vous le valider")) {
            int numeroDeCommande = aleatoire(100, 300);

            String date = dateAujourdhui();

            Livre[] panierValide = panier.toArray(Livre[]::new);

            Commande commande = new Commande(numeroDeCommande, utilisateur, date, panierValide);

            commande.serialisation();

            System.out.println("recap de votre commande :");

            System.out.println(commande);

            if(question("voulez-vous passer une nouvelle commande")){
                panier.clear();
                this.Menu();
            }
        }else Menu();
    }

    // modifier la commande
    private void modifCommande(){

        if (panier.size() == 0){
            System.out.println(panier.size());
            System.out.println("Votre panier est vide");
            this.Menu();
        }else{

            Scanner sc = new Scanner(System.in);
            int reponse ;
            int compteur = 1;
            System.out.println("Quel livre voulez vous retirer de votre panier : ");

            for (Livre l : panier){
                System.out.println("Livre "+compteur+" : "+l.afficheCondense());
                compteur ++;
            }

            System.out.println("Entrez votre choix, 0 pour annuler : ");
            reponse = sc.nextInt();
            if(reponse == 0){
                this.Menu();
            }else{
                panier.remove(reponse-1);
                this.Menu();
            }

        }

    }

    // menu principale
    private void Menu (){
        Scanner sc = new Scanner(System.in);
        int reponse;

        do {
            System.out.println("Bienvenu dans notre librairie");
            System.out.println("Que voulez vous faire : ");
            System.out.println(" 1 --> Consulter nos livres");
            System.out.println(" 2 --> ajouter un livre a votre panier");
            System.out.println(" 3 --> consulter votre panier");
            System.out.println(" 4 --> modifier votre panier(retirer un livre)");
            System.out.println(" 5 --> finaliser vottre commande");
            System.out.println(" 6 --> Quitter");
            try {
                reponse = sc.nextInt();
            }catch (Exception e){
                reponse = 0;
                sc.nextLine();
            }
        }while (reponse <1 && reponse>6);

        switch (reponse){
            case 1 :
                this.ListeLivreComplete();
                System.out.println("pressez une touche pour retourner au menu principale");
                sc.nextLine();
                this.Menu();
                break;
            case 2 :
                this.AchatLivre();
                break;
            case 3 :
                this.panier();
                break;
            case 4 :
                this.modifCommande();
                break;
            case 5 :
                this.finDeCommande();
                break;
            case 6 :
                System.out.println("A bientot");
                break;

        }

    }

    // interface utilisateur
    private void interfaceUtilisateur(){
        String nomUtilisateur;
        String mailUtilisateur;
        Scanner sc = new Scanner(System.in);
        System.out.println("entrez votre nom d'utilisateur : ");
        nomUtilisateur = sc.nextLine();
        System.out.println("entrez votre mail : ");
        mailUtilisateur = sc.nextLine();
        utilisateur = new Utilisateur(nomUtilisateur,mailUtilisateur);

        File rep = new File(utilisateur.nom);

        if (!rep.isDirectory()){
            System.out.println("Vous etes un nouveau client, creation de votre compte\n");
            rep.mkdir();
            this.Menu();
        }else{
            System.out.println("content de vous revoir "+this.utilisateur.nom+"\n");

            this.consultationDeCompte();
        }


    }

    //Consultation de compte
    public void consultationDeCompte(){
        if(question("Voulez vous consulter votre compte ?")){

            File repertoirUtilisateur = new File(utilisateur.nom);
            File listeCommande[];
            listeCommande = repertoirUtilisateur.listFiles();
            int compteur = 1;
            int reponse;

            if(listeCommande.length == 0){
                System.out.println("vous n'avez pas de commande enregistrée\n");
                this.Menu();
            }else{
                for(File fichier : listeCommande){
                    String nomCourt = (fichier.getName() != null) ? fichier.getName().substring(0,fichier.getName().indexOf('.')) : "";
                    System.out.println(compteur+" --> commande numero :"+nomCourt);
                    compteur ++;
                }

                if(question("Voulez vous consulter une commande ?")){

                    Scanner sc = new Scanner(System.in);
                    System.out.println("entrez son numero svp");
                    reponse = sc.nextInt()-1;
                    System.out.println(Commande.deSerialisation(listeCommande[reponse]));

                }

                this.consultationDeCompte();
            }

        }else{
            this.Menu();
        }
    }

}
