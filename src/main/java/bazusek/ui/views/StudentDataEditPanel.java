package bazusek.ui.views;

import bazusek.dao.StudentDAO;
import bazusek.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ola on 2018-05-29.
 */
public class StudentDataEditPanel extends JPanel  {

    @Autowired
    StudentDAO studentDAO;

    public StudentDataEditPanel() {


        GridLayout layout = new GridLayout(0, 2, 10, 10);
        setLayout(layout);

        JLabel label = new JLabel("Dane studenta");
        String[] labels = {"imię:", "drugie imię:", "nazwisko:", "pesel:", "imię matki:", "imię ojca:", "telefon:"}; //, "adres zameldowania:", "adres do korespondencji:"};
        int numPairs = labels.length;
        add(label);
        updateUI();

        JLabel name = new JLabel(labels[0], JLabel.TRAILING);
        name.setLocation(0, 1);
        name.setSize(1, 1);
        add(name, 0, 0);

        JTextField textName = new JTextField();
         textName.setEditable(true);
        textName.setSize(25, 20);
        name.setLabelFor(textName);
        add(textName, 0, 1);

        JLabel secondName = new JLabel(labels[1], JLabel.TRAILING);
        secondName.setLocation(1, 1);
        secondName.setSize(1, 1);
        add(secondName, 1, 0);

        JTextField textSecondName = new JTextField();
        textSecondName.setEditable(true);
        textSecondName.setSize(25, 20);
        secondName.setLabelFor(textSecondName);
        add(textSecondName, 1, 1);

        JLabel surname = new JLabel(labels[2], JLabel.TRAILING);
        surname.setLocation(2, 1);
        surname.setSize(1, 1);
        add(surname, 2, 0);

        JTextField textSurname = new JTextField();
        textSurname.setEditable(true);
        textSurname.setSize(25, 20);
        surname.setLabelFor(textSecondName);
        add(textSurname, 2, 1);

        JLabel pesel = new JLabel(labels[3], JLabel.TRAILING);
        pesel.setLocation(3, 1);
        pesel.setSize(1, 1);
        add(pesel, 3, 0);

        JTextField textPesel = new JTextField();
        textPesel.setEditable(true);
        textPesel.setSize(25, 20);
        pesel.setLabelFor(textPesel);
        add(textPesel, 3, 1);

        JLabel imieMatki = new JLabel(labels[4], JLabel.TRAILING);
        imieMatki.setLocation(4, 1);
        imieMatki.setSize(1, 1);
        add(imieMatki, 4, 0);

        JTextField textImieMatki = new JTextField();
        textImieMatki.setEditable(true);
        textImieMatki.setSize(25, 20);
        imieMatki.setLabelFor(textImieMatki);
        add(textImieMatki, 4, 1);

        JLabel imieOjca = new JLabel(labels[5], JLabel.TRAILING);
        imieOjca.setLocation(5, 1);
        imieOjca.setSize(1, 1);
        add(imieOjca, 5, 0);

        JTextField textImieOjca = new JTextField();
        textImieOjca.setEditable(true);
        textImieOjca.setSize(25, 20);
        imieOjca.setLabelFor(textImieOjca);
        add(textImieOjca, 5, 1);

        JLabel telefon = new JLabel(labels[6], JLabel.TRAILING);
        telefon.setLocation(6, 1);
        telefon.setSize(1, 1);
        add(telefon, 6, 0);

        JTextField textTelefon = new JTextField();
        textTelefon.setEditable(true);
        textTelefon.setSize(25, 20);
        telefon.setLabelFor(textTelefon);
        add(textTelefon, 6, 1);

//        JLabel adZam = new JLabel(labels[7], JLabel.TRAILING);
//        adZam.setLocation(7, 1);
//        adZam.setSize(1, 1);
//        add(adZam, 7, 0);
//
//        JTextField textAdZam = new JTextField();
//        textAdZam.setEditable(true);
//        textAdZam.setSize(25, 20);
//        adZam.setLabelFor(textAdZam);
//        add(textAdZam, 7, 1);
//
//        JLabel adKor = new JLabel(labels[8], JLabel.TRAILING);
//        adKor.setLocation(8, 1);
//        adKor.setSize(1, 1);
//        add(adKor, 8, 0);
//
//        JTextField textAdKor = new JTextField();
//        textAdKor.setEditable(true);
//        textAdKor.setSize(25, 20);
//        adKor.setLabelFor(textAdKor);
//        add(textAdKor, 8, 1);

        JButton button = new JButton("Zapisz zmiany");
        button.addActionListener(event -> {
            System.out.println("Dodawanie nowego studenta");
            Student student = studentDAO.save(new Student(textName.getText(), textSecondName.getText(), textSurname.getText(), textPesel.getText(), textImieMatki.getText(), textImieOjca.getText(), textTelefon.getText()));   //, adZam.getText(), adKor.getText()));
            System.out.println("DOdany student: "+ student);
       });
        add(button);
        updateUI();
    }
}

