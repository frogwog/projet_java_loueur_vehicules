import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

/**
 * Created by Eddy on 06/05/16.
 */
public class Formulaire extends JPanel {


    private JFormattedTextField ftf[];
    private String des[];


    public Formulaire() {


        ftf = new JFormattedTextField[2];
        des =  new String[ftf.length]; // description of each field

        des[0] = "Kilometrage";
        ftf[0] = new JFormattedTextField(new Integer(10000));

        des[1] = "Immatriculation";
        ftf[1] = new JFormattedTextField(new String("AA-999-ZZ"));

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


