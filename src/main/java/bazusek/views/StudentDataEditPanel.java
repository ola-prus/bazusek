package bazusek.views;

import bazusek.dao.StudentDao;
import bazusek.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-05-29.
 */
public class StudentDataEditPanel extends JPanel  {

    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentListPanel studentListPanel;

    private static final Logger logger = Logger.getLogger(StudentDataEditPanel.class.getName());

    JTextField sTextName;
    JTextField sTextSecondName;
    JTextField sTextLastName;
    JTextField sTextPesel;
    JTextField sTextMotherName;
    JTextField sTextFatherName;
    JTextField sTextPhone;

    public StudentDataEditPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        String[] labels = {"imię:", "drugie imię:", "nazwisko:", "sPesel:", "imię matki:", "imię ojca:", "telefon:"};

        updateUI();

        JLabel mainLabel=new JLabel("DANE STUDENTA");
        add(mainLabel);

        JLabel sName = new JLabel(labels[0], JLabel.TRAILING);
        sName.setLocation(0, 1);
        sName.setSize(1, 1);
        add(sName);

       sTextName=new JTextField();
         sTextName.setEditable(true);
        sTextName.setSize(25, 20);
        sName.setLabelFor(sTextName);
        add(sTextName);

        JLabel sSecondName = new JLabel(labels[1], JLabel.TRAILING);
        sSecondName.setLocation(1, 1);
        sSecondName.setSize(1, 1);
        add(sSecondName);

         sTextSecondName = new JTextField();
        sTextSecondName.setEditable(true);
        sTextSecondName.setSize(25, 20);
        sSecondName.setLabelFor(sTextSecondName);
        add(sTextSecondName);

        JLabel sLastName = new JLabel(labels[2], JLabel.TRAILING);
        sLastName.setLocation(2, 1);
        sLastName.setSize(1, 1);
        add(sLastName);

         sTextLastName = new JTextField();
        sTextLastName.setEditable(true);
        sTextLastName.setSize(25, 20);
        sLastName.setLabelFor(sTextSecondName);
        add(sTextLastName);

        JLabel sPesel = new JLabel(labels[3], JLabel.TRAILING);
        sPesel.setLocation(3, 1);
        sPesel.setSize(1, 1);
        add(sPesel);

         sTextPesel = new JTextField();
        sTextPesel.setEditable(true);
        sTextPesel.setSize(25, 20);
        sPesel.setLabelFor(sTextPesel);
        add(sTextPesel);

        JLabel sMotherName = new JLabel(labels[4], JLabel.TRAILING);
        sMotherName.setLocation(4, 1);
        sMotherName.setSize(1, 1);
        add(sMotherName);

        sTextMotherName = new JTextField();
        sTextMotherName.setEditable(true);
        sTextMotherName.setSize(25, 20);
        sMotherName.setLabelFor(sTextMotherName);
        add(sTextMotherName);

        JLabel sFatherName = new JLabel(labels[5], JLabel.TRAILING);
        sFatherName.setLocation(5, 1);
        sFatherName.setSize(1, 1);
        add(sFatherName);

         sTextFatherName = new JTextField();
        sTextFatherName.setEditable(true);
        sTextFatherName.setSize(25, 20);
        sFatherName.setLabelFor(sTextFatherName);
        add(sTextFatherName);

        JLabel sPhone = new JLabel(labels[6], JLabel.TRAILING);
        sPhone.setLocation(6, 1);
        sPhone.setSize(1, 1);
        add(sPhone);

         sTextPhone = new JTextField();
        sTextPhone.setEditable(true);
        sTextPhone.setSize(25, 20);
        sPhone.setLabelFor(sTextPhone);
        add(sTextPhone);

        JButton sSaveButton = new JButton("Zapisz zmiany");
        sSaveButton.addActionListener(event -> {
            logger.info("Dodawanie nowego studenta");
            Student student = studentDao.save(new Student(sTextName.getText(), sTextSecondName.getText(), sTextLastName.getText(),
                    sTextPesel.getText(), sTextMotherName.getText(), sTextFatherName.getText(), sTextPhone.getText()));
            logger.info("Student dodany");
       });
        add(sSaveButton);
        updateUI();
    }
}

