package bazusek.dao;

import bazusek.models.StudentAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ola on 2018-06-05.
 */
@Repository
public interface StudentAddressDAO {
    public StudentAddress save(StudentAddress studentAddress);
    public StudentAddress showAddress(int id );
}
