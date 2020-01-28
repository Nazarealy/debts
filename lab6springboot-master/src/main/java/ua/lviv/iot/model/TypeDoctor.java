package ua.lviv.iot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`type_doctor`",schema = "`hospitallab4db`")
public class TypeDoctor {

    @Id
    @Column(name = "idtype_doctor",nullable = false)
    private Integer idtype_doctor;

    @Column(name = "type_doctor",nullable = false)
    private String type_doctor;

    public TypeDoctor(){};

    public TypeDoctor(Integer idtype_doctor,String type_doctor){
        this.idtype_doctor = idtype_doctor;
        this.type_doctor = type_doctor;
    }

    public Integer getIdtype_doctor() {
        return idtype_doctor;
    }

    public void setIdtype_doctor(Integer idtype_doctor) {
        this.idtype_doctor = idtype_doctor;
    }

    public String getType_doctor() {
        return type_doctor;
    }

    public void setType_doctor(String type_doctor) {
        this.type_doctor = type_doctor;
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        TypeDoctor that = (TypeDoctor) o;
        if(idtype_doctor != null ? !idtype_doctor.equals(that.idtype_doctor) : that.idtype_doctor != null) return false;
        if(type_doctor != null ? !type_doctor.equals(that.type_doctor) : that.type_doctor != null) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result = idtype_doctor != null ? idtype_doctor.hashCode() : 0;
        result = 31 * result + (idtype_doctor != null ? idtype_doctor.hashCode() :0);
        result = 31 * result + (type_doctor != null ? type_doctor.hashCode() :0);
        return result;
    }

    @Override
    public String toString(){
        return "TypeDoctor{" + "idtype_doctor = "  + idtype_doctor + ","
                + "type_doctor = " + type_doctor + "}";
    }
}
