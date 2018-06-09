package bazusek.models;

import javax.persistence.*;

/**
 * Created by Ola on 2018-05-28.
 */

@Entity
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_subject;


    @Column
    private String subject;

    public Subject(){}

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Subject(String subject){
        this.subject=subject;

    }

    @Override
    public String toString() {
        return "subject{" +
                "id_subject=" + id_subject +
                ", subject='" + subject + '\'' +
                '}';
    }
}
