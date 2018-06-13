package bazusek.models;


import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idStudent")
    private int idStudent;        //http://e-mu.eu/adm


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

    public Student() {
    }


    public Student(String firstName, String secondName, String lastName, String pesel, String motherName,
                   String fatherName, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.phone = phone;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
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
        return " idStudent: " + idStudent + " imie: " + firstName + " drugie imie:" + secondName + " nazwisko: "
                + lastName + " pesel: " + pesel + " imie matki: " + motherName + " imie ojca: " + fatherName + " telefon: " + phone;
    }
}
