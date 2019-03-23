package POO4_Librairie;

public enum Genre {

    // enum des genres dispo

    SF("science fiction"),roman("roman"),essais("essai litteraire"),revue("revue scientifique"),drame("roman dramatique"),fantastique("fantastique");

    String genre;

    private Genre(String genre){
        this.genre = genre;
    }

    public String toString(){

        return this.genre;

    }
}
