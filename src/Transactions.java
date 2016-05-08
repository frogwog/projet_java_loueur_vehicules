import java.util.Date;

/**
 * Created by Eddy on 07/05/16.
 */
public class Transactions {

    private int ID;
    private boolean statut;
    private java.util.Date date_debut, date_fin;
    String emprunteurNom, emprunteurPrenom, immat;

    public Transactions(int ID, boolean statut, Date date_debut, Date date_fin, String emprunteurNom, String emprunteurPrenom, String immat) {
        this.ID = ID;
        this.statut = statut;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.emprunteurNom = emprunteurNom;
        this.emprunteurPrenom = emprunteurPrenom;
        this.immat = immat;
    }

    public String getImmat() {
        return immat;
    }

    public int getID() {
        return ID;
    }

    public boolean isStatut() {
        return statut;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getEmprunteurNom() {
        return emprunteurNom;
    }

    public String getEmprunteurPrenom() {
        return emprunteurPrenom;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
}
