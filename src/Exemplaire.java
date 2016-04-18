import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Eddy on 18/03/16.
 */
public class Exemplaire  {

    private int numero, kilometres;
    private Vehicule vehiculeReference;

    public Exemplaire (Vehicule vehiculeReference, int numero, int kilometres) {
        this.vehiculeReference = vehiculeReference;
        this.numero = numero;
        this.kilometres = kilometres;
    }

    //--------Getters--------------------------

    public int getNumero() {

        return this.numero;
    }

    public int getKilometres() {

        return this.kilometres;
    }

    public Vehicule getVehiculeReference() {
        return vehiculeReference;
    }

    //-----------------------------------

    public void print() {
        vehiculeReference.print();
        System.out.println("Numero : " + this.numero);
        System.out.println("kilométrage : " + this.kilometres);

    }


}
