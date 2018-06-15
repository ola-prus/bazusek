package bazusek.dao;

import bazusek.models.StudentAddress;
import org.springframework.stereotype.Repository;

/**
 * Created by Ola on 2018-06-05.
 */
@Repository
public interface StudentAddressDao {
    public StudentAddress save(StudentAddress studentAddress);
    public StudentAddress showAddress(int id );
}
