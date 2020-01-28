package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Habits;
import ua.lviv.iot.service.HabitsService;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/hospitallab4db")
public class HabitsController {

    @Autowired
    HabitsService habitsService;

    @GetMapping("/habits")
    public List<Habits> findAll() throws Exception{
        return habitsService.findAll();
    }

    @GetMapping("/habits/{id}")
    public Habits findById(@PathVariable Integer id) throws Exception{
        return habitsService.findById(id);
    }

    @PostMapping("/habits")
    public void create(@RequestBody Habits entity) throws Exception{
        habitsService.create(entity);
    }

    @PutMapping("/habits/{id}")
    public void update(@PathVariable Integer id,@RequestBody Habits entity) throws Exception{
        entity.setIdhabits(id);
        habitsService.update(entity);
    }

    @DeleteMapping("/habits/{id}")
    public void delete(@PathVariable Integer id) throws Exception{
        habitsService.delete(id);
    }
}
