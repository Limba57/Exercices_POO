package POO5_banque;

public enum Sexe {

    H("homme"),F("femme");

    String sexe;

    private Sexe(String sexe){
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return sexe;
    }
}
