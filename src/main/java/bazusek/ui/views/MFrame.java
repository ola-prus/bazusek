package bazusek.ui.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Ola on 2018-05-22.
 */
public class MFrame extends JFrame{
    JFrame frame= new JFrame("Student Management Application");


    public JFrame setMainFrame () {

        JFrame frame= new JFrame("Student Management Application");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }
}
