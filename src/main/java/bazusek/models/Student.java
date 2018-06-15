package bazusek.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idStudent")
    private int idStudent;        //http://e-mu.eu/adm


    @Column
    private String sFirstName;

    @Column
    private String sSecondName;

    @Column
    private String sLastName;

    @Column
    private String sPesel;

    @Column
    private String sMotherName;
    @Column
    private String sFatherName;
    @Column
    private String sPhone;

    public Student() {
    }


    public Student(String sFirstName, String sSecondName, String sLastName, String sPesel, String sMotherName,
                   String sFatherName, String sPhone) {
        this.sFirstName = sFirstName;
        this.sSecondName = sSecondName;
        this.sLastName = sLastName;
        this.sPesel = sPesel;
        this.sMotherName = sMotherName;
        this.sFatherName = sFatherName;
        this.sPhone = sPhone;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getsFirstName() {
        return sFirstName;
    }

    public void setsFirstName(String sFirstName) {
        this.sFirstName = sFirstName;
    }

    public String getsSecondName() {
        return sSecondName;
    }

    public void setsSecondName(String sSecondName) {
        this.sSecondName = sSecondName;
    }

    public String getsLastName() {
        return sLastName;
    }

    public void setsLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public String getsPesel() {
        return sPesel;
    }

    public void setsPesel(String sPesel) {
        this.sPesel = sPesel;
    }

    public String getsMotherName() {
        return sMotherName;
    }

    public void setsMotherName(String sMotherName) {
        this.sMotherName = sMotherName;
    }

    public String getsFatherName() {
        return sFatherName;
    }

    public void setsFatherName(String sFatherName) {
        this.sFatherName = sFatherName;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    @Override
    public String toString() {
        return " idStudent: " + idStudent + " imie: " + sFirstName + " drugie imie:" + sSecondName + " nazwisko: "
                + sLastName + " sPesel: " + sPesel + " imie matki: " + sMotherName + " imie ojca: " + sFatherName + " telefon: " + sPhone;
    }
}
