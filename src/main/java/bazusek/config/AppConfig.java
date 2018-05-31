package bazusek.config;

import bazusek.ui.views.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by Ola on 2018-05-28.
 */
@Configuration
@ComponentScan("bazusek.todo.ui.*")
public class AppConfig {

    @Bean
    MainFrame mainFrame(){return new MainFrame();}

    @Bean
    public StudentListPanel studentSpherePanel() {
        return new StudentListPanel();
    }

    @Bean
    public StudentMarksPanel studentMarksPanel() {return new StudentMarksPanel();}

    @Bean
    StudentDataEditPanel studentDataEditPanel(){return new StudentDataEditPanel();}

    @Bean
    TeacherListPanel teacherListPanel(){return new TeacherListPanel();}

    @Bean
    TeacherDataEditPanel teacherDataEditPanel(){return new TeacherDataEditPanel();}

    @Bean
    SubjectsPanel subjectsPanel(){return new SubjectsPanel();}

    @PostConstruct
    public void initialize() {mainFrame().init();}
}
