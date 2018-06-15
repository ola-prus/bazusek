package bazusek.dao.impl;

import bazusek.dao.TeacherAssignmentDao;
import bazusek.models.Subject;
import bazusek.models.TeacherAssignment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-06-09.
 */
public class TeacherAssignmentDaoImpl implements TeacherAssignmentDao {

    private static final Logger logger = Logger.getLogger(TeacherAssignmentDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public List<TeacherAssignment> teacherAssignmentList(){
        return getSession().createCriteria(TeacherAssignment.class).list();
    }

    @Transactional
    public TeacherAssignment save(TeacherAssignment teacherAssignment) {
        getSession().save(teacherAssignment);
        logger.info("nauczyciel + przedmiot zapisany");
        return teacherAssignment;
    }

    @Transactional
    public Subject showSubjectAssignment(int id ){
        Subject subject=getSession().load(Subject.class,id);
        logger.info("student wybrany : "+ subject);
        return subject;

    }

}
