package bazusek.ui.views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ola on 2018-05-31.
 */
public class TeacherDataEditPanel extends JPanel{

    public TeacherDataEditPanel(){

        GridLayout layout = new GridLayout(0, 2, 10, 10);
        setLayout(layout);

        JLabel label = new JLabel("Dane studenta");
        String[] labels = {"imię:", "drugie imię:", "nazwisko:", "pesel:", "imię matki:", "imię ojca:", "telefon:", "adres zameldowania", "adres do korespondencji"};
        int numPairs = labels.length;
        add(label);

        JButton button = new JButton("Zapisz zmiany");
        add(button);
        updateUI();

        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            l.setLocation(i, 1);
            l.setSize(1, 1);
            add(l, i, 0);

            JTextField textField = new JTextField();
            textField.setEditable(true);
            textField.setText("abds");
            textField.setSize(25, 20);
            l.setLabelFor(textField);
            add(textField, i, 1);
        }
        updateUI();

    }

}
