package bazusek.ui.views;

import bazusek.dao.StudentDAO;
import bazusek.dao.StudentAddressDAO;
import bazusek.models.Student;
import bazusek.models.StudentAddress;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Ola on 2018-05-22.
 */

public class StudentListPanel extends JPanel {

    @Autowired
    StudentDAO studentDAO;

    private DefaultListModel listModel;

    public StudentListPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JButton refreshButton = new JButton("Pokaż listę studentów");
        refreshButton.addActionListener(event -> {
            refreshStudentList();
        });
        add(refreshButton);

        listModel = new DefaultListModel();

        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(400, 400));
        add(listScroller);

        JButton deleteButton = new JButton("Usuń studenta");
        deleteButton.addActionListener(event -> {
            studentDAO.delete(3);
        });
        add(deleteButton);
    }

    public void refreshStudentList() {
        listModel.clear();
        List<Student> studentList = studentDAO.studentList();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentDAO.studentList());
            listModel.addElement( studentList.get(i).getId_student()+". " + studentList.get(i).getFirst_name() + " "
                    + studentList.get(i).getLast_name());
        }
    }
}