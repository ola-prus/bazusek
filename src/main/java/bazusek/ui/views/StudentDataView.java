package bazusek.ui.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ola on 2018-05-29.
 */
public class StudentDataView extends JFrame  {

    //@Autowired
    //Frame frame;
//    @Autowired
//    private ApplicationContext appContext;

    public StudentDataView() {

        JFrame frame=new JFrame();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Management Application");
        setSize(500, 500);
        setResizable(true);
        setLocationRelativeTo(null);
        GridLayout layout=new GridLayout(0,2,10,10);
        setLayout(layout);


        JLabel label=new JLabel("Dane studenta");
        String[] labels = {"imię:" , "drugie imię:", "nazwisko:", "pesel:", "imię matki:", "imię ojca:", "telefon:", "adres zameldowania", "adres do korespondencji"};
        int numPairs = labels.length;

        //Create and populate the panel.
        JPanel p = new JPanel();
        p.add(label);
        JButton button=new JButton("Zapisz zmiany");
        p.add(button);


        p.setLayout(layout);
        p.updateUI();
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            l.setLocation(i,1);
            l.setSize(1,1);
            p.add(l,i,0);


            JTextField textField = new JTextField();
            textField.setEditable(true);
            textField.setText("abds");
            textField.setSize(25,20);
            l.setLabelFor(textField);
            p.add(textField,i,1);


        }
        p.updateUI();
        add(p);
        setVisible(true);

    }
}
