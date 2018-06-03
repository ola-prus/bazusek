package bazusek.ui.views;

import bazusek.dao.TeacherDAO;
import bazusek.models.Student;
import bazusek.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Ola on 2018-05-31.
 */
public class TeacherListPanel extends JPanel {

    @Autowired
    TeacherDAO teacherDAO;

    private DefaultListModel listModel;

    public TeacherListPanel() {
        listModel = new DefaultListModel();

        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(400, 400));

        JButton refreshButton = new JButton("Pokaż listę nauczycieli");
        refreshButton.addActionListener(event -> {
            refreshTeacherList();
        });
        add(refreshButton);

        add(listScroller);
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
}
