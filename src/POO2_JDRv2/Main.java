package POO2_JDRv2;

public class Main {

    public static void main(String[] args) {

        // Tableau contenant tous les enemis, il y en a cinq, ils faut tous les vaincre pour finir la partie
        Personnage listeEnemi[] = new Personnage[5];

        // Tableau contenant la liste des noms des enemies
        String nomEnemi[] = {"Akuma","Gray Fox", "Gannondorf", "Ra's al Ghul", "The Boss"};

        // Instencie tous les equipements du jeu
        Armurerie Armurerie = new Armurerie();

        // Demande la creation du heros
        Personnage Perso = BoiteAOutils.generationDuHeros();

        // Fais passer le heros à l'armurerie
        Perso = Armurerie.choixEquipement(Perso);

        // Creation des cinq enemis
        for (int i = 0 ; i < listeEnemi.length ; i++) {
            listeEnemi[i] = BoiteAOutils.generationAleatoireEnnemi(nomEnemi[i]);
        }


        // Demande si on veut utiliser le mode GOD pour tester le jeu ds son ensemble --> le perso a 1000 pv
        boolean godMode = BoiteAOutils.question("Voulez vous activer le mode GOD, votre perso aura 1000 pv");
        if (godMode) {
            Perso.setPv(1000);
                    }

        // boucle des combats

        int compteur = 0;

        do{

            System.out.println("COMBAT NUMERO "+(compteur+1));

            new Combat(Perso,listeEnemi[compteur]);

            compteur ++;

        }while (Perso.isVivant() && compteur < listeEnemi.length);

        // victoire final si les 5 enemis sont mort et le perso tjrs vivant
        if (Perso.isVivant()){
            System.out.println("vous avez gagné");
        }


    }


}
