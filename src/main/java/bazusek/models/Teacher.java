package bazusek.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ola on 2018-06-01.
 */
@Entity
@Table(name="teacher")
public class Teacher implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTeacher;


    @Column
    private String tFirstName;

    @Column
    private String tSecondName;

    @Column
    private String tLastName;

    @Column
    private String tPesel;

    @Column
    private String tMotherName;

    @Column
    private String tFatherName;

    @Column
    private String tPhone;

    public Teacher() {
    }


    public Teacher(String tFirstName, String tSecondName, String tLastName, String tPesel, String tMotherName,
                   String tFatherName, String tPhone) {
        this.tFirstName = tFirstName;
        this.tSecondName = tSecondName;
        this.tLastName = tLastName;
        this.tPesel = tPesel;
        this.tMotherName = tMotherName;
        this.tFatherName = tFatherName;
        this.tPhone = tPhone;
    }


    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String gettFirstName() {
        return tFirstName;
    }

    public void settFirstName(String tFirstName) {
        this.tFirstName = tFirstName;
    }

    public String gettSecondName() {
        return tSecondName;
    }

    public void settSecondName(String tSecondName) {
        this.tSecondName = tSecondName;
    }

    public String gettLastName() {
        return tLastName;
    }

    public void settLastName(String tLastName) {
        this.tLastName = tLastName;
    }

    public String gettPesel() {
        return tPesel;
    }

    public void settPesel(String tPesel) {
        this.tPesel = tPesel;
    }

    public String gettMotherName() {
        return tMotherName;
    }

    public void settMotherName(String tMotherName) {
        this.tMotherName = tMotherName;
    }

    public String gettFatherName() {
        return tFatherName;
    }

    public void settFatherName(String tFatherName) {
        this.tFatherName = tFatherName;
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    @Override
    public String toString() {
        return " idTeacher: " + idTeacher + " imie: " + tFirstName + " drugie imie:" + tSecondName + " nazwisko: "
                + tLastName + " tPesel: " + tPesel + " imie matki: " + tMotherName + " imie ojca: " + tFatherName + " telefon: " + tPhone;
    }
}