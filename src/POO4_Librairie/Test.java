package POO4_Librairie;

import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {





    public static void main(String[] args) {

        // instenciation des auteurs
        Auteur jules = new Auteur("Jules Verne",Sexe.M,"02.02.1800");
        Auteur victor = new Auteur("Victor hugo",Sexe.M,"03.03/1850");
        Auteur stephen = new Auteur("Stephen King",Sexe.M,"04.04.1950");
        Auteur mary = new Auteur("Mary higgins Clark",Sexe.F,"05.05.1825");
        Auteur wells = new Auteur("H.G.Wells",Sexe.M,"02.02.1940");
        Auteur lovecraft = new Auteur("Lovecraft",Sexe.M,"01.01.1901");

        // instenciation des livres
        Livre vingM = new Livre("Les Miserable sous les mers","01.01.1885",Genre.SF,25.99,jules,victor);
        Livre Shinnig = new Livre("Shinning","02.02.1975",Genre.fantastique,15.99,stephen);
        Livre laRevueSF = new Livre("La revue SF","05.05.2018",Genre.revue,10.99,stephen,jules,wells);
        Livre unCriDsParis = new Livre("Un cris dans Paris","faille temporelle",Genre.roman,100.99,victor,mary);
        Livre lappel = new Livre("La condition Chtonnienne","-10000000052",Genre.essais,150087.23,lovecraft);

        // instenciation de la biblihotheque
        ArrayList<Livre> bibliotheque = new ArrayList<>();
        bibliotheque.add(vingM);
        bibliotheque.add(Shinnig);
        bibliotheque.add(lappel);
        bibliotheque.add(laRevueSF);
        bibliotheque.add(unCriDsParis);

        InterfaceLibrairie librairie = new InterfaceLibrairie(bibliotheque);







    }


}
