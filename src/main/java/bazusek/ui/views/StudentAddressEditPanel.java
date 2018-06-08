package bazusek.ui.views;

import bazusek.dao.StudentAddressDAO;
import bazusek.dao.StudentDAO;
import bazusek.models.Student;
import bazusek.models.StudentAddress;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ola on 2018-06-01.
 */
public class StudentAddressEditPanel extends JPanel {


    @Autowired
    StudentDAO studentDAO;

    @Autowired
    StudentAddressDAO studentAddressDAO;

    public StudentAddressEditPanel(){
        GridLayout layout = new GridLayout(0, 2, 10, 10);
        setLayout(layout);

        JLabel label = new JLabel("Adres studenta:");
        String[] labels = {"ulica:", "numer domu:", "miasto:", "kod pocztowy:", "kraj:", "typ adresu:"};
        add(label);
        updateUI();

        JLabel street = new JLabel(labels[0], JLabel.TRAILING);
        street.setLocation(0, 1);
        street.setSize(1, 1);
        add(street, 5, 0);

        JTextField streetT = new JTextField();
        streetT.setEditable(true);
        streetT.setSize(25, 20);
        street.setLabelFor(streetT);
        add(streetT, 5, 1);

        JLabel nr = new JLabel(labels[1], JLabel.TRAILING);
        nr.setLocation(1, 1);
        nr.setSize(1, 1);
        add(nr, 4, 0);

        JTextField nrT = new JTextField();
        nrT.setEditable(true);
        nrT.setSize(25, 20);
        nr.setLabelFor(nrT);
        add(nrT, 4, 1);

        JLabel city = new JLabel(labels[2], JLabel.TRAILING);
        city.setLocation(2, 1);
        city.setSize(1, 1);
        add(city, 3, 0);

        JTextField cityT = new JTextField();
        cityT.setEditable(true);
        cityT.setSize(25, 20);
        city.setLabelFor(nrT);
        add(cityT, 3, 1);

        JLabel postal = new JLabel(labels[3], JLabel.TRAILING);
        postal.setLocation(3, 1);
        postal.setSize(1, 1);
        add(postal, 2, 0);

        JTextField postalT = new JTextField();
        postalT.setEditable(true);
        postalT.setSize(25, 20);
        postal.setLabelFor(postalT);
        add(postalT, 2, 1);

        JLabel country = new JLabel(labels[4], JLabel.TRAILING);
        country.setLocation(4, 1);
        country.setSize(1, 1);
        add(country, 1, 0);

        JTextField countryT = new JTextField();
        countryT.setEditable(true);
        countryT.setSize(25, 20);
        country.setLabelFor(countryT);
        add(countryT, 1, 1);

        JLabel type = new JLabel(labels[5], JLabel.TRAILING);
        type.setLocation(5, 1);
        type.setSize(1, 1);
        add(type, 0, 0);

        JTextField typeT = new JTextField();
        typeT.setEditable(true);
        typeT.setSize(25, 20);
        type.setLabelFor(typeT);
        add(typeT, 0, 1);

        JButton button1 = new JButton("Pokaż adres");
        button1.addActionListener(event -> {
            System.out.println("Edytuj adres");
            Student student = new Student();
            student.setId_student(1); //pozniej bedzie z listy wybierac studenta
            StudentAddress studentAddress = studentAddressDAO.showAddress(1);
            streetT.setText(studentAddress.getStreet());
            nrT.setText(studentAddress.getBuilding_nr());
            cityT.setText(studentAddress.getCity());
            postalT.setText(studentAddress.getPostal_code());
            countryT.setText(studentAddress.getCountry());
            typeT.setText(studentAddress.getType());
        });
        add(button1);

        JButton button = new JButton("Zapisz zmiany");
        button.addActionListener(event -> {
            System.out.println("Edytuj adres");
            Student student = new Student();
            student.setId_student(1); //pozniej bedzie z listy wybierac studenta
            StudentAddress studentAddress = studentAddressDAO.save(new StudentAddress(streetT.getText(), nrT.getText(), cityT.getText(),
                    postalT.getText(), countryT.getText(),student, typeT.getText()));
            System.out.println("Adres dodany: "+ studentAddress);
        });

        add(button);

        updateUI();
    }
}
