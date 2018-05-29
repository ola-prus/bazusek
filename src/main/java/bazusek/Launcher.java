package bazusek;

import bazusek.config.AppConfig;
import bazusek.config.DbConfig;
import bazusek.dao.MarksDAO;
import bazusek.models.Marks;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Ola on 2018-05-28.
 */
public class Launcher {
    public void launch(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DbConfig.class, AppConfig.class);
        System.out.println("annotation start dla db");

    }
}
