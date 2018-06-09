package bazusek.views;

import bazusek.dao.TeacherAssignmentDAO;
import bazusek.models.Student;
import bazusek.models.Subject;
import bazusek.models.Teacher;
import bazusek.models.TeacherAssignment;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.*;

/**
 * Created by Ola on 2018-05-31.
 */
public class SubjectTeacherEditPanel extends JPanel {

    @Autowired
    TeacherAssignmentDAO teacherAssignmentDAO;

    private DefaultListModel listModel;
    int selectionNr;
    public SubjectTeacherEditPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JButton refreshButton = new JButton("Pokaż listę");
        refreshButton.addActionListener(event -> {
            refreshList();
        });
        add(refreshButton);

        listModel = new DefaultListModel();

        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting())
                    return;
                System.out.println("Selected " + listModel.getElementAt(evt.getLastIndex()));
                String text = listModel.getElementAt(evt.getLastIndex()).toString();
                selectionNr = Integer.parseInt(text.replaceAll("[^0-9]", ""));
            }
        });
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(400, 200));
        add(listScroller);
    }
    public void refreshList() {
         listModel.clear();
        java.util.List<TeacherAssignment> list = teacherAssignmentDAO.teacherAssignmentList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(teacherAssignmentDAO.teacherAssignmentList());
            listModel.addElement( list.get(i).getId()+". "+list.get(i).getSubject().getSubject()+" - "+
                    list.get(i).getTeacher().getFirst_name()+ " "+list.get(i).getTeacher().getLast_name());
        }
//        Teacher teacher=new Teacher();
//        Subject subject=new Subject();
//        teacher.setId_teacher(2);
//        subject.setId_subject(3);
//        teacherAssignmentDAO.save(new TeacherAssignment(subject,teacher));
//        System.out.println("nauczyciel do przedmiotu przypisany");


    }
}
