package bazusek.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ola on 2018-05-28.
 */
@Entity
@Table(name="mark")
public class Mark implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String markName;

    public Mark(){}

    public Mark(String markName){
        this.markName=markName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    @Override
    public String toString() {
        return "markName{" +
                "id=" + id +
                ", markName='" + markName + '\'' +
                '}';
    }
}
