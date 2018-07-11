package bazusek.views;

import bazusek.dao.StudentAddressDao;
import bazusek.dao.StudentDao;
import bazusek.models.Student;
import bazusek.models.StudentAddress;
import javafx.scene.control.SplitPane;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-05-22.
 */

public class StudentListPanel extends JPanel {

    @Autowired
    StudentListPanel studentListPanel;

    @Autowired
    StudentMarkEditPanel studentMarkEditPanel;

    @Autowired
    TeacherListPanel teacherListPanel;

    @Autowired
    TeacherDataEditPanel teacherDataEditPanel;

    @Autowired
    SubjectTeacherEditPanel subjectTeacherEditPanel;

    @Autowired
    StudentAddressEditPanel studentAddressEditPanel;

    @Autowired
    StudentDataEditPanel studentDataEditPanel;

    @Autowired
    MainFrame mainFrame;

    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentAddressDao studentAddressDao;

    @Autowired
    JSplitPane splitPane;

    @Autowired
    ClockPanel clockPanel;

    private DefaultListModel sListModel;

    int sSelectionNr;

    private static final Logger logger = Logger.getLogger(StudentListPanel.class.getName());

    public StudentListPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        updateUI();

        JButton refreshButton = new JButton("Pokaż listę studentów");
        refreshButton.addActionListener(event -> {
            refreshStudentList();
        });
        add(refreshButton);

        sListModel = new DefaultListModel();

        JList sList = new JList(sListModel);
        sList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        sList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        sList.addListSelectionListener(evt -> {
            if (evt.getValueIsAdjusting())
                return;
            logger.info("Selected " + sListModel.getElementAt(sList.getAnchorSelectionIndex()));
            String text = sListModel.getElementAt(sList.getAnchorSelectionIndex()).toString();
            sSelectionNr = Character.getNumericValue(text.replaceAll("[^0-9]", "").charAt(1));
            System.out.println(sSelectionNr);
        });

        JScrollPane listScroller = new JScrollPane(sList);
        listScroller.setPreferredSize(new Dimension(400, 200));
        add(listScroller);

        JButton sDataButton = new JButton("Szczegółowe dane / Edycja");
        sDataButton.addActionListener(event -> {
            if (sSelectionNr != 0) {
                logger.info("Przejscie do edycji danych studenta");
                splitPane.setTopComponent(studentDataEditPanel);
                studentListPanel.setVisible(false);
                studentMarkEditPanel.setVisible(false);
                teacherListPanel.setVisible(false);
                teacherDataEditPanel.setVisible(false);
                subjectTeacherEditPanel.setVisible(false);
                studentAddressEditPanel.setVisible(false);
                studentDataEditPanel.setVisible(true);
                clockPanel.setVisible(true);
                showSData();
            } else logger.info("nie wybrano id");
        });
        add(sDataButton);

        JButton addressButton = new JButton("Adres / Edycja");
        addressButton.addActionListener(event -> {
            if (sSelectionNr != 0) {
                logger.info("Przejscie do edycji adresu studenta");
                splitPane.setTopComponent(studentAddressEditPanel);
                studentListPanel.setVisible(false);
                studentMarkEditPanel.setVisible(false);
                teacherListPanel.setVisible(false);
                teacherDataEditPanel.setVisible(false);
                subjectTeacherEditPanel.setVisible(false);
                studentAddressEditPanel.setVisible(true);
                studentDataEditPanel.setVisible(false);
                clockPanel.setVisible(true);
                if (studentAddressDao.showAddress(sSelectionNr).getStudent().getIdStudent() == sSelectionNr) {
                    showSAddress();
                } else clearAddress();
            } else logger.info("nie wybrano id");
        });
        add(addressButton);

        JButton showMarkButton = new JButton("Oceny / Edycja");
        showMarkButton.addActionListener(event -> {
            logger.info("Przejście do ocen studenta");
            splitPane.setTopComponent(studentMarkEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(true);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            clockPanel.setVisible(true);
        });
        add(showMarkButton);

        JButton sAddButton = new JButton("Dodaj nowego studenta");
        sAddButton.addActionListener(event -> {
            logger.info("Przejscie do dodawania studenta");
            clearSData();
            splitPane.setTopComponent(studentDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(true);
            clockPanel.setVisible(true);
        });
        add(sAddButton);

        JButton sDeleteButton = new JButton("Usuń studenta");
        sDeleteButton.addActionListener(event -> {
            studentDao.delete(sSelectionNr);
        });
        add(sDeleteButton);

    }

    public void refreshStudentList() {
        sListModel.clear();
        logger.info("lista pusta");
         List<Student>studentList = studentDao.studentList();
        for (int i = 0; i < studentList.size(); i++) {
            int nr=1;
            sListModel.addElement( nr+". " + studentList.get(i).getsFirstName() + " "
                    + studentList.get(i).getsLastName()+" ( id: "+studentList.get(i).getIdStudent()+")");
            nr++;
            updateUI();
        }
        logger.info("lista pełna");
        if (studentList.toString().equals("[]"))
            System.out.println("w bazie nie ma żadnych studentów");
    }

    public int getNr(){
        return sSelectionNr;
    }

    void showSData() {

        Student student = studentDao.showStudent(sSelectionNr);
        studentDataEditPanel.sTextName.setText(student.getsFirstName());
        studentDataEditPanel.sTextSecondName.setText(student.getsSecondName());
        studentDataEditPanel.sTextLastName.setText(student.getsLastName());
        studentDataEditPanel.sTextPesel.setText(student.getsPesel());
        studentDataEditPanel.sTextMotherName.setText(student.getsMotherName());
        studentDataEditPanel.sTextFatherName.setText(student.getsFatherName());
        studentDataEditPanel.sTextPhone.setText(student.getsPhone());

    }

    void clearSData(){
        studentDataEditPanel.sTextName.setText("");
        studentDataEditPanel.sTextSecondName.setText("");
        studentDataEditPanel.sTextLastName.setText("");
        studentDataEditPanel.sTextPesel.setText("");
        studentDataEditPanel.sTextMotherName.setText("");
        studentDataEditPanel.sTextFatherName.setText("");
        studentDataEditPanel.sTextPhone.setText("");

    }

    void showSAddress(){
        StudentAddress studentAddress = studentAddressDao.showAddress(sSelectionNr);
        studentAddressEditPanel.streetT.setText(studentAddress.getStreet());
        studentAddressEditPanel.nrT.setText(studentAddress.getBuildingNr());
        studentAddressEditPanel.cityT.setText(studentAddress.getCity());
        studentAddressEditPanel.postalT.setText(studentAddress.getPostalCode());
        studentAddressEditPanel.countryT.setText(studentAddress.getCountry());
        studentAddressEditPanel.typeT.setText(studentAddress.getType());
    }
    void clearAddress(){
        studentAddressEditPanel.streetT.setText("");
        studentAddressEditPanel.nrT.setText("");
        studentAddressEditPanel.cityT.setText("");
        studentAddressEditPanel.postalT.setText("");
        studentAddressEditPanel.countryT.setText("");
        studentAddressEditPanel.typeT.setText("");
    }
}