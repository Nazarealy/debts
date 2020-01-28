package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Diagnosis;
import ua.lviv.iot.repository.DiagnosisRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class DiagnosisService {

    @Autowired
    DiagnosisRepository diagnosisRepository;

    public List<Diagnosis> findAll() throws Exception{
        List<Diagnosis> diagnosis = new LinkedList<>(diagnosisRepository.findAll());
        if(diagnosis.isEmpty()){
            return null;
        }
        return diagnosis;
    }

    public Diagnosis findById(Integer id) throws Exception{
        if(diagnosisRepository.findById(id).isPresent()){
            return diagnosisRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Diagnosis entity) throws Exception{
        if(entity != null){
            diagnosisRepository.save(entity);
        }
    }

    @Transactional
    public void update(Diagnosis entity) throws Exception{
        diagnosisRepository.findById(entity.getIddiagnosis()).map(oldEntity ->{
            oldEntity.setDescription_diagnosis(entity.getDescription_diagnosis());
            oldEntity.setPatient_id_patient(entity.getPatient_id_patient());
            return diagnosisRepository.save(oldEntity);
        })
                .orElseGet(()-> diagnosisRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception{
        if(diagnosisRepository.findById(id).isPresent()){
            diagnosisRepository.deleteById(id);
        }
    }

}
