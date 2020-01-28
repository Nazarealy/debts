package ua.lviv.iot.model;


import javax.persistence.*;

@Entity
@Table(name = "`patient`",schema = "`hospitallab4db`")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient",nullable = false)
    private Integer id_patient;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Column(name = "work",nullable = false)
    private String work;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone",nullable = false)
    private Integer phone;

    @Column(name = "lifestyle",nullable = false)
    private String lifestyle;

    @Column(name = "bad_habits",nullable = false)
    private Integer bad_habits;

    public Patient(){};

    public Patient(Integer id_patient,String name,Integer age,String work,String email,Integer phone, String lifestyle,Integer bad_habits){
        this.id_patient = id_patient;
        this.name = name;
        this.age = age;
        this.work = work;
        this.email = email;
        this.phone = phone;
        this.lifestyle = lifestyle;
        this.bad_habits = bad_habits;
    }

    public Integer getId_patient() {
        return id_patient;
    }

    public void setId_patient(Integer id_patient) {
        this.id_patient = id_patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public Integer getBad_habits() {
        return bad_habits;
    }

    public void setBad_habits(Integer bad_habits) {
        this.bad_habits = bad_habits;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Patient that = (Patient) o;
        if(id_patient != null ? !id_patient.equals(that.id_patient) : that.id_patient != null) return false;
        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(age != null ? !age.equals(that.age) : that.age != null) return false;
        if(work != null ? !work.equals(that.work) : that.work != null) return false;
        if(email != null ? !email.equals(that.email) : that.email != null) return false;
        if(phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if(lifestyle != null ? !lifestyle.equals(that.lifestyle) : that.lifestyle != null) return false;
        if(bad_habits != null ? !bad_habits.equals(that.bad_habits) : that.bad_habits != null) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result = id_patient != null ? id_patient.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() :0);
        result = 31 * result + (age != null ? age.hashCode() :0);
        result = 31 * result + (work != null ? work.hashCode() :0);
        result = 31 * result + (email != null ? email.hashCode() :0);
        result = 31 * result + (phone != null ? phone.hashCode() :0);
        result = 31 * result + (lifestyle != null ? lifestyle.hashCode() :0);
        result = 31 * result + (bad_habits != null ? bad_habits.hashCode() :0);

        return result;
    }

    @Override
    public String toString(){
        return "Patient{ " + "id_patient = "  + id_patient + ","
                + "name = " + name
                +"age = " + age +
                "work = " + work +
                "email = " + email +
                "phone = " + phone +
                "lifestyle = " + lifestyle +
                "bad_habits = " + bad_habits + "}";
    }
}
