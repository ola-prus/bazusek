package bazusek.ui.views;

import bazusek.dao.StudentDAO;
import bazusek.dao.StudentDAOImpl;
import bazusek.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ola on 2018-05-22.
 */

public class ListStudentView extends JFrame{

    @Autowired
    StudentDAO studentDAO; //widzi beana

    @Autowired
    private ApplicationContext appContext;

//    @Autowired
//    MainFrame frame; //nie widzi beana

    public ListStudentView(){
       // System.out.println(frame);

//z kontrolera otwiera sie w nowej ramce jesli tu stworze ramke od podstaw
        JPanel panel=new JPanel();
        JLabel label = new JLabel("Lista studentów");
        String listSt[]={"nmim", "gcgfc", "fyvh", "jgv", "vgh", "vfc", "v", "rtrhg", "iugyh", "bgvfgfdhjnbkknjvgcdxcbnkkjknbb", "nnbvh bbkjk"};
        JList list = new JList(listSt); //dodac z automatu iteracje do tej listy studentow

        JScrollPane scrollPane = new JScrollPane(list);
        JButton button = new JButton("Dodaj");

        panel.add(label);
        panel.add(scrollPane);



        getContentPane().add(BorderLayout.NORTH, label);
        getContentPane().add(BorderLayout.CENTER, scrollPane);
        getContentPane().add(BorderLayout.AFTER_LINE_ENDS, button);

        System.out.println(appContext);




    }
}
