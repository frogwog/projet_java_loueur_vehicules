import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Eddy on 07/05/16.
 */
public class Fenetre extends JFrame {

    private ModeleVehicule modeleVehicule;
    private ModeleExemplaire modeleExemplaire;
    private ModeleEmprunteurs modeleEmprunteurs;
    private ModeleTransactions modeleTransactions;
    private JTable tableau;
    private Formulaire form;
    private Exemplaire exemplaireSelectionne;
    private Emprunteur emprunteurSelectionne;
    private Transactions transactionSelectionne;

    //-------Constructeur pour afficher la liste des véhicules-----------

    public Fenetre(int i) {

        if (i == 0) {
            setTitle("Liste des Véhicules");

            this.setSize(700, 500);
            this.setLocationRelativeTo(null);

            modeleVehicule = new ModeleVehicule();
            tableau = new JTable(modeleVehicule);

            getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

            JPanel boutons = new JPanel();

            boutons.add(new JButton(new SelectAction()));

            getContentPane().add(boutons, BorderLayout.SOUTH);
            setVisible(true);
        }

        else if (i == 1) {

            setTitle("Liste Emprunteurs");

            this.setSize(700, 500);
            this.setLocationRelativeTo(null);

            modeleEmprunteurs = new ModeleEmprunteurs();
            tableau = new JTable(modeleEmprunteurs);

            getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

            JPanel boutons = new JPanel();

            boutons.add(new JButton(new SelectEmprunteurAction()));

            getContentPane().add(boutons, BorderLayout.SOUTH);
            setVisible(true);
        }

        else if (i == 2) {

            setTitle("Liste Emprunteurs");

            this.setSize(700, 500);
            this.setLocationRelativeTo(null);

            modeleTransactions = new ModeleTransactions();
            tableau = new JTable(modeleTransactions);

            getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

            setVisible(true);
        }

        else if (i == 3) {

            setTitle("Liste Emprunteurs");

            this.setSize(700, 500);
            this.setLocationRelativeTo(null);

            modeleEmprunteurs = new ModeleEmprunteurs();
            tableau = new JTable(modeleEmprunteurs);

            getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

            JPanel boutons = new JPanel();

            boutons.add(new JButton(new AddEmprunteurAction()));
            boutons.add(new JButton(new RemoveEmprunteurAction()));

            getContentPane().add(boutons, BorderLayout.SOUTH);
            setVisible(true);
        }

    }



    //-----Constructeur pour afficher la liste des exemplaires d'un véhicule-------------

    public Fenetre(Vehicule v) {

        setTitle("Liste des Exemplaires");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);

        modeleExemplaire = new ModeleExemplaire(v);
        tableau = new JTable(modeleExemplaire);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();

