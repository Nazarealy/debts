package ua.lviv.iot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Patient;
import ua.lviv.iot.repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public List<Patient> findAll() throws Exception{
        List<Patient> patient = new LinkedList<>(patientRepository.findAll());
        if(patient.isEmpty()){
            return null;
        }
        return patient;
    }

    public Patient findById(Integer id) throws Exception{
        if(patientRepository.findById(id).isPresent()){
            return patientRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Patient entity) throws Exception{
        if(entity != null){
            patientRepository.save(entity);
        }
    }

    @Transactional
    public void update(Patient entity) throws Exception{
        patientRepository.findById(entity.getId_patient()).map(oldEntity ->{
            oldEntity.setName(entity.getName());
            oldEntity.setAge(entity.getAge());
            oldEntity.setWork(entity.getWork());
            oldEntity.setEmail(entity.getEmail());
            oldEntity.setPhone(entity.getPhone());
            oldEntity.setLifestyle(entity.getLifestyle());
            oldEntity.setBad_habits(entity.getBad_habits());
            return patientRepository.save(oldEntity);
        })
                .orElseGet(()-> patientRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception{
        if(patientRepository.findById(id).isPresent()){
            patientRepository.deleteById(id);
        }
    }

}
