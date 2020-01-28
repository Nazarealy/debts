package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.RegistrationOffice;
import ua.lviv.iot.service.RegistrationOfficeService;
import java.util.List;

@RestController
@RequestMapping("/hospitallab4db")
public class RegistrationOfficeController {

    @Autowired
    RegistrationOfficeService registrationOfficeService;

    @GetMapping("/registration_office")
    public List<RegistrationOffice> findAll() throws Exception{
        return registrationOfficeService.findAll();
    }

    @GetMapping("/registration_office/{id}")
    public RegistrationOffice findById(@PathVariable Integer id) throws Exception{
        return registrationOfficeService.findById(id);
    }

    @PostMapping("/registration_office")
    public void create(@RequestBody RegistrationOffice entity) throws Exception{
        registrationOfficeService.create(entity);
    }

    @PutMapping("/registration_office/{id}")
    public void update(@PathVariable Integer id,@RequestBody RegistrationOffice entity) throws Exception{
        entity.setId_of_patient(id);
        registrationOfficeService.update(entity);
    }

    @DeleteMapping("/registration_office/{id}")
    public void delete(@PathVariable Integer id) throws Exception{
        registrationOfficeService.delete(id);
    }
}
