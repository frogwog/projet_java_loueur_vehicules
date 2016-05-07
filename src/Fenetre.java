import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Eddy on 07/05/16.
 */
public class Fenetre extends JFrame {

    private ModeleVehicule modeleVehicule;
    private ModeleExemplaire modeleExemplaire;
    private JTable tableau;
    private Formulaire form;

    public Fenetre() {

        setTitle("Liste des Véhicules");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public Fenetre(Vehicule v) {

        setTitle("Liste des Exemplaires");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);

        modeleExemplaire = new ModeleExemplaire(v);
        tableau = new JTable(modeleExemplaire);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();

        boutons.add(new JButton(new RemoveAction()));
        boutons.add(new JButton(new AddAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        setVisible(true);
    }

    public Fenetre(ModeleExemplaire modeleExemplaire) {

        setTitle("Ajout d'un exemplaire");

        this.setSize(250, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.modeleExemplaire = modeleExemplaire;

        form = new Formulaire();
        JPanel boutons = new JPanel();

        setContentPane(form);

        boutons.add(new JButton(new SubmitAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);
        setVisible(true);
    }


    private class RemoveAction extends AbstractAction {
        private RemoveAction() {
            super("Supprimmer");
        }

        public void actionPerformed(ActionEvent e) {
            int selection = tableau.getSelectedRow();

            modeleExemplaire.removeCar(selection);

            revalidate();

        }
    }


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

    private class AddAction extends AbstractAction {
        private AddAction () {
            super("Ajouter");
        }

        public void actionPerformed(ActionEvent e) {

            new Fenetre(modeleExemplaire);

        }
    }


    private class SubmitAction extends AbstractAction {

        private SubmitAction() {
            super("OK");
        }
        public void actionPerformed(ActionEvent e) {

            Exemplaire exemplaire = modeleExemplaire.getValue(0);

            JFormattedTextField[] f = form.getFtf();

            exemplaire.setKilometres(Integer.parseInt(f[0].getText().replaceAll(",", "")));
            exemplaire.setImmat(f[1].getText());

            modeleExemplaire.addCar(exemplaire);

            revalidate();

        }
    }
}
