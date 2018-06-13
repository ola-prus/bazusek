package bazusek;

import bazusek.config.AppConfig;
import bazusek.config.DbConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


/**
 * Created by Ola on 2018-05-28.
 */

public class Launcher {
    private final static Logger LOGGER = Logger.getLogger(Launcher.class.getName());

    public void launch() {
        new AnnotationConfigApplicationContext(DbConfig.class, AppConfig.class);
        System.out.println("start");// logger.log("Start aplikacji Spring");

    }


}