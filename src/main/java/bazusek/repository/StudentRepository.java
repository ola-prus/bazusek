package bazusek.repository;

import bazusek.models.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ola on 2018-05-25.
 */
@Repository
public interface StudentRepository extends CrudRepository <Student, Long> {


}
