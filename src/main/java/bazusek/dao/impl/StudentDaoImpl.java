package bazusek.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import bazusek.dao.StudentDao;
import bazusek.models.Student;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentDaoImpl implements StudentDao {

	private static final Logger logger = Logger.getLogger(StudentDaoImpl.class.getName());

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public List<Student> studentList(){
		return getSession().createQuery("from Student").list();

	}

	@Transactional
	public Student save(Student student) {
		getSession().save(student);
		logger.info("student zapisany");
		return student;
	}

	@Transactional
	public void delete( int id) {
		Student student=getSession().load(Student.class, id);
		logger.info("student wybrany");
		getSession().delete(student);
		logger.info("student usunięty");
	}


	@Transactional
	public Student showStudent(int id ){
		Student student=getSession().load(Student.class,id);
		logger.info("student wybrany : "+ student);
		return student;

	}

}
