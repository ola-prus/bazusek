package bazusek.views;

/**
 * Created by Ola on 2018-05-28.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.awt.*;
import javax.swing.*;


public class MainFrame extends JFrame {

    @Autowired
    StudentListPanel studentListPanel;

    @Autowired
    StudentMarkEditPanel studentMarkEditPanel;

    @Autowired
    StudentDataEditPanel studentDataEditPanel;

    @Autowired
    TeacherListPanel teacherListPanel;

    @Autowired
    TeacherDataEditPanel teacherDataEditPanel;

    @Autowired
    SubjectTeacherEditPanel subjectTeacherEditPanel;

    @Autowired
    StudentAddressEditPanel studentAddressEditPanel;


    public void init() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Management Application");
        setSize(500, 500);
        setResizable(true);
        setLocationRelativeTo(null);

        setJMenuBar(new AppMenu(this, studentListPanel, studentMarkEditPanel,studentDataEditPanel, teacherListPanel,
                teacherDataEditPanel, subjectTeacherEditPanel, studentAddressEditPanel));

        setContentPane(studentListPanel);
        studentListPanel.setVisible(false);
        setContentPane(studentMarkEditPanel);
        studentMarkEditPanel.setVisible(false);
        setContentPane(studentDataEditPanel);
        studentDataEditPanel.setVisible(false);
        setContentPane(teacherListPanel);
        teacherListPanel.setVisible(false);
        setContentPane(teacherDataEditPanel);
        teacherDataEditPanel.setVisible(false);
        setContentPane(subjectTeacherEditPanel);
        subjectTeacherEditPanel.setVisible(false);
        setContentPane(studentAddressEditPanel);
        studentAddressEditPanel.setVisible(false);

        setState(Frame.NORMAL);
        setVisible(true);
        show();
    }
}