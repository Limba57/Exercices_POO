package POO1_JDRv1;

public class Elfes extends Personnage {

    public Elfes(String nom){

        super (nom,"Elfe", 0, 0, -3, " je suis un Elfe et je me la péte (comme d'hab...)");

    }

    // methode appeler en cas d'attaque --> renvoi toucher ou parer
    public void attaquer(Personnage victime){
        int coupDeBol= (int)(Math.random() * 5);
        int coup = Math.abs(victime.defence - this.attaque);

         if (coupDeBol == 2) {
             System.out.println(this.nom + " a fait un critique à " + victime.nom );
             victime.toucher((coup*2)-(victime.defence)/2);

         }
         else {
             if (victime.defence > 0) {
                 System.out.println(this.nom + " a fait baissé la défence de " + victime.nom + " de " + coup / 2);
                 victime.parer(coup);
             }
             if (victime.defence <= 0) {
                 System.out.println(victime.nom + " pris " + coup + " de degat dans la tronche !!");
                 victime.toucher(coup);
             }
         }
    }


}
