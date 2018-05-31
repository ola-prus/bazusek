package bazusek.ui.views;

import javax.swing.*;

/**
 * Created by Ola on 2018-05-31.
 */
public class AppMenu extends JMenuBar {

    public AppMenu(MainFrame mainFrame, StudentListPanel studentListPanel, StudentMarksPanel studentMarksPanel, StudentDataEditPanel studentDataEditPanel, TeacherListPanel teacherListPanel, TeacherDataEditPanel teacherDataEditPanel, SubjectsPanel subjectsPanel) {
        JMenu menu = new JMenu("Student");
        JMenu menu2=new JMenu("Nauczyciel");
        add(menu);
        add(menu2);

        JMenuItem studentListItem = new JMenuItem("Lista studentów");
        studentListItem.addActionListener(event -> {
            System.out.println("Przejscie do listy studentów");
            mainFrame.setContentPane(studentListPanel);
            studentMarksPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectsPanel.setVisible(false);
            studentListPanel.setVisible(true);
        });
        menu.add(studentListItem);

        JMenuItem studentMarksItem = new JMenuItem("Oceny");
        studentMarksItem.addActionListener(event -> {
            System.out.println("Przejscie do listy ocen");
            mainFrame.setContentPane(studentMarksPanel);
            studentListPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectsPanel.setVisible(false);
            studentMarksPanel.setVisible(true);
        });
        menu.add(studentMarksItem);

        JMenuItem studentDataEditItem = new JMenuItem("Dane studenta / Edycja");
        studentDataEditItem.addActionListener(event -> {
            System.out.println("Przejscie do edycji danych studenta");
            mainFrame.setContentPane(studentDataEditPanel);
            studentListPanel.setVisible(false);
            studentMarksPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectsPanel.setVisible(false);
            studentDataEditPanel.setVisible(true);
        });
        menu.add(studentDataEditItem);

        JMenuItem teacherListItem = new JMenuItem("Lista nauczycieli");
        teacherListItem.addActionListener(event -> {
            System.out.println("Przejscie do listy nauczycieli");
            mainFrame.setContentPane(teacherListPanel);
            studentMarksPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            studentListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectsPanel.setVisible(false);
            teacherListPanel.setVisible(true);
        });
        menu2.add(teacherListItem);

        JMenuItem teacherDataEditItem = new JMenuItem("Dane nauczyciela / Edycja");
        teacherDataEditItem.addActionListener(event -> {
            System.out.println("Przejscie do edycji danych");
            mainFrame.setContentPane(teacherDataEditPanel);
            studentMarksPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            studentListPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            subjectsPanel.setVisible(false);
            teacherDataEditPanel.setVisible(true);
        });
        menu2.add(teacherDataEditItem);

        JMenuItem subjectsItem = new JMenuItem("Przedmioty / Obsada");
        subjectsItem.addActionListener(event -> {
            System.out.println("Przejscie do listy przedmiotów i nauczycieli");
            mainFrame.setContentPane(subjectsPanel);
            studentMarksPanel.setVisible(false);
            studentDataEditPanel.setVisible(false);
            studentListPanel.setVisible(false);
            teacherListPanel.setVisible(false);
            teacherDataEditPanel.setVisible(false);
            subjectsPanel.setVisible(true);
        });
        menu2.add(subjectsItem);
    }
}
