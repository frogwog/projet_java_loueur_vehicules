import org.omg.CORBA.INTERNAL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Eddy on 06/05/16.
 */
public class Formulaire extends JPanel {


    private JFormattedTextField ftf[];
    private String des[];


    public Formulaire(int i) {


        if (i == 0) {
            ftf = new JFormattedTextField[2];
            des =  new String[ftf.length]; // description of each field

            des[0] = "Kilometrage";
            ftf[0] = new JFormattedTextField(new Integer(10000));

            des[1] = "Immatriculation";
            ftf[1] = new JFormattedTextField(new String("AA-999-ZZ"));


        }

        else if (i == 1){
            ftf = new JFormattedTextField[3];
            des =  new String[ftf.length]; // description of each field

            des[0] = "Nom";
            ftf[0] = new JFormattedTextField(new String("Nom"));

            des[1] = "Prenom";
            ftf[1] = new JFormattedTextField(new String("Prenom"));

            des[2] = "Adresse";
            ftf[2] = new JFormattedTextField(new String("Adresse"));


        }

        else if ( i == 2) {

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            ftf = new JFormattedTextField[2];
            des =  new String[ftf.length]; // description of each field

            des[0] = "Date début de location";
            ftf[0] = new JFormattedTextField(format);

            des[1] = "Date de fin prévue";
            ftf[1] = new JFormattedTextField(format);


        }

        else if (i == 3) {

            ftf = new JFormattedTextField[5];
            des =  new String[ftf.length]; // description of each field

            des[0] = "Type du véhicule";
            ftf[0] = new JFormattedTextField(new String());

            des[1] = "Marque";
            ftf[1] = new JFormattedTextField(new String());

            des[2] = "Modele";
            ftf[2] = new JFormattedTextField(new String());

            des[3] = "Cylindrée";
            ftf[3] = new JFormattedTextField(new String());

            des[4] = "Kilometrage";
            ftf[4] = new JFormattedTextField(new Integer(10000));

        }


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (int j = 0; j < ftf.length; j += 1) {
            JPanel borderPanel = new JPanel(new java.awt.BorderLayout());
            borderPanel.setBorder(new javax.swing.border.TitledBorder(des[j]));
            borderPanel.add(ftf[j], java.awt.BorderLayout.CENTER);
            add(borderPanel);
        }

    }

    public JFormattedTextField[] getFtf () {
        return ftf;
    }


}


