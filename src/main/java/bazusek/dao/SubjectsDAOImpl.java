package bazusek.dao;

import bazusek.models.Marks;
import bazusek.models.Subjects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ola on 2018-05-29.
 */
public class SubjectsDAOImpl implements SubjectsDAO {

    List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();   //ten podzial na dao i daoimpl to zrob bo z nauczycielem bedzie to samo i innymi modelami
    }

    @Transactional
    public void save(Subjects subject) {
        getSession().save(subject);
        System.out.println("przedmiot zapisany");
    }
}