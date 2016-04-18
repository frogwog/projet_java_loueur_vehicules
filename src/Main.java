import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eddy on 18/03/16.
 */
public class Main {

    public static void main(String [] args) {


        BDD bdd = new BDD("jdbc:mysql://localhost:3306/LocationVoiture","root", "root");


        Auto v1 = new Auto("Audi","A8");

        Moto v2 = new Moto("Honda", 1000);

        Exemplaire e1 = new Exemplaire(v1,1,12000);

        Exemplaire e2 = new Exemplaire(v1,2,130000);


        Emprunteur emp1 = new Emprunteur(123,"Soares","Edouard","Paris");

        Emprunteur emp2 = new Emprunteur(124,"Garnier","Florian","Paris");

        ArrayList<Vehicule> listeVehicules = new ArrayList<Vehicule>();
        ArrayList<Emprunteur> listeEmprunteurs = new ArrayList<Emprunteur>();
        ArrayList<Exemplaire> listeExemplaires = new ArrayList<Exemplaire>();

        listeVehicules = bdd.recupererTousLesVehicules();

        listeExemplaires.add(e1);
        listeExemplaires.add(e2);


        listeEmprunteurs.add(emp1);
        listeEmprunteurs.add(emp2);


        for (Exemplaire e : listeExemplaires) {

            e.print();
            System.out.println();
        }


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
