package bazusek;

import bazusek.config.DbConfig;
import bazusek.dao.StudentDAO;
import bazusek.models.Student;
import bazusek.models.Subjects;
import bazusek.repository.StudentRepository;
import bazusek.repository.SubjectsRepository;
import bazusek.ui.views.TodoMainView;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.util.List;

public class Todo {
	public static void main(String[] args) {

                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            try {
                                createAndShowGUI();
                            } catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DbConfig.class, StudentDAO.class);
        System.out.println("annotation start dla db");

       StudentDAO studentDAO = context.getBean(StudentDAO.class);
//       StudentRepository studentRepository = (StudentRepository) context.getBean("studentRepository");
       // SubjectsRepository subjectsRepository= (SubjectsRepository) context.getBean("subjectsRepository");
//        Student returnedAccount = studentRepository.save(new Student("fdssdfbolek generyk2", "otoże", "prus", "98478743", "łola", "gregorij", "897897897"));
//        studentDAO.save(new Student("fdssdfbolek generyk2", "otoże", "prus", "98478743", "łola", "gregorij", "897897897"));
       //System.out.println("zapisany: "+ returnedAccount);
       // Subjects subjects=new Subjects("matma");

//        subjectsRepository.save(subjects);
//        System.out.println(subjects);
//        System.out.println("przedmiot dodany");
        //studentRepository.save(new Student("bolek generyk3", "otoże", "prus", "98478743", "łola", "gregorij", "897897897"));
       /* List<Student> list = (List<Student>) studentRepository.findAll();
        for (Student s : list){
            System.out.println(s.getId_student());
        }*/
        context.close();

    }
     //zrob cos z launchere. gdzie on nalezy?

	public static void createAndShowGUI() throws Exception {
		new TodoMainView();
		//StudentModel m = new StudentModel("Sylvain", "Saurel");
		//AddStudentView v = new AddStudentView("MVC with SSaurel");
		//AddStudentController c = new AddStudentController(m, v);
		//c.initController();
		System.out.println("uruchamiam swinga");
	}
    }




