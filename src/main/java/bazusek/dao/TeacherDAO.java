package bazusek.dao;

import bazusek.models.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ola on 2018-06-01.
 */
@Repository
public interface TeacherDao {
    public Teacher save(Teacher teacher);
    public List<Teacher> teacherList();
    public Teacher showTeacher(int id );
    public void delete( int id);
}
