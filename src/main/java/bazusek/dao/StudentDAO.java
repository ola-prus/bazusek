package bazusek.dao;

import bazusek.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ola on 2018-05-28.
 */

@Repository
public interface StudentDAO { //component: repository, service na interface , wtedy bedzie dzialac autowired
    public void save(Student student);
    public List<Student> studentList();

}
