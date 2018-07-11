package bazusek.config;

import bazusek.views.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import javax.swing.*;

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

    @Bean
    ClockPanel clockPanel(){return new ClockPanel();}

    @Bean
    JSplitPane splitPane(){return new JSplitPane();}

    @PostConstruct
    public void initialize() {
        mainFrame().init();
    }
}
