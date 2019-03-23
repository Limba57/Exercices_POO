package POO1_JDRv1;

public class Orc extends  Personnage{

    public Orc(String nom){
        super (nom,"POO1_JDRv1.Orc", -10,+2, +2, "mlll wwouogrouroulou !! (comme d'hab...)");
    }

    public void crier(){
        System.out.println(cri);
    }
}
