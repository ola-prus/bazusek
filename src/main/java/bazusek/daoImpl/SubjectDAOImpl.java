package bazusek.daoImpl;

import bazusek.dao.SubjectDAO;
import bazusek.models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ola on 2018-05-29.
 */
public class SubjectDAOImpl implements SubjectDAO {

    List<Subject> list;

    public void setList(List<Subject> list) {
        this.list = list;
    }

    public List<Subject> getList() {
        return list;
    }

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
        System.out.println("przedmiot zapisany");
        return subject;
    }
}