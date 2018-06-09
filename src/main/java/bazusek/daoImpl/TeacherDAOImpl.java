package bazusek.daoImpl;

import bazusek.dao.TeacherDAO;
import bazusek.models.Student;
import bazusek.models.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ola on 2018-06-01.
 */
public class TeacherDAOImpl implements TeacherDAO {

    List list;

    public void setList(List list) {
        this.list = list;
    }

    public List getList() {
        return list;
    }

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public List<Teacher> teacherList(){
        return getSession().createCriteria(Teacher.class).list();
    }

    @Transactional
    public Teacher save(Teacher teacher) {
        getSession().save(teacher);
        System.out.println("nauczyciel zapisany");
        return teacher;
    }

    @Transactional
    public Teacher showTeacher(int id ){
        Teacher teacher=getSession().load(Teacher.class,id);
        System.out.println("nauczyciel wybrany");
        System.out.println(teacher);
        return teacher;

    }
    @Transactional
    public void delete( int id) {
        Teacher teacher=getSession().load(Teacher.class,id);
        System.out.println("nauczyciel wybrany");
        getSession().delete(teacher);
        System.out.println("nauczyciel usunięty");
    }
}
