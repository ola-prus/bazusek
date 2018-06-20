package bazusek.dao.impl;

import bazusek.dao.TeacherDao;
import bazusek.models.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-06-01.
 */
public class TeacherDaoImpl implements TeacherDao {

    private static final Logger logger = Logger.getLogger(TeacherDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public List<Teacher> teacherList(){
        return getSession().createQuery("from Teacher").list();
    }

    @Transactional
    public Teacher save(Teacher teacher) {
        getSession().save(teacher);
        logger.info("nauczyciel zapisany");
        return teacher;
    }

    @Transactional
    public Teacher showTeacher(int id ){
        Teacher teacher=getSession().load(Teacher.class,id);
        logger.info("nauczyciel wybrany : "+teacher);
        return teacher;

    }
    @Transactional
    public void delete( int id) {
        Teacher teacher=getSession().load(Teacher.class,id);
       logger.info("nauczyciel wybrany");
        getSession().delete(teacher);
        logger.info("nauczyciel usunięty");
    }
}
