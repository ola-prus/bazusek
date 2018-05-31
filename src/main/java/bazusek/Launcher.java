package bazusek;

import bazusek.config.AppConfig;
import bazusek.config.DbConfig;
import bazusek.dao.MarksDAO;
import bazusek.dao.StudentDAO;
import bazusek.models.Marks;
import bazusek.models.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


/**
 * Created by Ola on 2018-05-28.
 */
public class Launcher {
    public void launch() throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DbConfig.class, AppConfig.class);
        System.out.println("annotation start dla db");
        //Student student = new Student("dds", "dg", "sagv", "afeeeee", "ukv", "nv", "bj");
        List<Student> list = context.getBean(StudentDAO.class).studentList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i));


        }
    }
}
