import javax.swing.*;
import java.awt.*;

/**
 * Created by Eddy on 19/04/16.
 */
public class Panneau extends JPanel {

    public void paintComponent(Graphics g){


        Font font = new Font("Courier", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Entrez votre nom", 20, 100);


    }
}
