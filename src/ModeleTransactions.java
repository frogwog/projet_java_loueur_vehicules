import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Eddy on 07/05/16.
 */
public class ModeleTransactions extends AbstractTableModel {

    BDD bdd = new BDD("jdbc:mysql://localhost:3306/LocationVoiture","root", "root");
    private final ArrayList<Transactions> listeTransactions ;

    private final String[] entetes = {"Nom du loueur", "Prénom du loueur", "Date_debut", "Date_fin", "Statut", "Immatriculation"};

    public ModeleTransactions(Emprunteur emprunteur) {
        super();
        listeTransactions = bdd.recupererTransactions(emprunteur);
    }

    public ModeleTransactions() {
        super();
        listeTransactions = bdd.recupererToutesLesTransactions();
    }

    public int getRowCount() {
        return listeTransactions.size();
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
                return listeTransactions.get(rowIndex).getEmprunteurNom();
            case 1:
                return listeTransactions.get(rowIndex).getEmprunteurPrenom();
            case 2:
                return listeTransactions.get(rowIndex).getDate_debut();
            case 3:
                return listeTransactions.get(rowIndex).getDate_fin();
            case 4:
                return listeTransactions.get(rowIndex).isStatut();
            case 5:
                return listeTransactions.get(rowIndex).getImmat();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public Transactions getValue(int row) {
        return listeTransactions.get(row);
    }

}
