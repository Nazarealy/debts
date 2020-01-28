package ua.lviv.iot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.TypeDoctor;
import ua.lviv.iot.service.TypeDoctorService;

import java.util.List;

@RestController
@RequestMapping("/hospitallab4db")
public class TypeDoctorController {

    @Autowired
    TypeDoctorService typeDoctorService;

    @GetMapping("/type_doctor")
    public List<TypeDoctor> findAll() throws Exception{
        return typeDoctorService.findAll();
    }

    @GetMapping("/type_doctor/{id}")
    public TypeDoctor findById(@PathVariable Integer id) throws Exception{
        return typeDoctorService.findById(id);
    }

    @PostMapping("/type_doctor")
    public void create(@RequestBody TypeDoctor entity) throws Exception{
        typeDoctorService.create(entity);
    }

    @PutMapping("/type_doctor/{id}")
    public void update(@PathVariable Integer id,@RequestBody TypeDoctor entity) throws Exception{
        entity.setIdtype_doctor(id);
        typeDoctorService.update(entity);
    }

    @DeleteMapping("/type_doctor/{id}")
    public void delete(@PathVariable Integer id) throws Exception{
        typeDoctorService.delete(id);
    }
}
