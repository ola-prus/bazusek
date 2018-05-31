package bazusek.config;

import bazusek.dao.MarksDAO;
import bazusek.dao.MarksDAOImpl;
import bazusek.dao.StudentDAO;
import bazusek.dao.StudentDAOImpl;
import bazusek.ui.views.ListStudentView;
import bazusek.ui.views.MainFrame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by Ola on 2018-05-28.
 */
@Configuration
@ComponentScan("bazusek.dao.*")
public class AppConfig {

    @Bean
    MainFrame mainFrame(){return new MainFrame();}

    @Bean
    public StudentDAO studentDAO() {
        return new StudentDAOImpl();
    }

    @Bean
    public MarksDAO marksDAO(){return new MarksDAOImpl(); }

    @PostConstruct
    public void initialize() {
        mainFrame().init();

    }
}
