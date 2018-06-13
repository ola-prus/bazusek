package bazusek.views;

import bazusek.dao.TeacherAssignmentDAO;
import bazusek.models.Subject;
import bazusek.models.Teacher;
import bazusek.models.TeacherAssignment;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Ola on 2018-05-31.
 */
public class SubjectTeacherEditPanel extends JPanel {

    @Autowired
    TeacherAssignmentDAO teacherAssignmentDAO;


    int selectionNr;
    TableModel dataModel;
    public SubjectTeacherEditPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JButton refreshButton = new JButton("Pokaż listę");
        refreshButton.addActionListener(event -> {
            refreshList();
        });
        add(refreshButton);

        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return 2; }
            public int getRowCount() { return 10;}
            public Object getValueAt(int row, int col) { return new Integer(row*col); }
        };

    }
    public void refreshList() {
//         datamodel.clear();
//        List<TeacherAssignment> list = teacherAssignmentDAO.teacherAssignmentList();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(teacherAssignmentDAO.teacherAssignmentList());
//            listModel.addElement( list.get(i).getId()+". "+list.get(i).getSubject().getSubject()+" - "+
//                    list.get(i).getTeacher().getFirstName()+ " "+list.get(i).getTeacher().getLastName());
        }
    }

