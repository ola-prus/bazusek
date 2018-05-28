package bazusek.dao;

import java.util.List;

import javax.transaction.Transactional;

import bazusek.models.Student;
import org.hibernate.*;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
public class StudentDAO {

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

	public List<String> studentList() {
		Criteria criteria = getSession().createCriteria(Student.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("id_student"));
		projList.add(Projections.property("first_name"));
		projList.add(Projections.property("second_name"));
		projList.add(Projections.property("last_name"));
		projList.add(Projections.property("pesel"));
		projList.add(Projections.property("mother_name"));
		projList.add(Projections.property("father_name"));
		projList.add(Projections.property("phone"));
		criteria.setProjection(projList);
		list=criteria.list();
		System.out.println("student w criteria dodany");

		return list;
	}

	@Transactional
	public void save(Student student) {
		System.out.println("jest sesja");
		System.out.println("student wybrany w sesji");
		getSession().save(student);
		System.out.println("student zapisany");
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
