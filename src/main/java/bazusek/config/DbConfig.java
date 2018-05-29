package bazusek.config;

import bazusek.models.Marks;
import bazusek.models.Student;
import java.util.Properties;

import javax.sql.DataSource;

import bazusek.models.Subjects;
import bazusek.repository.StudentRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.commons.pool.impl.GenericObjectPool;

@Configuration
@ComponentScan("bazusek.models.*")
@EnableTransactionManagement
@EnableJpaRepositories("bazusek.repository")
public class DbConfig {

   private Environment env;

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em
              = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(getDataSource());
      em.setPackagesToScan(new String[] { "bazusek" });

      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(getHibernateProperties());

      return em;
   }

   @Bean(name = "dataSource")
   public DataSource getDataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://212.182.6.126:3306/ola");
      dataSource.setUsername("ola");
      dataSource.setPassword("Ola!ola");

      return dataSource;
   }

   @Autowired
   @Bean(name = "sessionFactory")
   public SessionFactory getSessionFactory(DataSource dataSource) {
      LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
      sessionBuilder.addAnnotatedClasses(Student.class, Subjects.class, Marks.class); //jak bedzie wiecej modeli to tu dodaj
      sessionBuilder.addProperties(getHibernateProperties());
      return sessionBuilder.buildSessionFactory();
   }

   private Properties getHibernateProperties() {
      Properties properties = new Properties();
      properties.put("hibernate.show_sql", "true");
      properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
      //properties.put("hibernate.hbm2ddl.auto", "update");
      return properties;
   }

   @Autowired
   @Bean(name = "transactionManager")
   public HibernateTransactionManager getTransactionManager(
           SessionFactory sessionFactory) {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager(
              sessionFactory);
      return transactionManager;
   }
}
