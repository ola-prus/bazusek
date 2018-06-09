package bazusek.views;

import bazusek.dao.TeacherDAO;
import bazusek.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

/**
 * Created by Ola on 2018-05-31.
 */
public class TeacherDataEditPanel extends JPanel{

    @Autowired
    TeacherDAO teacherDAO;

    @Autowired
    TeacherListPanel teacherListPanel;

    public TeacherDataEditPanel(){

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        String[] labels = {"imię:", "drugie imię:", "nazwisko:", "pesel:", "imię matki:", "imię ojca:", "telefon:"};

        JButton showDataButton = new JButton("Pokaż dane nauczyciela");
        add(showDataButton);
        updateUI();

        JLabel name = new JLabel(labels[0], JLabel.TRAILING);
        name.setLocation(0, 1);
        name.setSize(1, 1);
        add(name);

        JTextField textName = new JTextField();
        textName.setEditable(true);
        textName.setSize(25, 20);
        name.setLabelFor(textName);
        add(textName);

        JLabel secondName = new JLabel(labels[1], JLabel.TRAILING);
        secondName.setLocation(1, 1);
        secondName.setSize(1, 1);
        add(secondName);

        JTextField textSecondName = new JTextField();
        textSecondName.setEditable(true);
        textSecondName.setSize(25, 20);
        secondName.setLabelFor(textSecondName);
        add(textSecondName);

        JLabel surname = new JLabel(labels[2], JLabel.TRAILING);
        surname.setLocation(2, 1);
        surname.setSize(1, 1);
        add(surname);

        JTextField textSurname = new JTextField();
        textSurname.setEditable(true);
        textSurname.setSize(25, 20);
        surname.setLabelFor(textSecondName);
        add(textSurname);

        JLabel pesel = new JLabel(labels[3], JLabel.TRAILING);
        pesel.setLocation(3, 1);
        pesel.setSize(1, 1);
        add(pesel);

        JTextField textPesel = new JTextField();
        textPesel.setEditable(true);
        textPesel.setSize(25, 20);
        pesel.setLabelFor(textPesel);
        add(textPesel);

        JLabel motherName = new JLabel(labels[4], JLabel.TRAILING);
        motherName.setLocation(4, 1);
        motherName.setSize(1, 1);
        add(motherName);

        JTextField textMotherName = new JTextField();
        textMotherName.setEditable(true);
        textMotherName.setSize(25, 20);
        motherName.setLabelFor(textMotherName);
        add(textMotherName);

        JLabel fatherName = new JLabel(labels[5], JLabel.TRAILING);
        fatherName.setLocation(5, 1);
        fatherName.setSize(1, 1);
        add(fatherName);

        JTextField textFatherName = new JTextField();
        textFatherName.setEditable(true);
        textFatherName.setSize(25, 20);
        fatherName.setLabelFor(textFatherName);
        add(textFatherName);

        JLabel phone = new JLabel(labels[6], JLabel.TRAILING);
        phone.setLocation(6, 1);
        phone.setSize(1, 1);
        add(phone);

        JTextField textPhone = new JTextField();
        textPhone.setEditable(true);
        textPhone.setSize(25, 20);
        phone.setLabelFor(textPhone);
        add(textPhone);

        showDataButton.addActionListener(event -> {
            System.out.println("Edytuj dane nauczyciela");
            if (teacherListPanel.getNr()!=0) {
                Teacher teacher = teacherDAO.showTeacher(teacherListPanel.getNr());
                textName.setText(teacher.getFirst_name());
                textSecondName.setText(teacher.getSecond_name());
                textSurname.setText(teacher.getLast_name());
                textPesel.setText(teacher.getPesel());
                textMotherName.setText(teacher.getMother_name());
                textFatherName.setText(teacher.getFather_name());
                textPhone.setText(teacher.getPhone());
            }
        });

        JButton saveButton = new JButton("Zapisz zmiany");
        saveButton.addActionListener(event -> {
            System.out.println("Dodawanie nowego nauczyciela");
            Teacher teacher = teacherDAO.save(new Teacher(textName.getText(), textSecondName.getText(),
                    textSurname.getText(), textPesel.getText(), textMotherName.getText(), textFatherName.getText(),
                    textPhone.getText()));
            System.out.println("DOdany nauczyciel: "+ teacher);
        });
        add(saveButton);
        updateUI();
    }

}
