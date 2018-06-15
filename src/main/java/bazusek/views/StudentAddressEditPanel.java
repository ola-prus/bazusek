package bazusek.views;

import bazusek.dao.StudentAddressDao;
import bazusek.dao.StudentDao;
import bazusek.models.Student;
import bazusek.models.StudentAddress;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-06-01.
 */
public class StudentAddressEditPanel extends JPanel {


    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentAddressDao studentAddressDao;

    @Autowired
    StudentListPanel studentListPanel;

    private static final Logger logger = Logger.getLogger(StudentAddressEditPanel.class.getName());

    public StudentAddressEditPanel(){

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        String[] labels = {"ulica:", "numer domu:", "miasto:", "kod pocztowy:", "kraj:", "typ adresu:"};

        JButton button1 = new JButton("Pokaż adres");
        add(button1);

        updateUI();

        JLabel street = new JLabel(labels[0], JLabel.TRAILING);
        street.setLocation(0, 1);
        street.setSize(1, 1);
        add(street);

        JTextField streetT = new JTextField();
        streetT.setEditable(true);
        streetT.setSize(25, 20);
        street.setLabelFor(streetT);
        add(streetT);

        JLabel nr = new JLabel(labels[1], JLabel.TRAILING);
        nr.setLocation(1, 1);
        nr.setSize(1, 1);
        add(nr);

        JTextField nrT = new JTextField();
        nrT.setEditable(true);
        nrT.setSize(25, 20);
        nr.setLabelFor(nrT);
        add(nrT);

        JLabel city = new JLabel(labels[2], JLabel.TRAILING);
        city.setLocation(2, 1);
        city.setSize(1, 1);
        add(city);

        JTextField cityT = new JTextField();
        cityT.setEditable(true);
        cityT.setSize(25, 20);
        city.setLabelFor(nrT);
        add(cityT);

        JLabel postal = new JLabel(labels[3], JLabel.TRAILING);
        postal.setLocation(3, 1);
        postal.setSize(1, 1);
        add(postal);

        JTextField postalT = new JTextField();
        postalT.setEditable(true);
        postalT.setSize(25, 20);
        postal.setLabelFor(postalT);
        add(postalT);

        JLabel country = new JLabel(labels[4], JLabel.TRAILING);
        country.setLocation(4, 1);
        country.setSize(1, 1);
        add(country);

        JTextField countryT = new JTextField();
        countryT.setEditable(true);
        countryT.setSize(25, 20);
        country.setLabelFor(countryT);
        add(countryT);

        JLabel type = new JLabel(labels[5], JLabel.TRAILING);
        type.setLocation(5, 1);
        type.setSize(1, 1);
        add(type);

        JTextField typeT = new JTextField();
        typeT.setEditable(true);
        typeT.setSize(25, 20);
        type.setLabelFor(typeT);
        add(typeT);

         button1.addActionListener(event -> {
            logger.info("Edytuj adres");
             if (studentListPanel.getNr()!=0) {
                 StudentAddress studentAddress = studentAddressDao.showAddress(studentListPanel.getNr());
                 streetT.setText(studentAddress.getStreet());
                 nrT.setText(studentAddress.getBuildingNr());
                 cityT.setText(studentAddress.getCity());
                 postalT.setText(studentAddress.getPostalCode());
                 countryT.setText(studentAddress.getCountry());
                 typeT.setText(studentAddress.getType());
             }
        });


        JButton button = new JButton("Zapisz zmiany");
        button.addActionListener(event -> {
            logger.info("Edytuj adres");
            Student student = new Student();
            student.setIdStudent(1);
            StudentAddress studentAddress = studentAddressDao.save(new StudentAddress(streetT.getText(), nrT.getText(), cityT.getText(),
                    postalT.getText(), countryT.getText(),student, typeT.getText()));
            logger.info("Adres dodany");
        });

        add(button);

        updateUI();
    }
}
