package bazusek.ui.views;

import bazusek.dao.StudentDAO;
import bazusek.dao.TeacherDAO;
import bazusek.models.Student;
import bazusek.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ola on 2018-05-31.
 */
public class TeacherDataEditPanel extends JPanel{

    @Autowired
    TeacherDAO teacherDAO;

    public TeacherDataEditPanel(){

        GridLayout layout = new GridLayout(0, 2, 10, 10);
        setLayout(layout);

        JLabel label = new JLabel("Dane nauczyciela");
        String[] labels = {"imię:", "drugie imię:", "nazwisko:", "pesel:", "imię matki:", "imię ojca:", "telefon:"};
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

        JLabel motherName = new JLabel(labels[4], JLabel.TRAILING);
        motherName.setLocation(4, 1);
        motherName.setSize(1, 1);
        add(motherName, 4, 0);

        JTextField textMotherName = new JTextField();
        textMotherName.setEditable(true);
        textMotherName.setSize(25, 20);
        motherName.setLabelFor(textMotherName);
        add(textMotherName, 4, 1);

        JLabel fatherName = new JLabel(labels[5], JLabel.TRAILING);
        fatherName.setLocation(5, 1);
        fatherName.setSize(1, 1);
        add(fatherName, 5, 0);

        JTextField textFatherName = new JTextField();
        textFatherName.setEditable(true);
        textFatherName.setSize(25, 20);
        fatherName.setLabelFor(textFatherName);
        add(textFatherName, 5, 1);

        JLabel phone = new JLabel(labels[6], JLabel.TRAILING);
        phone.setLocation(6, 1);
        phone.setSize(1, 1);
        add(phone, 6, 0);

        JTextField textPhone = new JTextField();
        textPhone.setEditable(true);
        textPhone.setSize(25, 20);
        phone.setLabelFor(textPhone);
        add(textPhone, 6, 1);

        JButton button = new JButton("Zapisz zmiany");
        button.addActionListener(event -> {
            System.out.println("Dodawanie nowego nauczyciela");
            Teacher teacher = teacherDAO.save(new Teacher(textName.getText(), textSecondName.getText(),
                    textSurname.getText(), textPesel.getText(), textMotherName.getText(), textFatherName.getText(),
                    textPhone.getText()));
            System.out.println("DOdany nauczyciel: "+ teacher);
        });
        add(button);
        updateUI();
    }

}
