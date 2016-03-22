import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eddy on 18/03/16.
 */
public class Main {

    public static void main(String [] args) {

        Exemplaire e1 = new Exemplaire(1,12000);

        Exemplaire e2 = new Exemplaire(2,130000);

        Vehicule v1 = new Auto("Audi","A8");
        Vehicule v2 = new Moto("Honda", 1000);

        Emprunteur emp1 = new Emprunteur(123,"Soares","Edouard","Paris");

        Emprunteur emp2 = new Emprunteur(124,"Garnier","Florian","Paris");

        List<Vehicule> listeVehicules = new ArrayList<Vehicule>();
        List<Emprunteur> listeEmprunteurs = new ArrayList<Emprunteur>();

        listeVehicules.add(v1);
        listeVehicules.add(v2);

        listeEmprunteurs.add(emp1);
        listeEmprunteurs.add(emp2);


        for (Emprunteur e : listeEmprunteurs) {

            e.print();
            System.out.println();
        }

        for (Vehicule v : listeVehicules) {

            v.print();
            System.out.println();
        }




    }
}
