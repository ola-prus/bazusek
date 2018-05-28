package bazusek.ui.views;

import bazusek.dao.StudentDAO;
import bazusek.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ola on 2018-05-22.
 */

public class ListStudentView extends JFrame{

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    private ApplicationContext appContext;

    public ListStudentView(){

        MFrame mFrame=new MFrame();
        JFrame frame=mFrame.setMainFrame();
        System.out.println("ramka główna dodana");

        JPanel panel=new JPanel();
        JLabel label = new JLabel("Lista studentów");
        String listSt[]={"nmim", "gcgfc", "fyvh", "jgv", "vgh", "vfc", "v", "rtrhg", "iugyh", "bgvfgfdhjnbkknjvgcdxcbnkkjknbb", "nnbvh bbkjk"};
        JList list = new JList(listSt); //dodac z automatu iteracje do tej listy studentow

        JScrollPane scrollPane = new JScrollPane(list);
        JButton button = new JButton("Dodaj");

        panel.add(label);
        panel.add(scrollPane);



        frame.getContentPane().add(BorderLayout.NORTH, label);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.getContentPane().add(BorderLayout.AFTER_LINE_ENDS, button);

        System.out.println(appContext);

        Student studenci = studentDAO.getById(2);
        System.out.println(studenci);

    }
}
