package POO2_JDRv2;

import java.util.ArrayList;

// classe décrivant un personnage dans son ensemble


public class Personnage {

    // Variable de personnage
    private int attaque ;      // attaque naturel, sans bonus
    private int defense ;      // defense naturel, sans bonus
    private int bonusAttaque ; // addition des differents bonus d'equipement
    private int bonusDefense ; // addition des differents bonus d'equipement
    private int pv ;           // points de vie naturel du personnage
    private Race race ;        // décrit la race du personnage --> voir interface POO2_JDRv2.Race
    private Metier metier ;    // décrit le metier du personnage -> voir l'interface Metier
    private String nom ;       // nom du personnage
    private boolean vivant;    // booleen qui decrit la vie du personnage --> true = vivant, false ...

    // Variable d'equipement
    private ArrayList<Arme> dansLesMains = new ArrayList<>();            // armes dans les mains
    private int mains ;                                                  // nombre de mains libre
    private Armure corps ;                                               // armure equipée
    private Collier cou ;                                                // collier magique autour du cou
    private boolean presenceArmure;                                      // testeur de presence d'armure
    private boolean presenceCollier;                                     // testeur de presence de collier magique


    // constructeur par defaut, seul un nom est passé en parametre les autres sont par defaut --> hummain, guerrier
    public Personnage (String nom){


        race = new Humain();
        metier = new Guerrier();

        // permet de donner les bonus/malus constant defini par le metier (pour l'exercice seul le voleur en a
        // les autres metiers n'en ont pas mais c'est facilement modifiable directement ds les constructeur
        // de ceux-ci
        attaque = 10 + this.metier.bonusAttaqueMetier;
        defense = 5 + this.metier.bonusDefenceMetier;
        pv = 100 + this.metier.bonusPvMetier;



        this.nom = nom ;
        vivant = true ;
        bonusAttaque = 0 ;
        bonusDefense = 0 ;
        presenceArmure = false ;
        presenceCollier = false ;
        mains = 2;




    }

    // constructeur avec choix de nom et race --> metier par defaut guerrier
    public Personnage (String nom, Race race){

        this(nom);
        this.race = race;


    }

    // constructeur complet
    public Personnage (String nom, Race race, Metier metier){

        this(nom, race);
        this.metier = metier ;

        // permet de donner les bonus/malus constant defini par le metier (pour l'exercice seul le voleur en a
        // les autres metiers n'en ont pas mais c'est facilement modifiable directement ds les constructeur
        // de ceux-ci
        attaque = 10 + this.metier.bonusAttaqueMetier;
        defense = 5 + this.metier.bonusDefenceMetier;
        pv = 100 + this.metier.bonusPvMetier;

    }


    /*
       gestion de l'inventaire du personnage (armure, main ...)
       deux épée max, une seule armure , un seul collier et quatre objet max
       attention certaine arme sont a deux mains et donc une seul arme est équipée
       si les condition sont OK --> la place disponible est enlevée et appel de ajoutBonusEquipement --> return true
       si place deja dispo retourne un message d'erreur --> false
     */
    public boolean placeDispoEtEquipement (Equipement equipement){

        // si c'est une arme verification de la place dispo en fonction du nmbre de main necessaire
        // pour manier l'arme
        if (equipement instanceof Arme){
            if ( (mains - ((Arme) equipement).getNbrMain()) >= 0){
                mains -= ((Arme) equipement).getNbrMain();
                dansLesMains.add((Arme)equipement);
                ajoutBonusEquipement(equipement);
                return true;
            }
            else{
                System.out.println("Vos mains sont pleines.");
                return false;
            }
        }

        // si c'est une armure simple vérification si deja presence d'une autre armure
        if(equipement instanceof Armure){
            if (presenceArmure == false){
                presenceArmure = true;
                corps = (Armure)equipement;
                ajoutBonusEquipement(equipement);
                return true;
            }
            else{
                System.out.println("Deja équipé d'une armure.");
                return false;
            }
        }

        // idem avec un collier
        if(equipement instanceof Collier){
            if (presenceCollier == false){
                presenceCollier = true;
                cou = (Collier) equipement;
                ajoutBonusEquipement(equipement);
                return true;
            }
            else{
                System.out.println("Deja équipé d'un collier.");
                return false;
            }

        }

        System.out.println("Erreure dans placeDispo de la classe personnage");
        return false;
    }

    // idem que methode placeDispoEtEquipement mais sans message, pour la generation automatique des ennemis.
    public boolean placeDispoEtEquipementAleatoire (Equipement equipement){

        // si c'est une arme verification de la place dispo en fonction du nmbre de main necessaire
        // pour manier l'arme
        if (equipement instanceof Arme){
            if ( (mains - ((Arme) equipement).getNbrMain()) >= 0){
                mains -= ((Arme) equipement).getNbrMain();
                dansLesMains.add((Arme)equipement);
                ajoutBonusEquipement(equipement);
                return true;
            }
            else{
                return false;
            }
        }

        // si c'est une armure simple vérification si deja presence d'une autre armure
        if(equipement instanceof Armure){
            if (presenceArmure == false){
                presenceArmure = true;
                corps = (Armure)equipement;
                ajoutBonusEquipement(equipement);
                return true;
            }
            else{
                return false;
            }
        }

        // idem avec un collier
        if(equipement instanceof Collier){
            if (presenceCollier == false){
                presenceCollier = true;
                cou = (Collier) equipement;
                ajoutBonusEquipement(equipement);
                return true;
            }
            else{
                return false;
            }

        }

        System.out.println("Erreure dans placeDispo de la classe personnage");
        return false;
    }

