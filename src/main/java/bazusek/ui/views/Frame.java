package bazusek.ui.views;

import org.springframework.stereotype.Repository;

import javax.swing.*;

/**
 * Created by Ola on 2018-05-30.
 */
@Repository
public interface Frame{

    public void init();
    public void add(JPanel panel);
}
