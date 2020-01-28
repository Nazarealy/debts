package ua.lviv.iot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Diagnosis;
import ua.lviv.iot.service.DiagnosisService;

import java.util.List;

@RestController
@RequestMapping("/hospitallab4db")
public class DiagnosisController {
    @Autowired
    DiagnosisService diagnosisService;

    @GetMapping("/diagnosis")
    public List<Diagnosis> findAll() throws Exception{
        return diagnosisService.findAll();
    }

    @GetMapping("/diagnosis/{id}")
    public Diagnosis findById(@PathVariable Integer id) throws Exception{
        return diagnosisService.findById(id);
    }

    @PostMapping("/diagnosis")
    public void create(@RequestBody Diagnosis entity) throws Exception{
        diagnosisService.create(entity);
    }

    @PutMapping("/diagnosis/{id}")
    public void update(@PathVariable Integer id,@RequestBody Diagnosis entity) throws Exception{
        entity.setIddiagnosis(id);
        diagnosisService.update(entity);
    }

    @DeleteMapping("/diagnosis/{id}")
    public void delete(@PathVariable Integer id) throws Exception{
        diagnosisService.delete(id);
    }
}