    // ajoute les bonus de l'equipement à la variable bonusXxxx
    public void ajoutBonusEquipement (Equipement equipement){

        this.bonusAttaque += equipement.getBonusAttaque();
        this.bonusDefense += equipement.getBonusDefence();

    }

    // retire les bonus de l'equipement et libere de la place ds inventaire --
    public void retraitBonusEquipement (Equipement equipement) {

        this.bonusAttaque -= equipement.getBonusAttaque();
        this.bonusDefense -= equipement.getBonusDefence();

        if (equipement instanceof Arme){
            int i = dansLesMains.indexOf(equipement);
            dansLesMains.remove(dansLesMains.get(i));
            mains += ((Arme) equipement).getNbrMain();
        }

        if(equipement instanceof Armure){
            corps = null;
            presenceArmure = false;
        }

        if(equipement instanceof Collier){
            cou = null;
            presenceCollier = false;
        }


    }

    // gére les degats infligé au personnage
    // applique second souffle si ils sont égals a zero
    // retourne l'etat du perso après --> vivant ou mort
    public boolean degat (int degat){

        System.out.println(this.nom+" a prit "+degat+" de degat");
        pv -= degat;

        // Si les pv sont egal à zero --> second souffle
        if (pv == 0){

            setPv(getMetier().secondSouffle());

        }

        if (pv <= 0){

            System.out.println("\n"+this.nom+" est MORT au combat ... RIP"+"\n");
            this.vivant = false;

        }

        return this.vivant;

    }

    // affichePersonnage --> retourne un string ordonné du nom, classe et metier du perso
    public String affichePersonnage(){
        return ("\n"+this.nom+" de race "+this.race.toString()+" exercant le metier de "+this.metier.toString());
    }

    // afficheStat --> retourne un String qui décrit les stat du personnage
    public String afficheStat(){
        return ("\nAttaque : "+this.attaque+" et "+bonusAttaque+" de bonus\nDefence : "+this.defense+" et "+bonusDefense+" de bonus\nPoint de vie : "+this.pv);
    }

    // afficheArmes --> retouren un String qui affiche ce qu'a le personnage ds les mains
    public String afficheArmes(){

        // verifie si les mains sont occupées et affiche selon
        String enMain ="";
        if (mains != 2) {
            int i = 0;
            for (Arme temp: dansLesMains) {
                String s;
                if (i == 0)
                    s = "main droite ";
                else
                    s = "main gauche ";
                enMain += s + temp.getNom() + ", ";
                i ++;
            }
        }
        else
            enMain = "rien";

        return enMain;


    }

    // afficheInventaire --> retourne un String qui decrit l'inventaire du personnage
    public String afficheInventaire(){



        // verifie si équipé d'une armure affiche selon
        String armure;
        if (presenceArmure)
            armure = corps.getNom();
        else
            armure = "rien";

        // verifie si equipée d' un collier est affiche selon
        String collier;
        if(presenceCollier)
            collier = cou.getNom();
        else
            collier = "rien";

        // concatenation des variables
        return ("\nEn main : " +afficheArmes()+ " il vous reste " +mains+ " emplacement\nPOO2_JDRv2.Armure : " +armure+ "\nPOO2_JDRv2.Collier : " +collier);
    }

    // toString --> concaténation des trois fonction afficheXxxx
    public String toString(){
        return (affichePersonnage()+afficheStat()+afficheInventaire()+"\n");
    }







    // Getter --

    public int getAttaque() {
        return attaque;
    }

    public int getDefense() {
        return defense;
    }

    public int getPv() {
        return pv;
    }

    public Race getRace() {
        return race;
    }

    public String getNom() {
        return nom;
    }

    public boolean isVivant() {
        return vivant;
    }

    public Armure getCorps() {
        return corps;
    }

    public Collier getCou() {
        return cou;
    }

    public int getMains() {
        return mains;
    }


    public Metier getMetier() {

        return metier;
    }


    public ArrayList<Arme> getDansLesMains() {
        return dansLesMains;
    }

    public boolean isPresenceArmure() {
        return presenceArmure;
    }

    public boolean isPresenceCollier() {
        return presenceCollier;
    }

    public int getBonusAttaque() {
        return bonusAttaque;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }


    // Setter --
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    public void setCorps(Armure corps) {
        this.corps = corps;
    }

    public void setCou(Collier cou) {
        this.cou = cou;
    }

    public void setMains(int mains) {
        this.mains = mains;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    public void setBonusAttaque(int bonusAttaque) {
        this.bonusAttaque = bonusAttaque;
    }

    public void setBonusDefense(int bonusDefense) {
        this.bonusDefense = bonusDefense;
    }

    public void setDansLesMains(ArrayList<Arme> dansLesMains) {
        this.dansLesMains = dansLesMains;
    }

    public void setPresenceArmure(boolean presenceArmure) {
        this.presenceArmure = presenceArmure;
    }

    public void setPresenceCollier(boolean presenceCollier) {
        this.presenceCollier = presenceCollier;
    }
}
