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

    //----------------------Méthodes sur les véhicules---------------------------------------

    // Fonction qui permet de récupérer la liste de tous les véhicules disponibles en base de donnée

    public ArrayList<Vehicule> recupererTousLesVehicules() {

        // Information d'accès à la base de données

        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;

        ArrayList<Vehicule> listeDesVehicules = new ArrayList<Vehicule>();

        String marque, type, modele;
        int cylindree, ID;


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

                ID = rs.getInt("ID");
                marque = rs.getString("Marque");
                type = rs.getString("Type");
                modele = rs.getString("Modele");
                cylindree = rs.getInt("Cylindree");

                if (modele == null) {

                    listeDesVehicules.add(new Moto(marque,cylindree, ID));
                }

                else listeDesVehicules.add(new Auto(marque, modele, ID));


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

    //------------------------------------------------------------------------------------------




    //-----------------Méthodes sur les Exemplaires------------------------------------------

    //Fonction qui permet de récupérer tous les exemplaires d'un véhicule.

    public ArrayList<Exemplaire> recupererExemplaires(Vehicule v) {

        // Information d'accès à la base de données

        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;

        ArrayList<Exemplaire> listeDesExemplaires = new ArrayList<Exemplaire>();

        int numero, kilometrage, ID;



        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT numero, Kilometrage, Exemplaires.ID " +
                    "FROM Exemplaires, Vehicules " +
                    "WHERE Vehicules.ID = " + v.getID() +
                    " AND Exemplaires.Marque = Vehicules.Marque " +
                    "AND (Exemplaires.Modele = Vehicules.Modele OR Exemplaires.Cylindree = Vehicules.Cylindree)" ;

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {

                numero = rs.getInt("numero");
                kilometrage = rs.getInt("Kilometrage");
                ID = rs.getInt("ID");

                listeDesExemplaires.add(new Exemplaire(v,numero,kilometrage, ID));

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

        return listeDesExemplaires;

    }

    public void supprimerUnExemplaire(Exemplaire exemplaire) {

        Connection cn =null;
        Statement st =null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "DELETE FROM Exemplaires WHERE Exemplaires.ID =  " + exemplaire.getID();

            // Etape 4 : exécution requête
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
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
    }


    public void ajouterUnExemplaire(Vehicule v, int kilometrage, int numero) {

        Connection cn =null;
        Statement st =null;
        String sql = null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            if (v.getType() == "Moto") {

                sql = "INSERT INTO Exemplaires (Marque, Type, Cylindree, Kilometrage, numero) " +
                        "VALUES ('" + v.getMarque() + "', '"+v.getType()+"', " + v.getCylindree()+"," +kilometrage+ ", " +numero+ ")";
            }

            else sql = "INSERT INTO Exemplaires (Marque, Type, Modele, Kilometrage, numero) " +
                    "VALUES ('" + v.getMarque() + "', '"+v.getType()+"', '" + v.getModele()+"'," +kilometrage+ ", " +numero+ ")";

            // Etape 4 : exécution requête
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
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
    }

    public void updateKilometrage(Exemplaire exemplaire, int kilometrage){

        Connection cn =null;
        Statement st =null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();


            String sql = "UPDATE Exemplaires SET Kilometrage = " + kilometrage +
                    " WHERE Exemplaires.ID = " + exemplaire.getID();


            // Etape 4 : exécution requête
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
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


    }


    //-------------------------------------------------------------------------------------------



    //----------------Méthodes sur les Emprunteurs----------------------------------------------

    public ArrayList<Emprunteur> recupererTousLesEmprunteurs() {

        // Information d'accès à la base de données

        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;

        ArrayList<Emprunteur> listeDesEmprunteurs = new ArrayList<Emprunteur>();

        String nom, prenom, adresse;
        int ID;


        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT * FROM Emprunteur";

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {

                ID = rs.getInt("ID");
                nom= rs.getString("Nom");
                prenom = rs.getString("Prenom");
                adresse = rs.getString("Adresse");

                listeDesEmprunteurs.add(new Emprunteur(ID, nom, prenom, adresse));

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

        return listeDesEmprunteurs;
    }

    public void supprimerEmprunteur(Emprunteur emprunteur) {

        Connection cn =null;
        Statement st =null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "DELETE FROM Emprunteur WHERE Emprunteur.ID = " + emprunteur.getId();

            // Etape 4 : exécution requête
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
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

    }

    public void ajouterEmprunteur(String nom, String prenom, String adresse) {

        Connection cn =null;
        Statement st =null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();


            String sql = "INSERT INTO Emprunteur (Nom, Prenom, Adresse) " +
                    "VALUES ('" + nom + "', '"+ prenom +"', '" + adresse+"')";

            // Etape 4 : exécution requête
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
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

    }

    public void updateAdresse(Emprunteur emprunteur, String adresse) {

        Connection cn =null;
        Statement st =null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();


            String sql = "UPDATE Emprunteur SET Adresse =  '" + adresse + "' WHERE Emprunteur.ID = " + emprunteur.getId();

            // Etape 4 : exécution requête
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
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


    }


}
