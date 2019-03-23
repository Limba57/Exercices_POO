package POO5_banque;

public class Depot implements Runnable{

    CompteBanquaire compte;
    String nom;

    public Depot(CompteBanquaire compte,String nom) {
        this.compte = compte;
        this.nom = nom;
    }

    private void faireDepot(){

        compte.depot(CompteBanquaire.aleatoire(50,100));

    }

    public void run(){

        System.out.println("--- Debut de la thread POO5_banque.Depot "+this.nom+" ---");

        while(compte.getSolde() > 200){
            this.faireDepot();
        }

        System.out.println("--- fin de la thread POO5_banque.Depot "+this.nom+" ---");

    }

}
