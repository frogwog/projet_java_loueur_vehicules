import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Eddy on 18/04/16.
 */
public class BDD {

    private String url, login, passwd;

    public BDD(String url, String login, String passwd) {
        this.url = url;
        this.login = login;
        this.passwd = passwd;
    }

    public ArrayList<Vehicule> recupererTousLesVehicules() {

        // Information d'accès à la base de données

        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;

        ArrayList<Vehicule> listeDesVehicules = new ArrayList<Vehicule>();

        String marque, type, modele;
        int cylindree;


        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT * FROM Vehicules";

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {

                marque = rs.getString("Marque");
                type = rs.getString("Type");
                modele = rs.getString("Modele");
                cylindree = rs.getInt("Cylindree");

                if (modele == null) {

                    listeDesVehicules.add(new Moto(marque,cylindree));
                }

                else listeDesVehicules.add(new Auto(marque, modele));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // Etape 6 : libérer ressources de la mémoire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listeDesVehicules;

    }


}
