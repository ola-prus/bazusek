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

public class StudentListPanel extends JPanel{

    @Autowired
    StudentDAO studentDAO;

    private DefaultListModel listModel;

    public StudentListPanel(){
       // System.out.println(studentDAO);

//        JLabel label = new JLabel("Lista studentów");
//
//        listModel = new DefaultListModel();
//
//        JList list = new JList();
//        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//
//        JScrollPane listScroller = new JScrollPane(list);
//        listScroller.setPreferredSize(new Dimension(250, 80));
//        add(listScroller);
//
//        List<Student> listStudents=studentDAO.studentList();
//        for (int i = 0; i < listStudents.size(); i++) {
//            System.out.println(studentDAO.studentList());
//            listModel.addElement(i+". "+listStudents.get(i).getFirst_name()+" "+listStudents.get(i).getLast_name());
//        }
//        list.setModel(listModel);
//        add(label);
//        add(list);





//               add(BorderLayout.NORTH, label);
//        add(BorderLayout.CENTER, scrollPane);
//        add(BorderLayout.AFTER_LINE_ENDS, button);  //nie dziala






    }
}
