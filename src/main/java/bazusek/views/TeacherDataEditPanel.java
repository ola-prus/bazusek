package bazusek.views;

import bazusek.dao.TeacherDao;
import bazusek.models.Teacher;
import com.sun.org.apache.xerces.internal.impl.dv.xs.AbstractDateTimeDV;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-05-31.
 */
public class TeacherDataEditPanel extends JPanel{

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    TeacherListPanel teacherListPanel;

    private static final Logger logger = Logger.getLogger(TeacherDataEditPanel.class.getName());

    JTextField tTextName;
    JTextField tTextSecondName;
    JTextField tTextLastName;
    JTextField tTextPesel;
    JTextField tTextMotherName;
    JTextField tTextFatherName;
    JTextField tTextPhone;

    public TeacherDataEditPanel(){

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        String[] labels = {"imię:", "drugie imię:", "nazwisko:", "tPesel:", "imię matki:", "imię ojca:", "telefon:"};

       JLabel mainLabel=new JLabel("DANE NAUCZYCIELA");
        add(mainLabel);

        updateUI();

        JLabel tName = new JLabel(labels[0], JLabel.TRAILING);
        tName.setLocation(0, 1);
        tName.setSize(1, 1);
        add(tName);

         tTextName = new JTextField();
        tTextName.setEditable(true);
        tTextName.setSize(25, 20);
        tName.setLabelFor(tTextName);
        add(tTextName);

        JLabel tSecondName = new JLabel(labels[1], JLabel.TRAILING);
        tSecondName.setLocation(1, 1);
        tSecondName.setSize(1, 1);
        add(tSecondName);

         tTextSecondName = new JTextField();
        tTextSecondName.setEditable(true);
        tTextSecondName.setSize(25, 20);
        tSecondName.setLabelFor(tTextSecondName);
        add(tTextSecondName);

        JLabel tLastName = new JLabel(labels[2], JLabel.TRAILING);
        tLastName.setLocation(2, 1);
        tLastName.setSize(1, 1);
        add(tLastName);

         tTextLastName = new JTextField();
        tTextLastName.setEditable(true);
        tTextLastName.setSize(25, 20);
        tLastName.setLabelFor(tTextSecondName);
        add(tTextLastName);

        JLabel tPesel = new JLabel(labels[3], JLabel.TRAILING);
        tPesel.setLocation(3, 1);
        tPesel.setSize(1, 1);
        add(tPesel);

         tTextPesel = new JTextField();
        tTextPesel.setEditable(true);
        tTextPesel.setSize(25, 20);
        tPesel.setLabelFor(tTextPesel);
        add(tTextPesel);

        JLabel tMotherName = new JLabel(labels[4], JLabel.TRAILING);
        tMotherName.setLocation(4, 1);
        tMotherName.setSize(1, 1);
        add(tMotherName);

         tTextMotherName = new JTextField();
        tTextMotherName.setEditable(true);
        tTextMotherName.setSize(25, 20);
        tMotherName.setLabelFor(tTextMotherName);
        add(tTextMotherName);

        JLabel tFatherName = new JLabel(labels[5], JLabel.TRAILING);
        tFatherName.setLocation(5, 1);
        tFatherName.setSize(1, 1);
        add(tFatherName);

         tTextFatherName = new JTextField();
        tTextFatherName.setEditable(true);
        tTextFatherName.setSize(25, 20);
        tFatherName.setLabelFor(tTextFatherName);
        add(tTextFatherName);

        JLabel tPhone = new JLabel(labels[6], JLabel.TRAILING);
        tPhone.setLocation(6, 1);
        tPhone.setSize(1, 1);
        add(tPhone);

         tTextPhone = new JTextField();
        tTextPhone.setEditable(true);
        tTextPhone.setSize(25, 20);
        tPhone.setLabelFor(tTextPhone);
        add(tTextPhone);

        JButton tSaveButton = new JButton("Zapisz zmiany");
        tSaveButton.addActionListener(event -> {
            logger.info("Dodawanie nowego nauczyciela");
            Teacher teacher = teacherDao.save(new Teacher(tTextName.getText(), tTextSecondName.getText(),
                    tTextLastName.getText(), tTextPesel.getText(), tTextMotherName.getText(), tTextFatherName.getText(),
                    tTextPhone.getText()));
            logger.info("Nauczyciel dodany");
        });
        add(tSaveButton);
        updateUI();
    }

}
