package bazusek.ui.views;

/**
 * Created by Ola on 2018-05-28.
 */
import bazusek.controllers.SwingController;
import bazusek.dao.MarksDAO;
import bazusek.dao.StudentDAO;
import bazusek.models.Marks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.transaction.Transactional;


public class MainFrame extends JFrame implements Frame { //mainframe musi byc interfejsem?

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    MarksDAO marksDAO;

    @Transactional
    public void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Management Application");
        setSize(500, 500);
        setResizable(true);
        setLocationRelativeTo(null);

        JMenuBar menubar = createMenu();
        add(menubar);

        FlowLayout flowLayout=new FlowLayout();
        setLayout(flowLayout);
        show();
        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menubar = new JMenuBar(); //lista menu


        JMenu fileMenu = new JMenu("Student"); //jeden skladnik z menu
        fileMenu.setMnemonic(KeyEvent.VK_F); //mnemonic=skladajacy sie slowo klucz z kilku liter
        menubar.add(fileMenu);

        JMenuItem newMi = new JMenuItem("Lista studentów");
        newMi.setName("newMi");
        fileMenu.add(newMi);
        newMi.addActionListener(new SwingController(newMi));
        JMenuItem newMi1 = new JMenuItem("Edycja danych");
        newMi1.addActionListener(new SwingController(newMi1));
        fileMenu.add(newMi1);

        JMenu fileMenu1 = new JMenu("Nauczyciel");
        fileMenu1.setMnemonic(KeyEvent.VK_F);
        menubar.add(fileMenu1);

        JMenuItem newMi2 = new JMenuItem("Lista nauczycieli");
        newMi2.addActionListener(new SwingController(newMi2));
        fileMenu1.add(newMi2);
        JMenuItem newMi3 = new JMenuItem("Edycja danych");
        newMi3.addActionListener(new SwingController(newMi3));
        fileMenu1.add(newMi3);

        JMenu fileMenu2 = new JMenu("Przedmioty");
        fileMenu2.setMnemonic(KeyEvent.VK_F);
        menubar.add(fileMenu2);

        JMenuItem newMi4 = new JMenuItem("Lista przedmiotów");
        newMi4.addActionListener(new SwingController(newMi4));
        fileMenu2.add(newMi4);
        JMenuItem newMi5 = new JMenuItem("Edycja danych");
        newMi5.addActionListener(new SwingController(newMi5));
        fileMenu2.add(newMi5);

        JMenu fileMenu3 = new JMenu("Oceny");
        fileMenu3.setMnemonic(KeyEvent.VK_F);
        menubar.add(fileMenu3);

        JMenuItem newMi6 = new JMenuItem("Lista ocen");
        newMi6.addActionListener(new SwingController(newMi6));
        fileMenu3.add(newMi6);
        JMenuItem newMi7 = new JMenuItem("Edycja danych");
        newMi7.addActionListener(new SwingController(newMi7));
        fileMenu3.add(newMi7);

        return menubar;
    }
    public void add(JPanel panel){
        add(panel);
    }
}