package bazusek.ui.views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ola on 2018-05-29.
 */
public class StudentDataView extends JFrame {
    JFrame frame = new JFrame("studentData");

    public StudentDataView() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Management Application");
        setSize(500, 500);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setState(Frame.NORMAL);
        GridLayout layout = new GridLayout();
        getContentPane().setLayout(layout);

        JLabel label=new JLabel("Dane studenta");

        String[] labels = {"imię:" , "drugie imię:", "nazwisko:", "pesel:", "imię matki:", "imię ojca:", "telefon:", "adres zameldowania", "adres do korespondencji"};
        int numPairs = labels.length;

        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(9);
            l.setLabelFor(textField);
            p.add(textField);
        }

        p.add(label);
        add(p);
        setVisible(true);
        show();
    }
}
