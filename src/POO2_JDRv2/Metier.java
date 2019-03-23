package POO2_JDRv2;

public abstract class Metier {

    private int xp;                       // point d'experience relatif au metier permet de monter de niveau
    private int niveau;                   // niveau relatif au metier incrmente de 1 tout les 20 pts d'xp
    protected int bonusAttaqueMetier ;    // bonus/malus (en attaque) donné au personnage lors de sa creation
    protected int bonusDefenceMetier ;    // bonus/malus (en defence) donné au personnage lors de sa creation
    protected int bonusPvMetier ;         // bonus/malus (au pv) donné au personnage lors de sa creation



    // constructeur par defaut --> personnage de niveau 1 avec 0 xp
    protected Metier (){

        xp = 0 ;
        niveau = 1 ;
        bonusAttaqueMetier = 0 ;
        bonusDefenceMetier = 0 ;
        bonusPvMetier = 0 ;

    }

    // constructeur pour un perso evolué, passe un TOTAL d'xp qui defini le niveau
    // niveau + 1 tout les 20 pts xp ( 60 xp pour avoir un perso de niveau 3)
    protected Metier (int xp){

        this.xp = xp;
        this.niveau = (getXp()/20)+1;
        bonusAttaqueMetier = 0 ;
        bonusDefenceMetier = 0 ;
        bonusPvMetier = 0 ;

    }

    // donne le gain du combat et redefini le niveau en fonction
    public void gainXp (int gain){

        setXp(getXp()+gain);
        setNiveau((getXp()/20)+1);

    }

    // decrit l'attribut du metier relatif au points de vie
    // Dans le jeu tel qu' il est ecrit seul le guerrier a veritablement un pouvoir
    // les autres n'ont rien de specifique mais c'est facilement changeable
    public int secondSouffle(){

        return 0 ;

    }

    @Override
    // retourne une String decrivant le metier les xp et le niveau
    public String toString() {
        return (getClass().getSimpleName()+" de niveau "+this.niveau+" avec "+xp+" point d'expérience.");
    }

    // methode abstraite particularité, en fonction du metier
    protected void competence (Personnage perso, Personnage enemi){

        System.out.println("Au boulot");

    }

    // methode abstraite qui renvoit une string decrivant la compétance
    abstract  String descriptionCompetence();

    // getter

    public int getXp() {
        return xp;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getBonusAttaqueMetier() {
        return bonusAttaqueMetier;
    }

    public int getBonusDefenceMetier() {
        return bonusDefenceMetier;
    }

    public int getBonusPvMetier() {
        return bonusPvMetier;
    }


    // setter


    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setBonusAttaqueMetier(int bonusAttaqueMetier) {
        this.bonusAttaqueMetier = bonusAttaqueMetier;
    }

    public void setBonusDefenceMetier(int bonusDefenceMetier) {
        this.bonusDefenceMetier = bonusDefenceMetier;
    }

    public void setBonusPvMetier(int bonusPvMetier) {
        this.bonusPvMetier = bonusPvMetier;
    }
}
