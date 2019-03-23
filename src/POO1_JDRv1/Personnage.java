package POO1_JDRv1;

import java.util.Scanner;

public class Personnage {

    // Variable du personnage
    protected String nom;
    protected String race;
    protected int pv;
    protected int defence;
    protected int attaque;
    protected String cri;
    public boolean vivant;

    // variable de place ds inventaire
    int inventaire =0 ;
    int nbrEpee = 0;
    int nbrBaton = 0;
    boolean protection = false;
    boolean protectionMagique = false;

    // variable d'equipement
    protected Equipement sac[] = new Equipement[4];

    //protected POO1_JDRv1.Epee arme[] = new POO1_JDRv1.Epee [2];
    //protected POO1_JDRv1.Baton armeMagique[] =  new Baton[2];
    //protected POO1_JDRv1.Pendentif pendentif;
    //protected POO1_JDRv1.Armure armure;

    // constructeur
    protected Personnage(String nom,String race, int pv, int attaque, int defence, String cri){
        this.nom = nom;
        this.race = race;
        this.pv = 100+pv;
        this.attaque = 10+attaque;
        this.defence = 5+defence;
        this.cri = cri;
        vivant = true;
        inventaire = 0 ;
        nbrEpee =0 ;
        nbrBaton = 0 ;
        protection = false ;
        protectionMagique = false ;


    }

    // Constructeur vide
    public Personnage(){

    }

    // methode pour pousser un cri
    protected void crier(){
        System.out.println("Je suis "+this.nom+" et "+cri+". Je vais te défoncer");
    }

    // methode parer (defence baisse au mieu de point de vie)
    protected void parer(int coup){
        this.defence = this.defence-(coup/2);
        if (defence < 0)
            defence = 0;
        System.out.println(this.nom+" a reussi a parrer, il lui  reste "+this.defence+" point de defence");
    }

    // methode toucher (defence nulle --> baisse des pv)
    protected void toucher(int coup){
        this.pv = this.pv - coup;
        System.out.println(this.nom+" n'a pas reussi a parrer il se mange "+coup+" de degat et il lui reste "+this.pv+" point de vie");
        if (pv <= 0){
            vivant = false;
            this.mort();
        }
    }

    // methode appeler en cas d'attaque --> renvoi toucher ou parer
    public void attaquer(Personnage victime){
        int coup = Math.abs(victime.defence - this.attaque);
        if (victime.defence <= 0){
            System.out.println(victime.nom+" pris "+coup+" de degat dans la tronche !!");
            victime.toucher(coup);
        }
        if ( victime.defence > 0) {
            System.out.println(this.nom+" a fait baissé la défence de "+victime.nom+" de "+coup/2);
            victime.parer(coup);
        }

    }

    // mort du perso
    protected void mort(){
        System.out.println(nom+" EST MORT...");

    }

    // gestion de la place ds inventaire
    protected boolean placeInventaire (Equipement nouveau){

        // Verification si place ds inventaire
        if (inventaire <= 3){

            // verfition si epee, si place et rangement
            if (nouveau instanceof Epee){
                if (nbrEpee <= 1) {
                    nbrEpee += 1;
                    putInventaire(nouveau);
                    return true;
                }
                else {
                    System.out.println("Trop d'epee");
                    return false;
                }
            }


            // verification si baton, si place et rangement
            if (nouveau instanceof Baton){
                if (nbrBaton <= 1) {
                    nbrBaton += 1;
                    putInventaire(nouveau);
                    return true;
                }
                else {
                    System.out.println("Trop de baton");
                    return false;
                }
            }

            // verification si armure et rangement
            if (nouveau instanceof Armure){
                if(protection == false){
                    protection = true;
                    putInventaire(nouveau);
                    return true;
                }
                else {
                    System.out.println("Deja une armure ds l' inventaire");
                    return false;
                }
            }

            // verification si pendentif et rangement
            if (nouveau instanceof Pendentif){
                if(protectionMagique == false) {
                    protectionMagique = true;
                    putInventaire(nouveau);
                    return true;
                }
                else{
                        System.out.println("Deja un pendentif dans l'inventaire");
                        return false;
                    }
                }
            }
        else{
            System.out.println("inventaire trop lourd !!!");
            return false;
        }
        return false;
    }

    // mettre ds inventaire
    public void putInventaire(Equipement nouveau){

            sac[inventaire] = nouveau;
            inventaire += 1;

            //affInventaire();
    }

    // Afficher l'inventaire
    public void affInventaire(){
        System.out.println("Inventaire de "+nom);
        for ( int i = 0 ; i < inventaire ; i++){
            Equipement temp;
            temp = sac[i];
            System.out.println("equipement "+(i+1)+" : "+temp.nom);
        }
    }

    // interface d'equipement
    public void intefaceEquipement (){
        Scanner sc = new Scanner(System.in);
        int reponse;
        char sortie = 'n';
        do {
            do {
                System.out.println("Votre sac contient :");
                affInventaire();
                System.out.println("Que voulez-vous faire");
                System.out.println("1 --> Mettre un equipement");
                System.out.println("2 --> Enlever un equipement");
                System.out.println("3 --> Sortir");

                reponse = sc.nextInt();

            } while (reponse != 1 && reponse != 2 && reponse != 3);

            switch (reponse) {
                case 1: {
                    affInventaire();
                    System.out.println("entrez le numero de l'equipement que vous voulez");
                    reponse = sc.nextInt();
                    equipementObjet(reponse - 1);
                    break;
                }
                case 2: {
                    affInventaire();
                    System.out.println("entrez lz numero de ce que vous voulez enlever");
                    reponse = sc.nextInt();
                    enleverObjet(reponse - 1);
                    break;
                }
                case 3: {
                    sortie = 'o';
                    break;
                }
            }

            if (sortie != 'o') {
                System.out.println("voulez vous faire une nouvelle operation (o/n)");
                sortie = sc.nextLine().charAt(0);
            }
        }while (sortie != 'o');


    }

    // Mettre equipement
    protected void equipementObjet (int indice){

        this.attaque = this.attaque + sac[indice].bonusAttaque;
        this.defence = this.defence + sac[indice].bonusDefence;
    }

    // Enlever equipement
    protected void enleverObjet (int indice){

        this.attaque = this.attaque - sac[indice].bonusAttaque;
        this.defence = this.defence - sac[indice].bonusDefence;
    }

    // Afficher POO1_JDRv1.Personnage
    public void afficherPersonnage(){
        System.out.println("voici "+nom+" fiere "+race+" avec en attaque "+attaque+" en defence "+defence+" il lui reste "+pv+" points de vie");
    }

}
