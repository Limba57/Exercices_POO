package POO5_banque;

public class Main {

    public static void main(String[] args) {

        CompteBanquaire compteSeb = new CompteBanquaire(2000);

        Depot depot = new Depot(compteSeb,"1");
        Retrait retrait1 = new Retrait(compteSeb,"1");
        Retrait retrait2 = new Retrait(compteSeb,"2");

        Thread t1 = new Thread(depot);
        Thread t2 = new Thread(retrait1);
        Thread t3 = new Thread(retrait2);


        t1.start();
        t2.start();
        t3.start();

    }

}
