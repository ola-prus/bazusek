package bazusek.dao.impl;

import bazusek.dao.MarkDao;
import bazusek.models.Mark;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-05-29.
 */
public class MarkDaoImpl implements MarkDao {

    private static final Logger logger = Logger.getLogger(MarkDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public List<Mark> marksList(){
        return getSession().createCriteria(Mark.class).list();
    }


    @Transactional
    public Mark save(Mark mark) {
        getSession().save(mark);
        logger.info("ocena zapisana");
        return mark;
    }
}