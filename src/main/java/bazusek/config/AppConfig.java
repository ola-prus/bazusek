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
    public StudentListPanel studentListPanel() {
        return new StudentListPanel();
    }

    @Bean
    public StudentMarkEditPanel studentMarksPanel() {return new StudentMarkEditPanel();}

    @Bean
    StudentDataEditPanel studentDataEditPanel(){return new StudentDataEditPanel();}

    @Bean
    TeacherListPanel teacherListPanel(){return new TeacherListPanel();}

    @Bean
    TeacherDataEditPanel teacherDataEditPanel(){return new TeacherDataEditPanel();}

    @Bean
    SubjectTeacherEditPanel subjectsPanel(){return new SubjectTeacherEditPanel();}

    @Bean
    StudentAddressEditPanel studentHomeAddressEditPanel(){return new StudentAddressEditPanel();}

    @PostConstruct
    public void initialize() {
        mainFrame().init();
    }
}
