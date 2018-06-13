package bazusek.views;

import bazusek.dao.StudentDAO;
import bazusek.models.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

/**
 * Created by Ola on 2018-05-29.
 */
public class StudentDataEditPanel extends JPanel  {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    StudentListPanel studentListPanel;


    public StudentDataEditPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


        JButton showDataButton = new JButton("Pokaż dane studenta");
        add(showDataButton);

        String[] labels = {"imię:", "drugie imię:", "nazwisko:", "pesel:", "imię matki:", "imię ojca:", "telefon:"};

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
            System.out.println("Edytuj dane");
            if (studentListPanel.getNr()!=0) {
                Student student = studentDAO.showStudent(studentListPanel.getNr());
                textName.setText(student.getFirstName());
                textSecondName.setText(student.getSecondName());
                textSurname.setText(student.getLastName());
                textPesel.setText(student.getPesel());
                textMotherName.setText(student.getMotherName());
                textFatherName.setText(student.getFatherName());
                textPhone.setText(student.getPhone());
            }
        });

        JButton saveButton = new JButton("Zapisz zmiany");
        saveButton.addActionListener(event -> {
            System.out.println("Dodawanie nowego studenta");
            Student student = studentDAO.save(new Student(textName.getText(), textSecondName.getText(), textSurname.getText(),
                    textPesel.getText(), textMotherName.getText(), textFatherName.getText(), textPhone.getText()));
            System.out.println("DOdany student: "+ student);
       });
        add(saveButton);
        updateUI();
    }
}

