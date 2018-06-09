package bazusek.config;

import bazusek.dao.*;
import bazusek.daoImpl.*;
import bazusek.models.*;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("bazusek.models.*")
@EnableTransactionManagement
public class DbConfig {



   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean entityManagerFactory
              = new LocalContainerEntityManagerFactoryBean();
      entityManagerFactory.setDataSource(dataSource());
      entityManagerFactory.setPackagesToScan("bazusek.todo.models");

      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

      entityManagerFactory.setJpaProperties(getHibernateProperties());

      return entityManagerFactory;
   }

   @Bean(name = "dataSource")
   public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://212.182.6.126:3306/ola");
      dataSource.setUsername("ola");
      dataSource.setPassword("Ola!ola");

//      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//      dataSource.setUrl("jdbc:mysql://xxxxxxxxxxxxxxx/x");
//      dataSource.setUsername("xxxxx");
//      dataSource.setPassword("xxxxxxxxxx");

      return dataSource;
   }


   @Bean(name = "sessionFactory")
   public SessionFactory getSessionFactory(DataSource dataSource) {
      LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
      sessionBuilder.addAnnotatedClasses(Student.class, Subject.class, Mark.class, Teacher.class, StudentAddress.class, MarksDisplay.class,
              TeacherAssignment.class);
      sessionBuilder.addProperties(getHibernateProperties());
      return sessionBuilder.buildSessionFactory();
   }

   private Properties getHibernateProperties() {
      Properties properties = new Properties();
      properties.put("hibernate.show_sql", "true");
      properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
      properties.put("hibernate.hbm2ddl.auto", "update");
      return properties;
   }


   @Bean(name = "transactionManager")
   public HibernateTransactionManager getTransactionManager(
           SessionFactory sessionFactory) {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager(
              sessionFactory);
      return transactionManager;
   }
   @Bean
   public StudentDAO studentDAO() {
      return new StudentDAOImpl();
   }
   @Bean
   public MarkDAO markDAO(){return new MarkDAOImpl(); }

   @Bean
   public TeacherDAO teacherDAO(){return new TeacherDAOImpl();}

   @Bean
   public SubjectDAO subjectDAO(){return new SubjectDAOImpl();}

   @Bean
   public StudentAddressDAO studentHomeAddressDAO(){return new StudentAddressDAOImpl();}

   @Bean
   public TeacherAssignmentDAO teacherAssignmentDAO(){return new TeacherAssignmentDAOImpl();}
}
