package ua.lviv.iot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`analysis`",schema = "`hospitallab4db`")
public class Analysis {
    @Id
    @Column(name = "idanalysis",nullable = false)
    private Integer idanalysis;

    @Column(name = "analysis_description",nullable = false)
    private String analysis_description;

    @Column(name = "patient_id_patient",nullable = false)
    private Integer patient_id_patient;

    public Analysis(){};

    public Analysis(Integer idanalysis,String analysis_description,Integer patient_id_patient){
        this.idanalysis = idanalysis;
        this.analysis_description = analysis_description;
        this.patient_id_patient = patient_id_patient;
    }

    public Integer getIdanalysis() {
        return idanalysis;
    }

    public void setIdanalysis(Integer idanalysis) {
        this.idanalysis = idanalysis;
    }

    public String getAnalysis_description() {
        return analysis_description;
    }

    public void setAnalysis_description(String analysis_description) {
        this.analysis_description = analysis_description;
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

        Analysis that = (Analysis) o;
        if(idanalysis != null ? !idanalysis.equals(that.idanalysis) : that.idanalysis != null) return false;
        if(analysis_description != null ? !analysis_description.equals(that.analysis_description) : that.analysis_description != null) return false;
        if(patient_id_patient != null ? !patient_id_patient.equals(that.patient_id_patient) :that.patient_id_patient != null) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result = idanalysis != null ? idanalysis.hashCode() : 0;
        result = 31 * result + (analysis_description != null ? analysis_description.hashCode() :0);
        result = 31 * result + (patient_id_patient != null ? patient_id_patient.hashCode() :0);
        return result;
    }

    @Override
    public String toString(){
        return "Analysis{" + "idanalysis = "  + idanalysis + ","
                + "analysis_description = " + analysis_description + ","
                + "patient_id_patient = " + patient_id_patient  + "}";
    }
}
