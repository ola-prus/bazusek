package bazusek.daoImpl;

import bazusek.dao.MarkDAO;
import bazusek.models.Mark;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ola on 2018-05-29.
 */
public class MarkDAOImpl implements MarkDAO {

    List<Mark> list;

    public void setList(List<Mark> list) {
        this.list = list;
    }

    public List<Mark> getList() {
        return list;
    }

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
        System.out.println("ocena zapisana");
        return mark;
    }
}