package bazusek.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ola on 2018-05-28.
 */

@Entity
@Table(name="subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubject;


    @Column
    private String subjectName;

    public Subject(){}

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {

        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject(String subjectName){
        this.subjectName=subjectName;

    }

    @Override
    public String toString() {
        return "subjectName{" +
                "idSubject=" + idSubject +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
