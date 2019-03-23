package POO5_banque;

public class Retrait implements Runnable{

    private CompteBanquaire compte;
    String nom;

    public Retrait(CompteBanquaire compte, String nom) {
        this.compte = compte;
        this.nom = nom;
    }



    public void run(){

        System.out.println("--- Debut de la thread retrait "+this.nom+" ---");

        while(this.compte.retrait(CompteBanquaire.aleatoire(200,300)))

        System.out.println("--- fin de la thread retrait "+this.nom+" ---");

    }
}
