package bazusek.repository;

import bazusek.models.Student;
import bazusek.models.Subjects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ola on 2018-05-28.
 */
@Repository
public interface SubjectsRepository extends CrudRepository<Subjects, Long> {


}

