package bazusek.dao.impl;

import bazusek.dao.SubjectDao;
import bazusek.models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-05-29.
 */
public class SubjectDaoImpl implements SubjectDao {

    private static final Logger logger = Logger.getLogger(SubjectDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public List<Subject> subjectList(){
        return getSession().createCriteria(Subject.class).list();
    }

    @Transactional
    public Subject save(Subject subject) {
        getSession().save(subject);
        logger.info("przedmiot zapisany");
        return subject;
    }
}