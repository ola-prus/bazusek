package bazusek.models;

import javax.persistence.*;

/**
 * Created by Ola on 2018-06-01.
 */

    @Entity
    @Table(name = "Student_postal_address")
    public class StudentPostalAddress {                          //tylko model jest, join table klucz obcy?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String student_id;

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

    public StudentPostalAddress() {
    }

    public StudentPostalAddress(String student_id, String street, String building_nr, String city, String postal_code, String country) {
        this.student_id = student_id;
        this.street = street;
        this.building_nr = building_nr;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
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

    @Override
    public String toString() {
        return "StudentPostalAddress{" +
                "id=" + id +
                ", student_id='" + student_id + '\'' +
                ", street='" + street + '\'' +
                ", building_nr='" + building_nr + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
