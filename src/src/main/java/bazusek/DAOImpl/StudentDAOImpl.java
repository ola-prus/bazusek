package bazusek.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import bazusek.dao.StudentDAO;
import bazusek.models.Student;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentDAOImpl implements StudentDAO {

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
	public List<Student> studentList(){
		return getSession().createCriteria(Student.class).list();
	}

	@Transactional
	public Student save(Student student) {
		getSession().save(student);
		System.out.println("student zapisany");
		return student;
	}

	@Transactional
	public void delete( int id) {
		Student student=getSession().load(Student.class, id);
		System.out.println("student wybrany");
		getSession().delete(student);
		System.out.println("student usunięty");
	}


	@Transactional
	public Student showStudent(int id ){
		Student student=getSession().load(Student.class,id);
		System.out.println("student wybrany");
		System.out.println(student);
		return student;

	}

}
