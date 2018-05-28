package bazusek.ui.views;

import bazusek.ui.models.StudentModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ola on 2018-05-22.
 */
public class ListStudentView extends JFrame{
    public ListStudentView(){

        MFrame mFrame=new MFrame();
        JFrame frame=mFrame.setMainFrame();
        System.out.println("ramka główna dodana");

        /*JTable table = new JTable();
        SwingModel swingModel = new SwingModel();
        table.setModel(swingModel);
        panel2.add(table);
        System.out.println("tabela dodana");*/
        JPanel panel=new JPanel();
        JLabel label = new JLabel("Lista studentów");
        StudentModel studentModel=new StudentModel("mariusz", "łapka"); //jak to przekazac do listy?
        String listSt[]={"nmim", "gcgfc", "fyvh", "jgv", "vgh", "vfc", "v", "rtrhg", "iugyh", "bgvfgfdhjnbkknjvgcdxcbnkkjknbb", "nnbvh bbkjk"};
        JList list = new JList(listSt); //dodac z automatu iteracje do tej listy studentow

        JScrollPane scrollPane = new JScrollPane(list);
        JButton button = new JButton("Dodaj");

        panel.add(label);
        panel.add(scrollPane);



        frame.getContentPane().add(BorderLayout.NORTH, label);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.getContentPane().add(BorderLayout.AFTER_LINE_ENDS, button);






    }
}
