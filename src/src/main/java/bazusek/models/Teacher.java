package bazusek.models;

import javax.persistence.*;

/**
 * Created by Ola on 2018-06-01.
 */
@Entity
@Table(name="teacher")
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTeacher;


    @Column
    private String firstName;

    @Column
    private String secondName;

    @Column
    private String lastName;

    @Column
    private String pesel;

    @Column
    private String motherName;

    @Column
    private String fatherName;

    @Column
    private String phone;

    public Teacher() {
    }


    public Teacher(String firstName, String secondName, String lastName, String pesel, String motherName,
                   String fatherName, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.phone = phone;
    }


    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return " idTeacher: " + idTeacher + " imie: " + firstName + " drugie imie:" + secondName + " nazwisko: "
                + lastName + " pesel: " + pesel + " imie matki: " + motherName + " imie ojca: " + fatherName + " telefon: " + phone;
    }
}