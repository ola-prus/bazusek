package bazusek.config;

import bazusek.dao.*;
import bazusek.repository.StudentRepository;
import bazusek.ui.views.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by Ola on 2018-05-28.
 */
@Configuration
@ComponentScan("bazusek.dao.*")
public class AppConfig {

    @Bean
    public MainFrame mainFrame() {
        return new MainFrame();
    }

    @Bean
    public StudentDAO studentDAO() {
        return new StudentDAOImpl();
    }

    @Bean
    public MarksDAO marksDAO(){return new MarksDAOImpl();}

    @Bean
    public SubjectsDAO subjectsDAO(){return new SubjectsDAOImpl();}

    @PostConstruct
    public void initialize() {
        mainFrame().init(); // uruchomeinei swinga
    }
}
