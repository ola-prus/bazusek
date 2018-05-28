package bazusek;

import bazusek.ui.controllers.AddStudentController;
import bazusek.ui.models.StudentModel;

import javax.swing.*;

public class Launcher {


	public void launch() {


		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	/*AnnotationConfigApplicationContext context =
	            new AnnotationConfigApplicationContext( DbConfig.class, StudentDAO.class);
		System.out.println("annotation start dla db");



		StudentDAO studentDAO = context.getBean(StudentDAO.class);
		StudentRepository studentRepository = (StudentRepository) context.getBean("studentRepository");
		studentRepository.save(new Student("bolek generyk2", "otoże", "prus", "98478743", "łola", "gregorij", "897897897"));
		System.out.println("zapisany bolek");

		context.close(); */

	   } //zrob cos z launchere. gdzie on nalezy?

	public static void createAndShowGUI() throws Exception {
		//new TodoMainView();
		StudentModel m = new StudentModel("Sylvain", "Saurel");
		AddStudentView v = new AddStudentView("MVC with SSaurel");
		AddStudentController c = new AddStudentController(m, v);
		c.initController();
		System.out.println("uruchamiam swinga");
	}
}


