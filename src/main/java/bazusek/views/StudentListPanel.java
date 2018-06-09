package bazusek.views;

import bazusek.dao.StudentDAO;
import bazusek.models.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

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
    StudentDAO studentDAO;

    private DefaultListModel listModel;
    int selectionNr;

    public StudentListPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JButton refreshButton = new JButton("Pokaż listę studentów");
        refreshButton.addActionListener(event -> {
            refreshStudentList();
        });
        add(refreshButton);

        listModel = new DefaultListModel();

        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.addListSelectionListener(new ListSelectionListener() {
              public void valueChanged(ListSelectionEvent evt) {
                  if (evt.getValueIsAdjusting())
                      return;
                  System.out.println("Selected "+listModel.getElementAt(evt.getLastIndex()));
                  String text= listModel.getElementAt(evt.getLastIndex()).toString();
                  selectionNr=Integer.parseInt(text.replaceAll("[^0-9]", ""));
              }
          });
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(400, 200));
        add(listScroller);

        JButton dataButton = new JButton("Szczegółowe dane / Edycja");
        dataButton.addActionListener(event -> {
            System.out.println("Przejscie do edycji danych studenta");
            mainFrame.setContentPane(studentDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(true);

        });
        add(dataButton);

        JButton addressButton = new JButton("Adres / Edycja");
        addressButton.addActionListener(event -> {
            System.out.println("Przejscie do edycji adresu studenta");
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
            System.out.println("Przejście do ocen studenta");
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

        JButton addButton = new JButton("Dodaj nowego studenta");
        addButton.addActionListener(event -> {
            System.out.println("Przejscie do dodawania studenta");
            selectionNr=0;
            mainFrame.setContentPane(studentDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(true);

        });
        add(addButton);

        JButton deleteButton = new JButton("Usuń studenta");
        deleteButton.addActionListener(event -> {
            studentDAO.delete(selectionNr);
        });
        add(deleteButton);
    }

    public void refreshStudentList() {
        listModel.clear();
        List<Student> studentList = studentDAO.studentList();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentDAO.studentList());
            listModel.addElement( studentList.get(i).getId_student()+". " + studentList.get(i).getFirst_name() + " "
                    + studentList.get(i).getLast_name());
        }
    }

    public int getNr(){
        return selectionNr;
    }


}