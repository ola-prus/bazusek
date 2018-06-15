package bazusek.dao;

import bazusek.models.Mark;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ola on 2018-05-29.
 */
@Repository
public interface MarkDao {
    public Mark save(Mark mark);
    public List<Mark> marksList();

}
