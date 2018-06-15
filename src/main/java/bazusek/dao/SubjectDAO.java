package bazusek.dao;

import bazusek.models.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ola on 2018-05-29.
 */
@Repository
public interface SubjectDao {
    public Subject save(Subject subject);
    public List<Subject> subjectList();

}
