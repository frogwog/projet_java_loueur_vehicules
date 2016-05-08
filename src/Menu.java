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
        this.setSize(250, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        JPanel bouton = new JPanel();
        bouton.setLayout(new BoxLayout(bouton, BoxLayout.Y_AXIS));
        bouton.add(new JButton(new LouerAction()));

        JPanel bouton2 = new JPanel();
        bouton2.setLayout(new BoxLayout(bouton2, BoxLayout.Y_AXIS));
        bouton2.add(new JButton(new RendreAction()));

        JPanel bouton3 = new JPanel();
        bouton3.setLayout(new BoxLayout(bouton3, BoxLayout.Y_AXIS));
        bouton3.add(new JButton(new TransactionAction()));

        JPanel bouton4 = new JPanel();
        bouton4.setLayout(new BoxLayout(bouton4, BoxLayout.Y_AXIS));
        bouton4.add(new JButton(new EmprunteursAction()));

        JPanel boutons = new JPanel();
        boutons.setLayout(new BoxLayout(boutons, BoxLayout.PAGE_AXIS));
        boutons.add(bouton);
        boutons.add(bouton2);
        boutons.add(bouton3);
        boutons.add(bouton4);

        getContentPane().add(boutons);

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
