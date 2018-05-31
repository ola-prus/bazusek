package bazusek.controllers;

import bazusek.ui.views.ListStudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ola on 2018-05-19.
 */

import javax.swing.*;

/**

 *
 */
public class SwingController implements ActionListener {

    JMenuItem mI;
    String name;

    public SwingController(JMenuItem mI){
        super();
        this.mI=mI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        name=mI.getName();
        System.out.println(name);
        switch(name) {
            case "newMi":
                System.out.println("dziala lista studentow");
               // ListStudentView listStudentView=new ListStudentView();
                break;
            case "newMi1":
                System.out.println("dziala edycja studentow");
                break;
            case "newMi2":
                System.out.println("dziala lista nauczycieli");
                break;
            case "newMi3":
                System.out.println("dziala edycja nauczycieli");
                break;
            case "newMi4":
                System.out.println("dziala lista przedmiotów ");
                break;
            case "newMi5":
                System.out.println("dziala edycja przedmiotów");
                break;
            case "newMi6":
                System.out.println("dziala lista ocen ");
                break;
            case "newMi7":
                System.out.println("dziala edycja ocen");
                break;
            default:
                System.out.println("nic nie pasuje");
        }


       /* if (searchTerm != null && !"".equals(searchTerm)) {
            Object[][] newData = new Object[SwingViewConstants.DATA.length][];
            int idx = 0;
            for (Object[] o: SwingViewConstants.DATA) {
                if ("*".equals(searchTerm.trim())) {
                    newData[idx++] = o;   //tu logika dodawania do bazy zamiast tej tabeli constants
                } else {
                    if(String.valueOf(o[0]).startsWith(searchTerm.toUpperCase().trim())){
                        newData[idx++] = o;
                    }
                }
            }
            model.setDataVector(newData, SwingViewConstants.TABLE_HEADER);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }*/
       // new StudentSphereView();

    }

}
