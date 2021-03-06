package bazusek.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ola on 2018-06-09.
 */
@Entity
@Table(name = "marksDisplay")
public class MarksDisplay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="idStudent")
    public Student student;

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="idSubject")
    public Subject subject;

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="idMark")
    public Mark mark;

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="idTeacherAssignment")
    public TeacherAssignment teacherAssignment;

    @Column
    private String year;

    public MarksDisplay(){}

    public MarksDisplay( Student student, Subject subject, Mark mark, TeacherAssignment teacherAssignment, String year) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
        this.teacherAssignment = teacherAssignment;
        this.year=year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public TeacherAssignment getTeacherAssignment() {
        return teacherAssignment;
    }

    public void setTeacherAssignment(TeacherAssignment teacherAssignment) {
        this.teacherAssignment = teacherAssignment;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MarksDisplay{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", mark=" + mark +
                ", teacherAssignment=" + teacherAssignment +
                ", rok=" + year +
                '}';
    }
}
