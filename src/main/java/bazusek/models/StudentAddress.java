package bazusek.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Ola on 2018-06-01.
 */
@Entity
@Table(name = "student_address")
public class StudentAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="id_student")
    public Student student;

    @Column
    private String street;

    @Column
    private String building_nr;

    @Column
    private String city;

    @Column
    private String postal_code;

    @Column
    private String country;

    @Column
    private String type;


    public StudentAddress() {
    }

    public StudentAddress(String street, String building_nr, String city,
                          String postal_code, String country, Student student, String type) {

        this.street = street;
        this.building_nr = building_nr;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
        this.student=student;
        this.type=type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding_nr() {
        return building_nr;
    }

    public void setBuilding_nr(String building_nr) {
        this.building_nr = building_nr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    @Override
    public String toString() {
        return "studentAddress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", building_nr='" + building_nr + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                ", id_student='" + student.getId_student() + '\'' +
                ", typ='" + type + '\'' +
                '}';
    }

}
