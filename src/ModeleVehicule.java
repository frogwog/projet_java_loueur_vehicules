import javax.jws.WebParam;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eddy on 07/05/16.
 */
public class ModeleVehicule extends AbstractTableModel {

    BDD bdd = new BDD("jdbc:mysql://localhost:3306/LocationVoiture","root", "root");
    private final ArrayList<Vehicule> listeVehicules;

    private final String[] entetes = {"Marque", "Type", "Modele", "Cylindree"};

    public ModeleVehicule() {
        super();
        listeVehicules= bdd.recupererTousLesVehicules();
    }


    public int getRowCount() {
        return listeVehicules.size();
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listeVehicules.get(rowIndex).getMarque();
            case 1:
                return listeVehicules.get(rowIndex).getType();
            case 2:
                return listeVehicules.get(rowIndex).getModele();
            case 3:
                return listeVehicules.get(rowIndex).getCylindree();

            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public Vehicule getValue(int rowIndex) {

        return listeVehicules.get(rowIndex);
    }

    public ArrayList<Vehicule> getListeVehicules() {
        return listeVehicules;
    }

    public boolean rechercheVehicule(String recherche, int row) {


        if (recherche.equals(listeVehicules.get(row).getMarque()) || recherche.equals(listeVehicules.get(row).getType()) || recherche.equals(Integer.toString(listeVehicules.get(row).getCylindree())) || recherche.equals(listeVehicules.get(row).getModele()) ) {
            return false;
        }
        else  {
            listeVehicules.remove(row);
            fireTableRowsDeleted(row, row);
            return true;
        }

    }
}
