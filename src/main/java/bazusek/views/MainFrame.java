package bazusek.views;

/**
 * Created by Ola on 2018-05-28.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
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

    @Autowired
    ClockPanel clockPanel;

    @Autowired
    JSplitPane splitPane;

    public void init() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Management Application");
        setSize(500, 500);
        setResizable(true);
        setLocationRelativeTo(null);

        setJMenuBar(new AppMenu(this, studentListPanel, studentMarkEditPanel,studentDataEditPanel, teacherListPanel,
                teacherDataEditPanel, subjectTeacherEditPanel, studentAddressEditPanel, clockPanel, splitPane));

        add(splitPane);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(500);
        splitPane.setBottomComponent(clockPanel);
        clockPanel.setVisible(true);

        splitPane.setTopComponent(studentListPanel);
        studentListPanel.setVisible(false);
        splitPane.setTopComponent(studentMarkEditPanel);
        studentMarkEditPanel.setVisible(false);
        splitPane.setTopComponent(studentDataEditPanel);
        studentDataEditPanel.setVisible(false);
        splitPane.setTopComponent(teacherListPanel);
        teacherListPanel.setVisible(false);
        splitPane.setTopComponent(teacherDataEditPanel);
        teacherDataEditPanel.setVisible(false);
        splitPane.setTopComponent(subjectTeacherEditPanel);
        subjectTeacherEditPanel.setVisible(false);
        splitPane.setTopComponent(studentAddressEditPanel);
        studentAddressEditPanel.setVisible(false);

        setState(Frame.NORMAL);
        setVisible(true);
        show();
    }

}