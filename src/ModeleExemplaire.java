import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeleExemplaire extends AbstractTableModel {

    BDD bdd = new BDD("jdbc:mysql://localhost:3306/LocationVoiture","root", "root");
    private final ArrayList<Exemplaire> listeExemplaires ;

    private final String[] entetes = {"Marque", "Type", "Modele", "Cylindree", "Kilometres", "Immatriculation"};

    public ModeleExemplaire(Vehicule v) {
        super();
        listeExemplaires = bdd.recupererExemplaires(v);
    }

    public int getRowCount() {
        return listeExemplaires.size();
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
                return listeExemplaires.get(rowIndex).getVehiculeReference().getMarque();
            case 1:
                return listeExemplaires.get(rowIndex).getVehiculeReference().getType();
            case 2:
                return listeExemplaires.get(rowIndex).getVehiculeReference().getModele();
            case 3:
                return listeExemplaires.get(rowIndex).getVehiculeReference().getCylindree();
            case 4:
                return listeExemplaires.get(rowIndex).getKilometres();
            case 5:
                return listeExemplaires.get(rowIndex).getImmat();

            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public Exemplaire getValue(int rowIndex) {

        return listeExemplaires.get(rowIndex);
    }


    public void removeCar(int rowIndex) {

        bdd.supprimerUnExemplaire(listeExemplaires.get(rowIndex));
        listeExemplaires.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void addCar(Exemplaire exemplaire) {

        listeExemplaires.add(exemplaire);

        bdd.ajouterUnExemplaire(exemplaire);

        fireTableRowsInserted(listeExemplaires.size() -1, listeExemplaires.size() -1);
    }
}