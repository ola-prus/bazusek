package bazusek.models;

import javax.persistence.*;

/**
 * Created by Ola on 2018-05-28.
 */
@Entity
@Table(name="Marks")
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String mark;

    public Marks(){}

    public Marks (String mark){
        this.mark=mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
