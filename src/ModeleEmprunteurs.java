import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Eddy on 07/05/16.
 */
public class ModeleEmprunteurs extends AbstractTableModel {

    BDD bdd = new BDD("jdbc:mysql://localhost:3306/LocationVoiture","root", "root");
    private final ArrayList<Emprunteur> listeEmprunteurs ;

    private final String[] entetes = {"Nom", "Prénom", "Adresse"};

    public ModeleEmprunteurs() {
        super();
        listeEmprunteurs = bdd.recupererTousLesEmprunteurs();
    }

    public ModeleEmprunteurs(ArrayList<Emprunteur> listeEmprunteurs) {
        super();
        this.listeEmprunteurs = listeEmprunteurs;
    }

    public int getRowCount() {
        return listeEmprunteurs.size();
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
                return listeEmprunteurs.get(rowIndex).getNom();
            case 1:
                return listeEmprunteurs.get(rowIndex).getPrenom();
            case 2:
                return listeEmprunteurs.get(rowIndex).getAdresse();

            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public Emprunteur getValue(int rowIndex) {

        return listeEmprunteurs.get(rowIndex);
    }

    public ArrayList<Emprunteur> getListeEmprunteurs() {
        return listeEmprunteurs;
    }


    public void removeEmprunteur(int rowIndex) {

        bdd.supprimerEmprunteur(listeEmprunteurs.get(rowIndex));
        listeEmprunteurs.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void addEmprunteur(Emprunteur emprunteur) {

        listeEmprunteurs.add(emprunteur);

        bdd.ajouterEmprunteur(emprunteur);

        fireTableRowsInserted(listeEmprunteurs.size() -1, listeEmprunteurs.size() -1);
    }

    public boolean rechercheEmprunteur(String recherche, int row) {


        if (recherche.equals(listeEmprunteurs.get(row).getNom()) || recherche.equals(listeEmprunteurs.get(row).getPrenom())  || recherche.equals(listeEmprunteurs.get(row).getAdresse()) ) {
            return false;
        }
        else  {
            listeEmprunteurs.remove(row);
            fireTableRowsDeleted(row, row);
            return true;
        }

    }
}
