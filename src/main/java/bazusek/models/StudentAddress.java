package bazusek.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ola on 2018-06-01.
 */
@Entity
@Table(name = "studentAddress")
public class StudentAddress implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="idStudent")
    public Student student;

    @Column
    private String street;

    @Column
    private String buildingNr;

    @Column
    private String city;

    @Column
    private String postalCode;

    @Column
    private String country;

    @Column
    private String type;


    public StudentAddress() {
    }

    public StudentAddress(String street, String buildingNr, String city,
                          String postalCode, String country, Student student, String type) {

        this.street = street;
        this.buildingNr = buildingNr;
        this.city = city;
        this.postalCode = postalCode;
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

    public String getBuildingNr() {
        return buildingNr;
    }

    public void setBuildingNr(String buildingNr) {
        this.buildingNr = buildingNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
                ", buildingNr='" + buildingNr + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", idStudent='" + student.getIdStudent() + '\'' +
                ", typ='" + type + '\'' +
                '}';
    }

}
