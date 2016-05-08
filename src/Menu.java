import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Eddy on 07/05/16.
 */
public class Menu extends JFrame {

    public Menu() {

        setTitle("CARAUTO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);


        JPanel boutons = new JPanel();

        boutons.add(new JButton(new LouerAction()));
        boutons.add(new JButton(new RendreAction()));
        boutons.add(new JButton(new TransactionAction()));
        boutons.add(new JButton(new EmprunteursAction()));

        getContentPane().add(boutons, BorderLayout.CENTER);

        setVisible(true);
    }


    private class LouerAction extends AbstractAction {
        private LouerAction() {
            super("Louer un véhicule");
        }

        public void actionPerformed(ActionEvent e) {
            new Fenetre(0);

        }
    }

    private class RendreAction extends AbstractAction {
        private RendreAction() {
            super("Rendre un véhicule");
        }

        public void actionPerformed(ActionEvent e) {
            new Fenetre(1);

        }
    }

    private class TransactionAction extends AbstractAction {
        private TransactionAction() {
            super("Historique des transactions");
        }

        public void actionPerformed(ActionEvent e) {
            new Fenetre(2);

        }
    }

    private class EmprunteursAction extends AbstractAction {
        private EmprunteursAction() {
            super("Gérer les Emprunteurs");
        }

        public void actionPerformed(ActionEvent e) {
            new Fenetre(3);

        }
    }
}
