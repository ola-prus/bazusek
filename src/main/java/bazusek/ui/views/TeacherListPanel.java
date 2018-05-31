package bazusek.ui.views;

import javax.swing.*;

/**
 * Created by Ola on 2018-05-31.
 */
public class TeacherListPanel extends JPanel {
    public TeacherListPanel(){

        JLabel label = new JLabel("Lista nauczycieli");
        String listSt[]={"nmim", "gcgfc", "fyvh", "jgv", "vgh", "vfc", "v", "rtrhg", "iugyh", "bgvfgfdhjnbkknjvgcdxcbnkkjknbb", "nnbvh bbkjk"};
        JList list = new JList(listSt); //dodac z automatu iteracje do tej listy studentow

        JScrollPane scrollPane = new JScrollPane(list);
        JButton button = new JButton("Dodaj");

        add(label);
        add(scrollPane);
    }
}
