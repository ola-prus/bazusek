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

    @Autowired
    StudentAddressDAO studentAddressDAO;


    private DefaultListModel listModel;

    public StudentListPanel() {


        listModel = new DefaultListModel();

        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(400, 400));
        add(listScroller);

        JButton refreshButton = new JButton("Pokaż listę studentów");
        refreshButton.addActionListener(event -> {
            refreshStudentsList();
        });
        add(refreshButton);

        JButton deleteButton = new JButton("Usuń studenta");
        refreshButton.addActionListener(event -> {
            studentDAO.delete(4);
        });
        add(deleteButton);



    }

    public void refreshStudentsList() {
        listModel.clear();
        List<Student> studentList = studentDAO.studentList();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentDAO.studentList());
            listModel.addElement( studentList.get(i).getId_student()+". " + studentList.get(i).getFirst_name() + " "
                    + studentList.get(i).getLast_name());
        }
    }
}