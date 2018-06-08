package bazusek.ui.views;

import javax.swing.*;

/**
 * Created by Ola on 2018-05-31.
 */
public class AppMenu extends JMenuBar {

    public AppMenu(MainFrame mainFrame, StudentListPanel studentListPanel, StudentMarkEditPanel studentMarkEditPanel,
                   StudentDataEditPanel studentDataEditPanel, TeacherListPanel teacherListPanel, TeacherDataEditPanel teacherDataEditPanel,
                   SubjectTeacherEditPanel subjectTeacherEditPanel, StudentAddressEditPanel studentAddressEditPanel) {

        JMenu menu = new JMenu("Student");
        JMenu menu2=new JMenu("Nauczyciel");
        add(menu);
        add(menu2);

        JMenuItem studentListItem = new JMenuItem("Lista studentów");
        studentListItem.addActionListener(event -> {
            System.out.println("Przejscie do listy studentów");
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

        JMenuItem studentDataEditItem = new JMenuItem("Dane studenta / Edycja");
        studentDataEditItem.addActionListener(event -> {
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
        menu.add(studentDataEditItem);

        JMenuItem studentMarksItem = new JMenuItem("Oceny");
        studentMarksItem.addActionListener(event -> {
            System.out.println("Przejscie do listy ocen");
            mainFrame.setContentPane(studentMarkEditPanel);
            studentListPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            studentMarkEditPanel.setVisible(true);

        });
        menu.add(studentMarksItem);

        JMenuItem studentHomeAddressItem = new JMenuItem("Adres studenta / Edycja");
        studentHomeAddressItem.addActionListener(event -> {
            System.out.println("Przejscie do edycji adresu studenta");
            mainFrame.setContentPane(studentAddressEditPanel);
            studentMarkEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentListPanel.setVisible(false);
            studentAddressEditPanel.setVisible(true);

        });
        menu.add(studentHomeAddressItem);

        JMenuItem teacherListItem = new JMenuItem("Lista nauczycieli");
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
        menu2.add(teacherListItem);

        JMenuItem teacherDataEditItem = new JMenuItem("Dane nauczyciela / Edycja");
        teacherDataEditItem.addActionListener(event -> {
            System.out.println("Przejscie do edycji danych");
            mainFrame.setContentPane(teacherDataEditPanel);
            studentMarkEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            studentListPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            teacherDataEditPanel.setVisible(true);
        });
        menu2.add(teacherDataEditItem);

        JMenuItem subjectsItem = new JMenuItem("Przedmioty / Obsada");
        subjectsItem.addActionListener(event -> {
            System.out.println("Przejscie do listy przedmiotów i nauczycieli");
            mainFrame.setContentPane(subjectTeacherEditPanel);
            studentMarkEditPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            studentListPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            studentAddressEditPanel.setVisible(false);
            subjectTeacherEditPanel.setVisible(true);
        });
        menu2.add(subjectsItem);
    }
}
