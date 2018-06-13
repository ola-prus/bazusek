package bazusek.DAOImpl;

import bazusek.dao.TeacherAssignmentDAO;
import bazusek.models.Subject;
import bazusek.models.TeacherAssignment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ola on 2018-06-09.
 */
public class TeacherAssignmentDAOImpl implements TeacherAssignmentDAO {

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
    public List<TeacherAssignment> teacherAssignmentList(){
        return getSession().createCriteria(TeacherAssignment.class).list();
    }

    @Transactional
    public TeacherAssignment save(TeacherAssignment teacherAssignment) {
        getSession().save(teacherAssignment);
        System.out.println("nauczyciel + przedmiot zapisany");
        return teacherAssignment;
    }

    @Transactional
    public Subject showSubjectAssignment(int id ){
        Subject subject=getSession().load(Subject.class,id);
        System.out.println("student wybrany");
        System.out.println(subject);
        return subject;

    }

}
