package bazusek.models;

import javax.persistence.*;

/**
 * Created by Ola on 2018-06-09.
 */
@Entity
@Table(name = "teacher_assignment")
public class TeacherAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_subject")
    public Subject subject;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_teacher")
    public Teacher teacher;

    public TeacherAssignment(){}

    public TeacherAssignment(Subject subject, Teacher teacher) {
        this.subject = subject;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "TeacherAssignment{" +
                "id=" + id +
                ", subject=" + subject.getSubject() +
                ", teacher=" + teacher.getFirst_name() + " "+teacher.getLast_name()+
                '}';
    }
}