package bazusek.dao;

import bazusek.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ola on 2018-05-28.
 */

@Repository
public interface StudentDao {
    public Student save(Student student);
    public List<Student>studentList();
    public Student showStudent(int id );
    public void delete( int id);
}
