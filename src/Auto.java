/**
 * Created by Eddy on 18/03/16.
 */
public class Auto extends Vehicule {

    private String modele;

    public Auto(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;
        this.type = "auto";
    }

    public String getModele() {
        return this.modele;
    }


    @Override
    void print() {
        System.out.println("Type : " + this.type);
        System.out.println("Marque : " + this.marque);
        System.out.println("Modele : " + this.modele);
    }
}
