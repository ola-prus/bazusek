package bazusek.views;

import bazusek.dao.StudentDao;
import bazusek.models.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;
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

    private DefaultListModel sListModel;

    int sSelectionNr;

    private static final Logger logger = Logger.getLogger(StudentListPanel.class.getName());

    public StudentListPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JButton refreshButton = new JButton("Pokaż listę studentów");
        refreshButton.addActionListener(event -> {
            refreshStudentList();
        });
        add(refreshButton);

        sListModel = new DefaultListModel();

        JList sList = new JList(sListModel);
        sList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        sList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        sList.addListSelectionListener(new ListSelectionListener() {
              public void valueChanged(ListSelectionEvent evt) {
                  if (evt.getValueIsAdjusting())
                      return;
                  logger.info("Selected "+sListModel.getElementAt(evt.getLastIndex()));
                  String text= sListModel.getElementAt(evt.getLastIndex()).toString();
                  sSelectionNr=Integer.parseInt(text.replaceAll("[^0-9]", ""));
              }
          });
        JScrollPane listScroller = new JScrollPane(sList);
        listScroller.setPreferredSize(new Dimension(400, 200));
        add(listScroller);

        JButton sDataButton = new JButton("Szczegółowe dane / Edycja");
        sDataButton.addActionListener(event -> {
            logger.info("Przejscie do edycji danych studenta");
            mainFrame.setContentPane(studentDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(true);

        });
        add(sDataButton);

        JButton addressButton = new JButton("Adres / Edycja");
        addressButton.addActionListener(event -> {
            logger.info("Przejscie do edycji adresu studenta");
            mainFrame.setContentPane(studentAddressEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(true);
            studentDataEditPanel.setVisible(false);

        });
        add(addressButton);

        JButton showMarkButton = new JButton("Oceny / Edycja");
        showMarkButton.addActionListener(event -> {
            logger.info("Przejście do ocen studenta");
            mainFrame.setContentPane(studentMarkEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(true);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);

        });
        add(showMarkButton);

        JButton sAddButton = new JButton("Dodaj nowego studenta");
        sAddButton.addActionListener(event -> {
            logger.info("Przejscie do dodawania studenta");
            sSelectionNr=0;
            mainFrame.setContentPane(studentDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(true);

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
        List<Student> studentList = studentDao.studentList();
        for (int i = 0; i < studentList.size(); i++) {
            sListModel.addElement( studentList.get(i).getIdStudent()+". " + studentList.get(i).getsFirstName() + " "
                    + studentList.get(i).getsLastName());
        }
    }

    public int getNr(){
        return sSelectionNr;
    }


}