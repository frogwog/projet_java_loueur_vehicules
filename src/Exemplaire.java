import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Eddy on 18/03/16.
 */
public class Exemplaire  {

    private int kilometres;
    private int ID;
    private String immat;
    private Vehicule vehiculeReference;

    public Exemplaire (Vehicule vehiculeReference, String immat, int kilometres, int ID) {
        this.vehiculeReference = vehiculeReference;
        this.immat = immat;
        this.kilometres = kilometres;

    }

    public Exemplaire(Exemplaire exemplaire) {
        this.vehiculeReference = exemplaire.vehiculeReference;
        this.immat = exemplaire.immat;
        this.kilometres = exemplaire.kilometres;
        this.ID = exemplaire.ID;

    }

    //--------Getters--------------------------


    public int getID() {
        return this.ID;
    }

    public String getImmat() {

        return this.immat;
    }

    public int getKilometres() {

        return this.kilometres;
    }

    public Vehicule getVehiculeReference() {
        return vehiculeReference;
    }


    //-------Setters------------------------

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public void setKilometres(int kilometres) {
        this.kilometres = kilometres;
    }

    //-----------------------------------

    public void print() {
        vehiculeReference.print();
        System.out.println("Immatriculation : " + this.immat);
        System.out.println("kilométrage : " + this.kilometres);

    }


}
