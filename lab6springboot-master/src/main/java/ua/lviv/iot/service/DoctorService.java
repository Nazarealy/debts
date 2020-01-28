package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Doctor;
import ua.lviv.iot.repository.DoctorRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> findAll() throws Exception{
        List<Doctor> doctor = new LinkedList<>(doctorRepository.findAll());
        if(doctor.isEmpty()){
            return null;
        }
        return doctor;
    }

    public Doctor findById(Integer id) throws Exception{
        if(doctorRepository.findById(id).isPresent()){
            return doctorRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Doctor entity) throws Exception{
        if(entity != null){
            doctorRepository.save(entity);
        }
    }

    @Transactional
    public void update(Doctor entity) throws Exception{
        doctorRepository.findById(entity.getIddoctor()).map(oldEntity ->{
            oldEntity.setType_doctor(entity.getType_doctor());
            oldEntity.setFull_name(entity.getFull_name());
            oldEntity.setTime_of_reception(entity.getTime_of_reception());
            oldEntity.setEmail(entity.getEmail());
            oldEntity.setPhone(entity.getPhone());
            oldEntity.setExperience(entity.getExperience());
            oldEntity.setLicense(entity.getLicense());
            oldEntity.setType_doctor_idtype_doctor(entity.getType_doctor_idtype_doctor());
            return doctorRepository.save(oldEntity);
        })
                .orElseGet(()-> doctorRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception{
        if(doctorRepository.findById(id).isPresent()){
            doctorRepository.deleteById(id);
        }
    }

}
