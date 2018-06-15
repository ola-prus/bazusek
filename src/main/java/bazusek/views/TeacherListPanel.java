package bazusek.views;

import bazusek.dao.SubjectDao;
import bazusek.dao.TeacherDao;
import bazusek.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;
import java.util.logging.Logger;

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
    TeacherDao teacherDao;

    @Autowired
    SubjectDao subjectDao;

    private DefaultListModel tListModel;

    int tSelectionNr;

    private static final Logger logger = Logger.getLogger(TeacherListPanel.class.getName());

    public TeacherListPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        tListModel = new DefaultListModel();

        JList tList = new JList(tListModel);
        tList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        tList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting())
                    return;
                logger.info("Selected "+tListModel.getElementAt(evt.getLastIndex()));
                String text= tListModel.getElementAt(evt.getLastIndex()).toString();
                tSelectionNr=Integer.parseInt(text.replaceAll("[^0-9]", ""));
            }
        });

        JScrollPane listScroller = new JScrollPane(tList);
        listScroller.setPreferredSize(new Dimension(400, 400));

        JButton refreshButton = new JButton("Pokaż listę nauczycieli");
        refreshButton.addActionListener(event -> {
            refreshTeacherList();
        });
        add(refreshButton);

        add(listScroller);

        JButton tDataButton = new JButton("Szczegółowe dane / Edycja");
        tDataButton.addActionListener(event -> {
            logger.info("Przejscie do edycji danych nauczyciela");
            mainFrame.setContentPane(teacherDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(true);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);

        });
        add(tDataButton);

        JButton showSubjectButton = new JButton("Przedmioty / Zmiana nauczyciela");
        showSubjectButton.addActionListener(event -> {
            logger.info("Przejscie do przedmiotów");
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

        JButton tAddButton = new JButton("Dodaj nowego nauczyciela");
        tAddButton.addActionListener(event -> {

            logger.info("Przejscie do dodawania nauczyciela");
            tSelectionNr=0;
            mainFrame.setContentPane(teacherDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarkEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(true);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);

        });
        add(tAddButton);

        JButton tDeleteButton = new JButton("Usuń nauczyciela");
        tDeleteButton.addActionListener(event -> {
            teacherDao.delete(tSelectionNr);
        });
        add(tDeleteButton);
    }

    public void refreshTeacherList() {
        tListModel.clear();
        List<Teacher> teacherList = teacherDao.teacherList();
        for (int i = 0; i < teacherList.size(); i++) {
            tListModel.addElement( teacherList.get(i).getIdTeacher()+". " + teacherList.get(i).gettFirstName() +
                    " " + teacherList.get(i).gettLastName());
        }
    }
    public int getNr(){
        return tSelectionNr;
    }
}
