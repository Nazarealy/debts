package ua.lviv.iot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Doctor;
import ua.lviv.iot.service.DoctorService;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/hospitallab4db")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctor")
    public List<Doctor> findAll() throws Exception{
        return doctorService.findAll();
    }

    @GetMapping("/doctor/{id}")
    public Doctor findById(@PathVariable Integer id) throws Exception{
        return doctorService.findById(id);
    }

    @PostMapping("/doctor")
    public void create(@RequestBody Doctor entity) throws Exception{
        doctorService.create(entity);
    }

    @PutMapping("/doctor/{id}")
    public void update(@PathVariable Integer id,@RequestBody Doctor entity) throws Exception{
        entity.setIddoctor(id);
        doctorService.update(entity);
    }

    @DeleteMapping("/doctor/{id}")
    public void delete(@PathVariable Integer id) throws Exception{
        doctorService.delete(id);
    }
}
