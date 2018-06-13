package bazusek.dao;

import bazusek.models.Subject;
import bazusek.models.TeacherAssignment;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Ola on 2018-06-09.
 */
@Repository
public interface TeacherAssignmentDAO {
    public TeacherAssignment save(TeacherAssignment teacherAssignment);
    public List<TeacherAssignment> teacherAssignmentList();
    public Subject showSubjectAssignment(int id );
}
