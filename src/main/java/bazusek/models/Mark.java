package bazusek.models;

import javax.persistence.*;

/**
 * Created by Ola on 2018-05-28.
 */
@Entity
@Table(name="mark")
public class Mark { //stala ilosc i rodzaj ocen

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String mark;

    public Mark(){}

    public Mark(String mark){
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

    @Override
    public String toString() {
        return "mark{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                '}';
    }
}
