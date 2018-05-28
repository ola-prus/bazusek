package bazusek.ui.controllers;

import bazusek.ui.models.StudentModel;

import javax.swing.*;

/**
 * Created by Ola on 2018-05-26.
 */
public class AddStudentController {
    private StudentModel model;
    private AddStudentView view;

    public AddStudentController(StudentModel m, AddStudentView v) {
        model = m;
        view = v;
        initView();
    }

    public void initView() {
        view.getFirstnameTextfield().setText(model.getFirstname());
        view.getLastnameTextfield().setText(model.getLastname());
    }

    public void initController() {
        view.getSaveButton().addActionListener(e -> saveFirstname());
        }

    private void saveFirstname() {
        model.setFirstname(view.getFirstnameTextfield().getText());
        JOptionPane.showMessageDialog(null, "Firstname saved : " + model.getFirstname(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }



}
