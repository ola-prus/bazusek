package bazusek.views;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-05-31.
 */
public class AppMenu extends JMenuBar {

    @Autowired
    JSplitPane splitPane;

    private static final Logger logger = Logger.getLogger(AppMenu.class.getName());

    public AppMenu(MainFrame mainFrame, StudentListPanel studentListPanel, StudentMarkEditPanel studentMarkEditPanel,
                   StudentDataEditPanel studentDataEditPanel, TeacherListPanel teacherListPanel, TeacherDataEditPanel
                           teacherDataEditPanel, SubjectTeacherEditPanel subjectTeacherEditPanel, StudentAddressEditPanel
                           studentAddressEditPanel, ClockPanel clockPanel, JSplitPane splitPane) {

        JMenu menu = new JMenu("Menu");
        add(menu);

           JMenuItem studentListItem = new JMenuItem("Strefa studenta");
        studentListItem.addActionListener(event -> {
           logger.info("Przejscie do strefy studenta");
            splitPane.setTopComponent(studentListPanel);
            studentMarkEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentListPanel.setVisible(true);
            clockPanel.setVisible(true);
        });
        menu.add(studentListItem);


        JMenuItem teacherListItem = new JMenuItem("Strefa nauczyciela");
        teacherListItem.addActionListener(event -> {
            logger.info("Przejscie do listy nauczycieli");
            splitPane.setTopComponent(teacherListPanel);
            studentMarkEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            studentListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            teacherListPanel.setVisible(true);
            clockPanel.setVisible(true);
        });
        menu.add(teacherListItem);
    }

}
