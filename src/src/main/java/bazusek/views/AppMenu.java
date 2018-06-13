package bazusek.views;

import javax.swing.*;

/**
 * Created by Ola on 2018-05-31.
 */
public class AppMenu extends JMenuBar {

    public AppMenu(MainFrame mainFrame, StudentListPanel studentListPanel, StudentMarkEditPanel studentMarkEditPanel,
                   StudentDataEditPanel studentDataEditPanel, TeacherListPanel teacherListPanel, TeacherDataEditPanel teacherDataEditPanel,
                   SubjectTeacherEditPanel subjectTeacherEditPanel, StudentAddressEditPanel studentAddressEditPanel) {

        JMenu menu = new JMenu("Menu");
        add(menu);

        JMenuItem studentListItem = new JMenuItem("Strefa studenta");
        studentListItem.addActionListener(event -> {
            System.out.println("Przejscie do strefy studenta");
            mainFrame.setContentPane(studentListPanel);
            studentMarkEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentListPanel.setVisible(true);
        });
        menu.add(studentListItem);


        JMenuItem teacherListItem = new JMenuItem("Strefa nauczyciela");
        teacherListItem.addActionListener(event -> {
            System.out.println("Przejscie do listy nauczycieli");
            mainFrame.setContentPane(teacherListPanel);
            studentMarkEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            studentListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            teacherListPanel.setVisible(true);
        });
        menu.add(teacherListItem);
    }
}
