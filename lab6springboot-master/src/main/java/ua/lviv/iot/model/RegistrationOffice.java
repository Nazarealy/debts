package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "`registration_office`",schema = "`hospitallab4db`")
public class RegistrationOffice {

    @Id
    @Column(name = "id_of_patient",nullable = false)
    private Integer id_of_patient;

    @Column(name = "data",nullable = false)
    private Date data;

    @Column(name = "id_medical_doctor",nullable = false)
    private Integer id_medical_doctor;

    @Column(name = "type_of_treatment",nullable = false)
    private String type_of_treatment;

    @Column(name = "money",nullable = false)
    private Integer money;

    @Column(name = "doctor_iddoctor",nullable = false)
    private Integer doctor_iddoctor;

    @Column(name = "patient_id_patient",nullable = false)
    private Integer patient_id_patient;

    public RegistrationOffice(){};

    public RegistrationOffice(Integer id_of_patient, Date data, Integer id_medical_doctor,
                              String type_of_treatment, Integer money, Integer doctor_iddoctor, Integer patient_id_patient){
        this.id_of_patient = id_of_patient;
        this.data = data;
        this.id_medical_doctor = id_medical_doctor;
        this.type_of_treatment = type_of_treatment;
        this.money = money;
        this.doctor_iddoctor = doctor_iddoctor;
        this.patient_id_patient = patient_id_patient;
    }

    public Integer getId_of_patient() {
        return id_of_patient;
    }

    public void setId_of_patient(Integer id_of_patient) {
        this.id_of_patient = id_of_patient;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId_medical_doctor() {
        return id_medical_doctor;
    }

    public void setId_medical_doctor(Integer id_medical_doctor) {
        this.id_medical_doctor = id_medical_doctor;
    }

    public String getType_of_treatment() {
        return type_of_treatment;
    }

    public void setType_of_treatment(String type_of_treatment) {
        this.type_of_treatment = type_of_treatment;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getDoctor_iddoctor() {
        return doctor_iddoctor;
    }

    public void setDoctor_iddoctor(Integer doctor_iddoctor) {
        this.doctor_iddoctor = doctor_iddoctor;
    }

    public Integer getPatient_id_patient() {
        return patient_id_patient;
    }

    public void setPatient_id_patient(Integer patient_id_patient) {
        this.patient_id_patient = patient_id_patient;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        RegistrationOffice that = (RegistrationOffice) o;
        if(id_of_patient != null ? !id_of_patient.equals(that.id_of_patient) : that.id_of_patient != null) return false;
        if(data != null ? !data.equals(that.data) : that.data!= null) return false;
        if(id_medical_doctor != null ? !id_medical_doctor.equals(that.id_medical_doctor) : that.id_medical_doctor != null) return false;
        if(type_of_treatment != null ? !type_of_treatment.equals(that.type_of_treatment) : that.type_of_treatment != null) return false;
        if(money != null ? !money.equals(that.money) : that.money != null) return false;
        if(doctor_iddoctor != null ? !doctor_iddoctor.equals(that.doctor_iddoctor) : that.doctor_iddoctor != null) return false;
        if(patient_id_patient != null ? !patient_id_patient.equals(that.patient_id_patient) : that.patient_id_patient != null) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result = id_of_patient != null ? id_of_patient.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() :0);
        result = 31 * result + (id_medical_doctor != null ? id_medical_doctor.hashCode() :0);
        result = 31 * result + (type_of_treatment != null ? type_of_treatment.hashCode() :0);
        result = 31 * result + (money != null ? money.hashCode() :0);
        result = 31 * result + (doctor_iddoctor != null ? doctor_iddoctor.hashCode() :0);
        result = 31 * result + (patient_id_patient != null ? patient_id_patient.hashCode() :0);
        return result;
    }

    @Override
    public String toString(){
        return "RegistrationOffice{ " + "id_of_patient = "  + id_of_patient + ","
                + "data = " + data
                +"id_medical_doctor = " + id_medical_doctor +
                "type_of_treatment = " + type_of_treatment +
                "money = " + money +
                "doctor_id_doctor = " + doctor_iddoctor +
                "patient_id_patient = " + patient_id_patient + "}";
    }
}
