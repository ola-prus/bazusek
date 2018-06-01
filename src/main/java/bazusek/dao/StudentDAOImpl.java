package bazusek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import bazusek.models.Student;
import org.hibernate.*;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
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

	public Student getById(int id) {

		return (Student) getSession().load(Student.class, id);

	}

	public Student delete( int id) {

		Student student=(Student)getSession().load(Student.class, id);
		System.out.println("student wybrany w sesji");
		getSession().delete(student);
		System.out.println("usuniety z bazy");
		return student;
	}


	public void updateStudent(int id, List<String>attr) {

		Student sd=getSession().load(Student.class,id);
		System.out.println("student zaladowany z sesji");
		sd.setFirst_name(attr.get(0));
		sd.setSecond_name(attr.get(1));
		sd.setLast_name(attr.get(2));
		sd.setMother_name(attr.get(3));
		sd.setFather_name(attr.get(4));
		sd.setPhone(attr.get(5));
		System.out.println("zmienione dane studenta");
		getSession().update(sd);
	}

}
