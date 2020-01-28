package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "`doctor`",schema = "`hospitallab4db`")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddoctor",nullable = false)
    private Integer iddoctor;

    @Column(name = "type_doctor",nullable = false)
    private Integer type_doctor;

    @Column(name = "full_name",nullable = false)
    private String full_name;

    @Column(name = "time_of_reception",nullable = false)
    private String time_of_reception;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone",nullable = false)
    private Integer phone;

    @Column(name = "experience",nullable = false)
    private Integer experience;

    @Column(name = "license",nullable = false)
    private String license;

    @Column(name = "type_doctor_idtype_doctor",nullable = false)
    private Integer type_doctor_idtype_doctor;

    public Doctor(){};

    public Doctor(Integer iddoctor,Integer type_doctor,String full_name,String time_of_reception,
                  String email,Integer phone, Integer experience,String license,Integer type_doctor_idtype_doctor){
        this.iddoctor = iddoctor;
        this.type_doctor = type_doctor;
        this.full_name = full_name;
        this.time_of_reception = time_of_reception;
        this.email = email;
        this.phone = phone;
        this.experience = experience;
        this.license = license;
        this.type_doctor_idtype_doctor = type_doctor_idtype_doctor;
    }
    public Integer getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public Integer getType_doctor() {
        return type_doctor;
    }

    public void setType_doctor(Integer type_doctor) {
        this.type_doctor = type_doctor;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getTime_of_reception() {
        return time_of_reception;
    }

    public void setTime_of_reception(String time_of_reception) {
        this.time_of_reception = time_of_reception;
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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getType_doctor_idtype_doctor() {
        return type_doctor_idtype_doctor;
    }

    public void setType_doctor_idtype_doctor(Integer type_doctor_idtype_doctor) {
        this.type_doctor_idtype_doctor = type_doctor_idtype_doctor;
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Doctor that = (Doctor) o;
        if(iddoctor != null ? !iddoctor.equals(that.iddoctor) : that.iddoctor != null) return false;
        if(type_doctor != null ? !type_doctor.equals(that.type_doctor) : that.type_doctor != null) return false;
        if(full_name != null ? !full_name.equals(that.full_name) :that.full_name != null) return false;
        if(time_of_reception != null ? !time_of_reception.equals(that.time_of_reception) :that.time_of_reception != null) return false;
        if(email != null ? !email.equals(that.email) :that.email != null) return false;
        if(phone != null ? !phone.equals(that.phone) :that.phone != null) return false;
        if(experience != null ? !experience.equals(that.experience) :that.experience != null) return false;
        if(license != null ? !license.equals(that.license) :that.license != null) return false;
        if(type_doctor_idtype_doctor != null ? !type_doctor_idtype_doctor.equals(that.type_doctor_idtype_doctor) :that.type_doctor_idtype_doctor != null) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result = iddoctor != null ? iddoctor.hashCode() : 0;
        result = 31 * result + (type_doctor != null ? type_doctor.hashCode() :0);
        result = 31 * result + (full_name != null ? full_name.hashCode() :0);
        result = 31 * result + (time_of_reception != null ? time_of_reception.hashCode() :0);
        result = 31 * result + (email != null ? email.hashCode() :0);
        result = 31 * result + (phone != null ? phone.hashCode() :0);
        result = 31 * result + (experience != null ? experience.hashCode() :0);
        result = 31 * result + (license != null ? license.hashCode() :0);
        result = 31 * result + (type_doctor_idtype_doctor != null ? type_doctor_idtype_doctor.hashCode() :0);
        return result;
    }

    @Override
    public String toString(){
        return "Doctor{" + "iddoctor = "  + iddoctor + ","
                + "type_doctor = " + type_doctor + ","
                + "full_name = " + full_name  +
                "time_of_reception = " + time_of_reception + "," +
                "email = " + email + "," +
                "phone = " + phone + "," +
                "experience = " + experience + "," +
                "license = " + license + "," +
                "type_doctor_idtype_doctor = " + type_doctor_idtype_doctor + "}";
    }
}
