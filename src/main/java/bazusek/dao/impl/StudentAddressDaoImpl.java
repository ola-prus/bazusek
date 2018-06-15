package bazusek.dao.impl;

import bazusek.dao.StudentAddressDao;
import bazusek.models.StudentAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.logging.Logger;

/**
 * Created by Ola on 2018-06-05.
 */
public class StudentAddressDaoImpl implements StudentAddressDao {

    private static final Logger logger = Logger.getLogger(StudentAddressDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public StudentAddress save(StudentAddress studentAddress) {
        getSession().save(studentAddress);
       logger.info("adres zapisany");
        return studentAddress;
    }

    @Transactional
    public StudentAddress showAddress(int id ){
        StudentAddress studentAddress=getSession().load(StudentAddress.class,id);
        logger.info("student wybrany : "+studentAddress);
        return studentAddress;

    }
}
