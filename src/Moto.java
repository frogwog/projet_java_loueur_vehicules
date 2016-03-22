/**
 * Created by Eddy on 18/03/16.
 */
public class Moto extends Vehicule{

    private int cylindree;

    public Moto (String marque, int cylindree) {
        this.marque = marque;
        this.cylindree = cylindree;
        this.type = "moto";
    }

    public int getCylindree() {
        return this.cylindree;
    }


    @Override
    void print() {
        System.out.println("type : " + this.type);
        System.out.println("Marque : " + this.marque);
        System.out.println("cylindrée : " + this.cylindree);
    }
}
