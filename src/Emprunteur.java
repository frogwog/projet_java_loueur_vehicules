import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Eddy on 18/03/16.
 */
public class Emprunteur {

    private int id;
    private String nom, prenom;
    private String adresse;

    public Emprunteur(int id, String nom, String prenom, String adresse) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;

    }

    //--------Getters--------------------------

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public int getId() {
        return this.id;
    }

    //-----------------------------------

    public void print() {
        System.out.println("Nom : " + this.nom);
        System.out.println("Prenom : " + this.prenom);
        System.out.println("adresse : " + this.adresse);

    }

    public void louer() {


    }

    public void ramener() {

    }
}
