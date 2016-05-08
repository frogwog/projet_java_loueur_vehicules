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

        int kilometrage, ID;
        String immatriculation;



        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT Immatriculation, Kilometrage, Exemplaires.ID " +
                    "FROM Exemplaires, Vehicules " +
                    "WHERE Vehicules.ID = " + v.getID() +
                    " AND Exemplaires.Marque = Vehicules.Marque " +
                    "AND (Exemplaires.Modele = Vehicules.Modele OR Exemplaires.Cylindree = Vehicules.Cylindree)" ;

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {

                immatriculation = rs.getString("Immatriculation");
                kilometrage = rs.getInt("Kilometrage");
                ID = rs.getInt("ID");

                listeDesExemplaires.add(new Exemplaire(v,immatriculation,kilometrage, ID));

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

            String sql = "DELETE FROM Exemplaires WHERE Exemplaires.Immatriculation =  '" + exemplaire.getImmat() + "'";

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


    public void ajouterUnExemplaire(Exemplaire exemplaire) {

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

            if (exemplaire.getVehiculeReference().getType() == "Moto") {

                sql = "INSERT INTO Exemplaires (Marque, Type, Cylindree, Kilometrage, Immatriculation) " +
                        "VALUES ('" + exemplaire.getVehiculeReference().getMarque() + "', '"+exemplaire.getVehiculeReference().getType()+"', " + exemplaire.getVehiculeReference().getCylindree()+"," +exemplaire.getKilometres()+ ", '" +exemplaire.getImmat()+ "')";
            }

            else sql = "INSERT INTO Exemplaires (Marque, Type, Modele, Kilometrage, Immatriculation) " +
                    "VALUES ('" + exemplaire.getVehiculeReference().getMarque() + "', '"+exemplaire.getVehiculeReference().getType()+"', '" + exemplaire.getVehiculeReference().getModele()+"'," +exemplaire.getKilometres()+ ", '" +exemplaire.getImmat()+ "')";

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

            String sql = "DELETE FROM Emprunteur WHERE Emprunteur.Adresse = '" + emprunteur.getAdresse() + "'";

            // Etape 4 : exécution requête
            st.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Erreur dans la saisie SQL");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println("Erreur dans la saisie SQL");
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

    public void ajouterEmprunteur(Emprunteur emprunteur) {

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
                    "VALUES ('" + emprunteur.getNom() + "', '"+ emprunteur.getPrenom() +"', '" + emprunteur.getAdresse()+"')";

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



    //-----------------Transactions---------------------------------------------------------------

    public void ajouterTransaction(java.util.Date date_debut, java.util.Date date_fin, String immat, String nom, String prenom) {

        Connection cn =null;
        Statement st =null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();


            String sql = "INSERT INTO Transactions (Date_debut, Date_fin, Immatriculation, Emprunteur_nom, Emprunteur_prenom, Statut) " +
                    "VALUES ('" + date_debut + "', '"+ date_fin +"', '" + immat + "', '" + nom + "', '" + prenom + "', TRUE)";

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

    public ArrayList<Transactions> recupererToutesLesTransactions() {

        // Information d'accès à la base de données

        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;

        ArrayList<Transactions> listeDesTransactions = new ArrayList<Transactions>();

        String nom, prenom, immat;
        int ID;
        boolean statut;
        java.sql.Date date_debut, date_fin;


        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT * FROM Transactions";

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {

                ID = rs.getInt("ID");
                date_debut = rs.getDate("Date_debut");
                date_fin = rs.getDate("Date_fin");
                statut = rs.getBoolean("Statut");
                immat = rs.getString("Immatriculation");
                nom = rs.getString("Emprunteur_nom");
                prenom = rs.getString("Emprunteur_prenom");


                listeDesTransactions.add(new Transactions(ID, statut, date_debut, date_fin, nom, prenom, immat));

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

        return listeDesTransactions;
    }

    public ArrayList<Transactions> recupererTransactions(Emprunteur emprunteur) {

        // Information d'accès à la base de données

        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;

        ArrayList<Transactions> listeDesTransactions = new ArrayList<Transactions>();

        String nom, prenom, immat;
        int ID;
        boolean statut;
        java.sql.Date date_debut, date_fin;


        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT * FROM Transactions WHERE Transactions.Emprunteur_nom = '"+ emprunteur.getNom() + "' AND Transactions.Emprunteur_prenom = '" + emprunteur.getPrenom()+ "'";

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {

                ID = rs.getInt("ID");
                date_debut = rs.getDate("Date_debut");
                date_fin = rs.getDate("Date_fin");
                statut = rs.getBoolean("Statut");
                immat = rs.getString("Immatriculation");
                nom = rs.getString("Emprunteur_nom");
                prenom = rs.getString("Emprunteur_prenom");


                listeDesTransactions.add(new Transactions(ID, statut, date_debut, date_fin, nom, prenom, immat));

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

        return listeDesTransactions;
    }

    public void terminerTransaction(Transactions transactions) {

        Connection cn =null;
        Statement st =null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();


            String sql = "UPDATE Transactions SET Statut = FALSE WHERE Transactions.Immatriculation = '" + transactions.getImmat() + "'";

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
