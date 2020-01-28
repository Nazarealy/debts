package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "`diagnosis`",schema = "`hospitallab4db`")
public class Diagnosis {

    @Id
    @Column(name = "iddiagnosis",nullable = false)
    private Integer iddiagnosis;

    @Column(name = "description_diagnosis",nullable = false)
    private String description_diagnosis;

    @Column(name = "patient_id_patient",nullable = false)
    private Integer patient_id_patient;

    @Column(name = "data_diagnosis",nullable = false)
    private Date data_diagnosis;

    public Diagnosis(){};

    public Diagnosis(Integer iddiagnosis,String description_diagnosis,Integer patient_id_patient,Date data_diagnosis){
        this.iddiagnosis = iddiagnosis;
        this.description_diagnosis = description_diagnosis;
        this.patient_id_patient = patient_id_patient;
        this.data_diagnosis = data_diagnosis;
    }

    public Integer getIddiagnosis() {
        return iddiagnosis;
    }

    public void setIddiagnosis(Integer iddiagnosis) {
        this.iddiagnosis = iddiagnosis;
    }

    public String getDescription_diagnosis() {
        return description_diagnosis;
    }

    public void setDescription_diagnosis(String description_diagnosis) {
        this.description_diagnosis = description_diagnosis;
    }

    public Integer getPatient_id_patient() {
        return patient_id_patient;
    }

    public void setPatient_id_patient(Integer patient_id_patient) {
        this.patient_id_patient = patient_id_patient;
    }

    public Date getData_diagnosis() {
        return data_diagnosis;
    }

    public void setData_diagnosis(Date data_diagnosis) {
        this.data_diagnosis = data_diagnosis;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Diagnosis that = (Diagnosis) o;
        if(iddiagnosis != null ? !iddiagnosis.equals(that.iddiagnosis) : that.iddiagnosis != null) return false;
        if(description_diagnosis != null ? !description_diagnosis.equals(that.description_diagnosis) : that.description_diagnosis != null) return false;
        if(patient_id_patient != null ? !patient_id_patient.equals(that.patient_id_patient) :that.patient_id_patient != null) return false;
        if(data_diagnosis != null ? !data_diagnosis.equals(that.data_diagnosis) : that.data_diagnosis != null) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result = iddiagnosis != null ? iddiagnosis.hashCode() : 0;
        result = 31 * result + (description_diagnosis != null ? description_diagnosis.hashCode() :0);
        result = 31 * result + (patient_id_patient != null ? patient_id_patient.hashCode() :0);
        result = 31 * result + (data_diagnosis != null ? data_diagnosis.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return "Diagnosis{" + "iddiagnosis = "  + iddiagnosis + ","
                + "description_diagnosis = " + description_diagnosis + ","
                + "patient_id_patient = " + patient_id_patient  + ","
                + "data_diagnosis = " + data_diagnosis + "}";
    }
}
