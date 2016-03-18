import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eddy on 18/03/16.
 */
public class Main {

    public static void main(String [] args) {

        List e1 = new Exemplaire(1,12000);

        List e2 = new Exemplaire(2,130000);

        List v1 = new Auto("Audi","A8");

        List emp1 = new Emprunteur(123,"Soares","Edouard","Paris");

        List emp2 = new Emprunteur(124,"Garnier","Florian","Paris");


        List maListe = new ArrayList();

        maListe.add(e1);
        maListe.add(e2);
        maListe.add(v1);
        maListe.add(emp1);
        maListe.add(emp2);

        for (int i = 0 ; i < maListe.size() ; i++) {

            System.out.println(maListe.get(i));
        }




    }
}
