import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Eddy on 19/04/16.
 */
public class Fenetre extends JFrame {

    private JTable tableau, t2;
    private JButton change = new JButton("Changer la taille");
    private JButton retablir = new JButton("Rétablir");

    public Fenetre(){
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTable");
        this.setSize(600, 400);

        BDD bdd = new BDD("jdbc:mysql://localhost:3306/LocationVoiture","root", "root");

        ArrayList<Vehicule> listeVehicules = bdd.recupererTousLesVehicules();



        String  title[] = {"Marque", "Type", "Modele", "Cylindree"};
        this.tableau = new JTable(listeVehicules.size(), title.length);

        for (int i = 0 ; i < listeVehicules.size() ; i++) {

            this.tableau.setValueAt(listeVehicules.get(i).getMarque(), i, 0);
            this.tableau.setValueAt(listeVehicules.get(i).getType(), i, 1);
            System.out.println(listeVehicules.get(i).getType());

            if (listeVehicules.get(i).getType() == "Moto") {
                this.tableau.setValueAt("---", i, 2);
                this.tableau.setValueAt(listeVehicules.get(i).getCylindree(), i, 3);

            }
            else {
                this.tableau.setValueAt(listeVehicules.get(i).getModele(), i, 2);
                this.tableau.setValueAt("---", i, 3);
            }

        }

        //this.t2 = new JTable(this.tableau, title);

        JPanel pan = new JPanel();

        change.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                changeSize(200, 80);
                change.setEnabled(false);
                retablir.setEnabled(true);
            }
        });

        retablir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {

                changeSize(75, 16);
                change.setEnabled(true);
                retablir.setEnabled(false);
            }
        });

        retablir.setEnabled(false);
        pan.add(change);
        pan.add(retablir);

        this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.getContentPane().add(pan, BorderLayout.SOUTH);
    }

    /**
     * Change la taille d'une ligne et d'une colonne
     * J'ai mis deux boucles afin que vous puissiez voir
     * comment parcourir les colonnes et les lignes
     */
    public void changeSize(int width, int height){
        //Nous créons un objet TableColumn afin de travailler sur notre colonne
        TableColumn col;
        for(int i = 0; i < tableau.getColumnCount(); i++){
            if(i == 1){
                //On récupère le modèle de la colonne
                col = tableau.getColumnModel().getColumn(i);
                //On lui affecte la nouvelle valeur
                col.setPreferredWidth(width);
            }
        }
        for(int i = 0; i < tableau.getRowCount(); i++){
            //On affecte la taille de la ligne à l'indice spécifié !
            if(i == 1)
                tableau.setRowHeight(i, height);
        }
    }

    public static void main(String[] args){
        Fenetre fen = new Fenetre();
        fen.setVisible(true);
    }


}
