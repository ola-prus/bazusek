package bazusek.views;

import bazusek.dao.SubjectDAO;
import bazusek.dao.TeacherDAO;
import bazusek.models.Subject;
import bazusek.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

/**
 * Created by Ola on 2018-05-31.
 */
public class TeacherListPanel extends JPanel {
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
    TeacherDAO teacherDAO;

    @Autowired
    SubjectDAO subjectDAO;

    private DefaultListModel listModel;
    int selectionNr;

    public TeacherListPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

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
        listScroller.setPreferredSize(new Dimension(400, 400));

        JButton refreshButton = new JButton("Pokaż listę nauczycieli");
        refreshButton.addActionListener(event -> {
            refreshTeacherList();
        });
        add(refreshButton);

        add(listScroller);

        JButton dataButton = new JButton("Szczegółowe dane / Edycja");
        dataButton.addActionListener(event -> {
            System.out.println("Przejscie do edycji danych nauczyciela");
            mainFrame.setContentPane(teacherDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(true);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);

        });
        add(dataButton);

        JButton showSubjectButton = new JButton("Przedmioty / Zmiana nauczyciela");
        showSubjectButton.addActionListener(event -> {
            System.out.println("Przejscie do przedmiotów");
            mainFrame.setContentPane(subjectTeacherEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(true);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);

        });
        add(showSubjectButton);

        JButton addButton = new JButton("Dodaj nowego nauczyciela");
        addButton.addActionListener(event -> {

            System.out.println("Przejscie do dodawania nauczyciela");
            selectionNr=0;
            mainFrame.setContentPane(teacherDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(true);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);

        });
        add(addButton);

        JButton deleteButton = new JButton("Usuń nauczyciela");
        deleteButton.addActionListener(event -> {
            teacherDAO.delete(selectionNr);
        });
        add(deleteButton);
    }

    public void refreshTeacherList() {
        listModel.clear();
        List<Teacher> teacherList = teacherDAO.teacherList();
        for (int i = 0; i < teacherList.size(); i++) {
            System.out.println(teacherDAO.teacherList());
            listModel.addElement( teacherList.get(i).getId_teacher()+". " + teacherList.get(i).getFirst_name() +
                    " " + teacherList.get(i).getLast_name());
        }
    }
    public int getNr(){
        return selectionNr;
    }
}
