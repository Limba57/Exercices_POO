package POO4_Librairie;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Commande implements Serializable {

    int numeroDeCommande;     // numero de commande (random pour l'exo)
    String dateDeCommande;    // date a laquel la commande a été validée
    Utilisateur utilisateur;  // utilisateur qui a passé la commande
    Livre livres[];           // livre contenu ds la commande
    double total;             // total de la commande

    // constructeur par defaut
    public Commande(){

        this.numeroDeCommande = 0;
        this.dateDeCommande = null;
        this.livres = null;
        this.total = 0;

    }

    // constructeur complet
    public Commande(int numeroDeCommande,Utilisateur utilisateur,String dateDeCommande,Livre...livres){

        this.numeroDeCommande = numeroDeCommande;
        this.utilisateur = utilisateur;
        this.dateDeCommande = dateDeCommande;
        this.livres = livres;

        for (Livre l : livres){
            total += l.getPrix();
        }

    }

    // affiche les livres contenu ds la commande
    public String afficheLivre(){

        String liste = "";
        for (Livre l : livres){
            liste=liste+l.toString();
        }
        return liste;

    }

    // affiche la commande complette
    public String toString(){

        return "Numero de commande : "+this.numeroDeCommande+"\nClient :"+this.utilisateur.toString()+"\nDate de commande : "+this.dateDeCommande+"\nLivre(s) commandé(s) :\n"+this.afficheLivre()+"Total : "+total;

    }

    // serialisation de la commande
    public void serialisation(){

        JSONObject sauvegardeCommande = new JSONObject();
        HashMap infoLivre;
        JSONArray livreJSON = new JSONArray();

        sauvegardeCommande.put("numero de commande", this.numeroDeCommande);
        sauvegardeCommande.put("nom", this.utilisateur.nom);
        sauvegardeCommande.put("Date de commande", this.dateDeCommande);
        sauvegardeCommande.put("Total",this.total);

        for(Livre l : livres){

            infoLivre = new HashMap();
            infoLivre.put("titre", l.getTitre());
            infoLivre.put("Prix", l.getPrix());

            livreJSON.add(infoLivre);

        }
        sauvegardeCommande.put("livre",livreJSON);

        try{
            PrintWriter sauvegarde = new PrintWriter(this.utilisateur.nom+"/"+this.numeroDeCommande+".json");
            sauvegarde.write(sauvegardeCommande.toJSONString());
            sauvegarde.close();
        }catch(FileNotFoundException e){
            System.out.println("erreure");
        }


    }

    // deserialisation de la commande
    public static String deSerialisation(File fichier){

        String commande;

        try{
            Object obj = new JSONParser().parse(new FileReader(fichier));

            JSONObject jo = (JSONObject) obj;

            ArrayList<String> livreString = new ArrayList();

            JSONArray liste = (JSONArray) jo.get("livre");

            String numeroDeCommande = jo.get("numero de commande").toString();

            String date = (String) jo.get("Date de commande");

            String total = jo.get("Total").toString();

            for (Object livreObjet : liste){

                JSONObject livreJson = (JSONObject) livreObjet;
                String titre = (String) livreJson.get("titre");
                String prix = livreJson.get("Prix").toString();

                livreString.add("Titre : "+titre+"\nPrix : "+prix);
            }

            commande = "Numero de commande : "+numeroDeCommande+"\nDate de commande : "+date+"\nPrix Total de la commande : "+total;

            for (String s : livreString){
                commande = commande+"\n"+s;
            }



        }catch(FileNotFoundException e){
            System.out.println("fichier introuvable");
            return "";
        }catch (ParseException p){
            System.out.println("impossible de lire le fichier");
            return "";
        }catch (IOException i){
            System.out.println("erreur");
            return "";
        }

        return commande;

    }
}
