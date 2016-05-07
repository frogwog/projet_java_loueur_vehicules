import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Eddy on 07/05/16.
 */
public class ModeleVehicule extends AbstractTableModel {

    BDD bdd = new BDD("jdbc:mysql://localhost:3306/LocationVoiture","root", "root");
    private final List<Vehicule> listeVehicules= bdd.recupererTousLesVehicules();

    private final String[] entetes = {"Marque", "Type", "Modele", "Cylindree"};

    public ModeleVehicule() {
        super();
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


    public void removeCar(int rowIndex) {
        listeVehicules.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
