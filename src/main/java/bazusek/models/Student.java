package bazusek.models;


import javax.persistence.*;

@Entity
@Table(name="Students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_student;


    @Column
    private String first_name;

    @Column
    private String second_name;

    @Column
    private String last_name;

    @Column
    private String pesel;

    @Column
    private String mother_name;
    @Column
    private String father_name;
    @Column
    private String phone;

    public Student(){}


    public Student(String first_name, String second_name, String last_name, String pesel, String mother_name, String father_name, String phone) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.pesel = pesel;
        this.mother_name = mother_name;
        this.father_name = father_name;
        this.phone = phone;
    }


    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "id: "+getId_student();
    }
}
