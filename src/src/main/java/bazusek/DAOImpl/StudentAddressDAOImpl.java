package bazusek.DAOImpl;

import bazusek.dao.StudentAddressDAO;
import bazusek.models.StudentAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ola on 2018-06-05.
 */
public class StudentAddressDAOImpl implements StudentAddressDAO {

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
    public StudentAddress save(StudentAddress studentAddress) {
        getSession().save(studentAddress);
        System.out.println("adres zapisany");
        return studentAddress;
    }

    @Transactional
    public StudentAddress showAddress(int id ){
        StudentAddress studentAddress=getSession().load(StudentAddress.class,id);
        System.out.println("student wybrany");
        System.out.println(studentAddress);
        return studentAddress;

    }
}
