package POO4_Librairie;

public enum Sexe {

    // enum de sexe

    M("Homme"),F("Femme");

    String sexe;
    private Sexe(String sexe){

        this.sexe = sexe;

    }

    public String toString(){

        return this.sexe;

    }
}
