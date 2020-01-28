package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.RegistrationOffice;
import ua.lviv.iot.repository.RegistrationOfficeRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class RegistrationOfficeService {

    @Autowired
    RegistrationOfficeRepository registrationOfficeRepository;


    public List<RegistrationOffice> findAll() throws Exception{
        List<RegistrationOffice> registrationOffice = new LinkedList<>(registrationOfficeRepository.findAll());
        if(registrationOffice.isEmpty()){
            return null;
        }
        return registrationOffice;
    }

    public RegistrationOffice findById(Integer id) throws Exception{
        if(registrationOfficeRepository.findById(id).isPresent()){
            return registrationOfficeRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(RegistrationOffice entity) throws Exception{
        if(entity != null){
            registrationOfficeRepository.save(entity);
        }
    }

    @Transactional
    public void update(RegistrationOffice entity) throws Exception{
        registrationOfficeRepository.findById(entity.getId_of_patient()).map(oldEntity ->{
            oldEntity.setData(entity.getData());
            oldEntity.setId_medical_doctor(entity.getId_medical_doctor());
            oldEntity.setType_of_treatment(entity.getType_of_treatment());
            oldEntity.setMoney(entity.getMoney());
            oldEntity.setDoctor_iddoctor(entity.getDoctor_iddoctor());
            oldEntity.setPatient_id_patient(entity.getPatient_id_patient());
            return registrationOfficeRepository.save(oldEntity);
        })
                .orElseGet(()-> registrationOfficeRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception{
        if(registrationOfficeRepository.findById(id).isPresent()){
            registrationOfficeRepository.deleteById(id);
        }
    }
}
