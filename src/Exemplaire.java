import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Eddy on 18/03/16.
 */
public class Exemplaire {

    private int numero, kilometres;

    public Exemplaire (int numero, int kilometres) {
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

    //-----------------------------------

    public void print() {
        System.out.println("Nom : " + this.numero);
        System.out.println("Prenom : " + this.kilometres);

    }


}
