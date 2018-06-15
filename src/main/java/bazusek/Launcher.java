package bazusek;

import bazusek.config.AppConfig;
import bazusek.config.DbConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


/**
 * Created by Ola on 2018-05-28.
 */

public class Launcher {

    private static final Logger logger = Logger.getLogger(Launcher.class.getName());

    public void launch() {
        new AnnotationConfigApplicationContext(DbConfig.class, AppConfig.class);
         logger.info("Start aplikacji Spring");

    }


}