package ua.lviv.iot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Analysis;
import ua.lviv.iot.repository.AnalysisRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class AnalysisService {
    @Autowired
    AnalysisRepository analysisRepository;

    public List<Analysis> findAll() throws Exception{
        List<Analysis> analysis = new LinkedList<>(analysisRepository.findAll());
        if(analysis.isEmpty()){
            return null;
        }
        return analysis;
    }

    public Analysis findById(Integer id) throws Exception{
        if(analysisRepository.findById(id).isPresent()){
            return analysisRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Analysis entity) throws Exception{
        if(entity != null){
            analysisRepository.save(entity);
        }
    }

    @Transactional
    public void update(Analysis entity) throws Exception{
        analysisRepository.findById(entity.getIdanalysis()).map(oldEntity ->{
            oldEntity.setAnalysis_description(entity.getAnalysis_description());
            oldEntity.setPatient_id_patient(entity.getPatient_id_patient());
            return analysisRepository.save(oldEntity);
        })
                .orElseGet(()-> analysisRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception{
        if(analysisRepository.findById(id).isPresent()){
            analysisRepository.deleteById(id);
        }
    }

}
