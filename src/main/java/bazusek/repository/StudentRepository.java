package bazusek.repository;

import bazusek.models.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ola on 2018-05-25.
 */
@Repository
@Transactional(readOnly = true)
public interface StudentRepository extends JpaRepository<Student, Long> {


}