        boutons.add(new JButton(new SelectCarAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        setVisible(true);
    }

    //-------------Constructeur pour afficher les Emprunteurs---------------------------

    public Fenetre(Exemplaire exemplaire) {

        setTitle("Liste des Emprunteurs");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);

        exemplaireSelectionne = exemplaire;

        modeleEmprunteurs = new ModeleEmprunteurs();
        tableau = new JTable(modeleEmprunteurs);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();

        boutons.add(new JButton(new AddEmprunteurAction()));
        boutons.add(new JButton(new LouerAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        setVisible(true);

    }


    //-----------Constructeur pour afficher les transactions---------------------------

    public Fenetre(Emprunteur emprunteur) {

        setTitle("Liste des Transactions");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);

        emprunteurSelectionne = emprunteur;

        modeleTransactions = new ModeleTransactions(emprunteur);
        tableau = new JTable(modeleTransactions);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();

        boutons.add(new JButton(new FinishTransactionAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        setVisible(true);

    }



    //----Constructeur pour afficher le formulaire d'ajout d'un exemplaire-------------

    public Fenetre(ModeleExemplaire modeleExemplaire) {

        setTitle("Ajout d'un exemplaire");

        this.setSize(250, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.modeleExemplaire = modeleExemplaire;

        form = new Formulaire(0);
        JPanel boutons = new JPanel();

        setContentPane(form);

        boutons.add(new JButton(new SubmitAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);
        setVisible(true);
    }



    //----Constructeur pour afficher le formulaire d'ajout d'un Emprunteur-------------

    public Fenetre(ModeleEmprunteurs modeleEmprunteurs) {
        setTitle("Ajout d'un emprunteur");

        this.setSize(250, 250);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.modeleEmprunteurs = modeleEmprunteurs;

        form = new Formulaire(1);
        JPanel boutons = new JPanel();

        setContentPane(form);

        boutons.add(new JButton(new SubmitEmprunteurAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);
        setVisible(true);
    }


    //------Constructeur pour afficher le formulaire des dates de la location---------

    public Fenetre(Exemplaire exemplaireSelectionne, Emprunteur emprunteurSelectionne) {

        setTitle("Location");

        this.setSize(250, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.exemplaireSelectionne = exemplaireSelectionne;
        this.emprunteurSelectionne = emprunteurSelectionne;

        form = new Formulaire(2);
        JPanel boutons = new JPanel();

        setContentPane(form);

        boutons.add(new JButton(new SubmitLouerAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);
        setVisible(true);
    }


    //-------Constructeur pour afficher le formulaire de fin de location-----------------

    public Fenetre(Transactions transaction) {

        setTitle("Fin de location");

        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        transactionSelectionne = transaction;

        form = new Formulaire(3);
        JPanel boutons = new JPanel();

        setContentPane(form);

        boutons.add(new JButton(new SubmitRendreAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);
        setVisible(true);
    }









//**************************Zone dédiée aux interactions avec les boutons***********************

    //----Bouton Selectionner une voiture-------------------------

    private class SelectAction extends AbstractAction {
        private SelectAction() {
            super("Selectionner");
        }

        public void actionPerformed(ActionEvent e) {
            int selection = tableau.getSelectedRow();

            Vehicule v = modeleVehicule.getValue(selection);

            new Fenetre(v);
        }
    }

    //--------Bouton selectionner un Emprunteur-----------------------

    private class SelectEmprunteurAction extends AbstractAction {
        private SelectEmprunteurAction() {
            super("Selectionner");
        }

        public void actionPerformed(ActionEvent e) {
            int selection = tableau.getSelectedRow();

            Emprunteur emprunteur = modeleEmprunteurs.getValue(selection);


            new Fenetre(emprunteur);
        }
    }



    //-------Bouton Selectionner un exemplaire-------------------

    private class SelectCarAction extends AbstractAction {

        private SelectCarAction() {
            super("Choisir");
        }

        public void actionPerformed(ActionEvent e) {
            int selection = tableau.getSelectedRow();
            exemplaireSelectionne = modeleExemplaire.getValue(selection);
            new Fenetre(exemplaireSelectionne);

        }
    }



    //--------Bouton supprimer un exemplaire-----------------------

    private class RemoveAction extends AbstractAction {
        private RemoveAction() {
            super("Supprimmer");
        }

        public void actionPerformed(ActionEvent e) {
            int selection = tableau.getSelectedRow();

            modeleExemplaire.removeCar(selection);

        }
    }


    //--------Bouton supprimer un Emprunteur-----------------------

    private class RemoveEmprunteurAction extends AbstractAction {
        private RemoveEmprunteurAction() {
            super("Supprimmer");
        }

        public void actionPerformed(ActionEvent e) {

            int selection = tableau.getSelectedRow();

            modeleEmprunteurs.removeEmprunteur(selection);


        }
    }


    //------Bouton ajouter un exemplaire-----------------------------

    private class AddAction extends AbstractAction {
        private AddAction () {
            super("Ajouter");
        }

        public void actionPerformed(ActionEvent e) {

            new Fenetre(modeleExemplaire);

        }
    }


    //--------Bouton ajouter un emprunteur---------------------------

    private class AddEmprunteurAction extends AbstractAction {
        private AddEmprunteurAction () {
            super("Ajouter");
        }

        public void actionPerformed(ActionEvent e) {

            new Fenetre(modeleEmprunteurs);

        }
    }


    //-------Bouton terminer une transaction-----------------------


    private class FinishTransactionAction extends AbstractAction {
        private FinishTransactionAction () {
            super("Terminer la location");
        }

        public void actionPerformed(ActionEvent e) {

            int selection = tableau.getSelectedRow();

            Transactions transaction = modeleTransactions.getValue(selection);

            new Fenetre(transaction);

        }
    }



    //-------------Bouton soumettre formulaire ajout exemplaire-------------

    private class SubmitAction extends AbstractAction {

        private SubmitAction() {
            super("OK");
        }
        public void actionPerformed(ActionEvent e) {

            Exemplaire exemplaire = new Exemplaire(modeleExemplaire.getValue(0));

            JFormattedTextField[] f = form.getFtf();

            exemplaire.setKilometres(Integer.parseInt(f[0].getText().replaceAll(",", "")));
            exemplaire.setImmat(f[1].getText());

            modeleExemplaire.addCar(exemplaire);

            setVisible(false);

        }
    }


    //------------Bouton soumettre formulaire ajout emprunteur--------------

    private class SubmitEmprunteurAction extends AbstractAction {

        private SubmitEmprunteurAction() {
            super("OK");
        }
        public void actionPerformed(ActionEvent e) {
            Emprunteur emprunteur = new Emprunteur();

            JFormattedTextField[] f = form.getFtf();

            emprunteur.setNom(f[0].getText());
            emprunteur.setPrenom(f[1].getText());
            emprunteur.setAdresse(f[2].getText());

            modeleEmprunteurs.addEmprunteur(emprunteur);


            setVisible(false);

        }
    }


    //-------------Bouton soumettre formulaire de location------------------


    private class SubmitLouerAction extends AbstractAction {

        private SubmitLouerAction() {
            super("OK");
        }
        public void actionPerformed(ActionEvent e) {

            JFormattedTextField[] f = form.getFtf();

            //Déclaration du SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");

            try {
                java.util.Date date = sdf.parse(f[0].getText());
                java.sql.Date dateDB = new java.sql.Date(date.getTime());

                java.util.Date date2 = sdf.parse(f[1].getText());
                java.sql.Date dateDB2 = new java.sql.Date(date2.getTime());

                BDD bdd = new BDD("jdbc:mysql://localhost:3306/LocationVoiture","root", "root");
                bdd.ajouterTransaction(dateDB, dateDB2, exemplaireSelectionne.getImmat(), emprunteurSelectionne.getNom(), emprunteurSelectionne.getPrenom());

                FirstPdf devis = new FirstPdf();

                try {
                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream("/Users/Eddy/Documents/Programming/IntelliJ-Idea/projet_java_loueur_vehicules/Devis/devis_" + emprunteurSelectionne.getNom() + "_" + dateDB + "_" + exemplaireSelectionne.getImmat() +".pdf"));
                    document.open();
                    devis.addMetaData(document);
                    devis.addTitlePage(document);
                    devis.addContent(document, exemplaireSelectionne, emprunteurSelectionne, dateDB, dateDB2);
                    document.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                bdd.supprimerUnExemplaire(exemplaireSelectionne);

            } catch (ParseException e1) {
                e1.printStackTrace();
            }



            setVisible(false);

        }
    }


    //----------Bouton soumettre Rendre une location--------------------


    private class SubmitRendreAction extends AbstractAction {

        private SubmitRendreAction() {
            super("OK");
        }
        public void actionPerformed(ActionEvent e) {

            JFormattedTextField[] f = form.getFtf();
            Vehicule v;
            int cylindree = Integer.parseInt(f[3].getText().replaceAll(",", ""));

            if (cylindree == 0) {
                v = new Auto(f[1].getText(), f[2].getText(), 0);
            }

            else {
                v = new Moto(f[1].getText(), cylindree, 0);
            }

            Exemplaire exemplaire = new Exemplaire(v, transactionSelectionne.getImmat(), Integer.parseInt(f[4].getText().replaceAll(",", "")), 0);

            BDD bdd = new BDD("jdbc:mysql://localhost:3306/LocationVoiture","root", "root");

            bdd.ajouterUnExemplaire(exemplaire);

            long diff = (transactionSelectionne.getDate_fin().getTime() - transactionSelectionne.getDate_debut().getTime());

            long prix =(diff / (1000*60*60*24)) * 20;

            java.util.Date today = new Date();

            long diff2 = (today.getTime() - transactionSelectionne.getDate_fin().getTime());
            long malus = (diff2 / (1000*60*60*24)) * 20;

            prix += malus;

            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Prix final : " + prix + "€", "Information", JOptionPane.INFORMATION_MESSAGE);

            bdd.terminerTransaction(transactionSelectionne);

            setVisible(false);

        }
    }


    //----------Bouton Louer------------------------------------------------

    private class LouerAction extends AbstractAction {
        private LouerAction() {
            super("Louer");
        }

        public void actionPerformed(ActionEvent e) {
            int selection = tableau.getSelectedRow();
            emprunteurSelectionne = modeleEmprunteurs.getValue(selection);

            new Fenetre(exemplaireSelectionne, emprunteurSelectionne);


        }
    }


}
