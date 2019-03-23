package POO5_banque;

public class CompteBanquaire {

    private int numeroDeCompte;
    private int solde;
    private int plafond;
    private int compteur =0;


    // constructeur par defaut, plafond à 500 et solde à 0
    public CompteBanquaire(){
        this.numeroDeCompte = aleatoire(1000,5000);
        this.plafond = 500;
        this.solde = 0;
    }

    // constructeur avec un solde en parametre
    public CompteBanquaire(int solde){
        this();
        this.solde = solde;
    }

    // retourne un nombre aleatoire --> simule le numero de commande
    public static int aleatoire (int mini ,int maxi){

        int nombreAleatoire = mini + (int)(Math.random() * ((maxi - mini) + 1));
        return nombreAleatoire;
    }

    // retrait
    public boolean retrait (int montant){

        if(montant > plafond){
            System.out.println("\nVotre retrait de "+montant+" € est impossible, vous dépassé votre plafond fixé à "+plafond+" € maximum\n");
            return  false;
        }
        if((solde-montant) < plafond){
            System.out.println("\nPOO5_banque.Retrait de "+montant+" € impossible, vous dépassé le solde mini de votre compte");
            System.out.println("Il vous reste actuellement : "+solde+" € sur votre compte\n");
            return false;
        }else{
            System.out.println("\nOpération acceptée");
            System.out.println("debit de "+montant+" €");
            solde -= montant;
            System.out.println("Il vous reste "+solde+" € sur votre compte");
            return true;
        }

    }

    // POO5_banque.Depot
    public void depot (int montant){

        solde += montant;
        System.out.println("\nVous venez de déposer "+montant+" € sur votre compte");
        System.out.println("Votre solde est de "+solde+" € \n");
    }

    public String toString(){

        return "\nCompte numero : "+this.getNumeroDeCompte()+"\nSolde : "+this.solde+" €";

    }

    // Getter
    public int getSolde() {
        return solde;
    }

    public int getNumeroDeCompte() {
        return numeroDeCompte;
    }
}
