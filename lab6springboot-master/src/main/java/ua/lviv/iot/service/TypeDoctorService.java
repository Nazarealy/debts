package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.TypeDoctor;
import ua.lviv.iot.repository.TypeDoctorRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class TypeDoctorService {

    @Autowired
    TypeDoctorRepository typeDoctorRepository;

    public List<TypeDoctor> findAll() throws Exception{
        List<TypeDoctor> typeDoctor = new LinkedList<>(typeDoctorRepository.findAll());
        if(typeDoctor.isEmpty()){
            return null;
        }
        return typeDoctor;
    }

    public TypeDoctor findById(Integer id) throws Exception{
        if(typeDoctorRepository.findById(id).isPresent()){
            return typeDoctorRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(TypeDoctor entity) throws Exception{
        if(entity != null){
            typeDoctorRepository.save(entity);
        }
    }

    @Transactional
    public void update(TypeDoctor entity) throws Exception{
        typeDoctorRepository.findById(entity.getIdtype_doctor()).map(oldEntity ->{
            oldEntity.setType_doctor(entity.getType_doctor());
            return typeDoctorRepository.save(oldEntity);
        })
                .orElseGet(()-> typeDoctorRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception{
        if(typeDoctorRepository.findById(id).isPresent()){
            typeDoctorRepository.deleteById(id);
        }
    }
}
