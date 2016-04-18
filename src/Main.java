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



        Emprunteur emp1 = new Emprunteur(123,"Soares","Edouard","Paris");

        Emprunteur emp2 = new Emprunteur(124,"Garnier","Florian","Paris");

        ArrayList<Vehicule> listeVehicules = bdd.recupererTousLesVehicules();
        ArrayList<Emprunteur> listeEmprunteurs = null;
        ArrayList<Exemplaire> listeExemplaires = bdd.recupererExemplaires(listeVehicules.get(30));




        for (Exemplaire e : listeExemplaires) {

            e.print();
            System.out.println();
        }


       /* for (Emprunteur e : listeEmprunteurs) {

            e.print();
            System.out.println();
        }

        /*for (Vehicule v : listeVehicules) {

            v.print();
            System.out.println();
        }*/




    }


}
