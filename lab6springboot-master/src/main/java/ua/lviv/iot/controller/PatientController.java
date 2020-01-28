package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Patient;
import ua.lviv.iot.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/hospitallab4db")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patient")
    public List<Patient> findAll() throws Exception{
        return patientService.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient findById(@PathVariable Integer id) throws Exception{
        return patientService.findById(id);
    }

    @PostMapping("/patient")
    public void create(@RequestBody Patient entity) throws Exception{
        patientService.create(entity);
    }

    @PutMapping("/patient/{id}")
    public void update(@PathVariable Integer id,@RequestBody Patient entity) throws Exception{
        entity.setId_patient(id);
        patientService.update(entity);
    }

    @DeleteMapping("/patient/{id}")
    public void delete(@PathVariable Integer id) throws Exception{
        patientService.delete(id);
    }
}
