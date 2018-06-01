package bazusek.ui.views;

import bazusek.dao.StudentDAO;
import bazusek.dao.StudentDAOImpl;
import bazusek.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Ola on 2018-05-22.
 */

public class StudentListPanel extends JPanel {

    @Autowired
    StudentDAO studentDAO;

    private DefaultListModel listModel;

    public StudentListPanel() {
        listModel = new DefaultListModel();

        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(400, 400));

        JButton refreshButton = new JButton("Pokaż listę studentów");
        refreshButton.addActionListener(event -> {
            refreshStudentsList();
        });
        add(refreshButton);

        add(listScroller);
    }

    public void refreshStudentsList() {
        listModel.clear();
        List<Student> studentList = studentDAO.studentList();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentDAO.studentList());
            listModel.addElement( studentList.get(i).getId_student()+". " + studentList.get(i).getFirst_name() + " " + studentList.get(i).getLast_name());
        }
    }
}