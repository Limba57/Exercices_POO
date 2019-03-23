package POO2_JDRv2;

public interface Race {

    // interface qui decrit les different attribut d'une race

    // retourne le bonus d'attaque de la race
    public int BonusAttaque(Personnage perso,Personnage adversaire);

    // retourne si le personnage a possibilité de parer
    public boolean parer(Personnage perso,Personnage adversaire);

    // methode décrivant les effets, bonus , malus du pouvoir donné par la race
    public boolean pouvoir(Personnage perso);

    // String décrivant le pouvoir
    public String descriptionPouvoir();


    public String toString();

    public boolean isUtilisationPouvoir();

    public void setUtilisationPouvoir(boolean utilisationPouvoir);

}
