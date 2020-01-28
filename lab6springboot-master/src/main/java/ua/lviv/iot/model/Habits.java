package ua.lviv.iot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`habits`",schema = "`hospitallab4db`")
public class Habits {

    @Id
    @Column(name = "idhabits",nullable = false)
    private Integer idhabits;

    @Column(name = "habits",nullable = false)
    private String habits;

    public Habits(){};

    public Habits(Integer idhabits, String habits){
        this.idhabits = idhabits;
        this.habits = habits;
    }

    public Integer getIdhabits() {
        return idhabits;
    }

    public void setIdhabits(Integer idhabits) {
        this.idhabits = idhabits;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Habits that = (Habits) o;
        if(idhabits != null ? !idhabits.equals(that.idhabits) : that.idhabits != null) return false;
        if(habits != null ? !habits.equals(that.habits) : that.habits != null) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result = idhabits != null ? idhabits.hashCode() : 0;
        result = 31 * result + (habits != null ? habits.hashCode() :0);
        return result;
    }

    @Override
    public String toString(){
        return "Habits{" + "idhabits = "  + idhabits + ","
                + "habits = " + habits + "}";
    }
}
