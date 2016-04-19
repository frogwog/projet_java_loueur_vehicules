import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Eddy on 18/03/16.
 */
abstract class Vehicule {

    protected String marque, type;
    protected int ID;

    public int getID() {
        return ID;
    }

    public String getMarque() {
        return this.marque;
    }

    public String getType() {
        return this.type;
    }

    abstract String getModele();

    abstract int getCylindree();

    abstract void print();


}
