package bazusek.views;

import bazusek.dao.TeacherAssignmentDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * Created by Ola on 2018-05-31.
 */
public class SubjectTeacherEditPanel extends JPanel {

    @Autowired
    TeacherAssignmentDao teacherAssignmentDao;

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
 }
    }

